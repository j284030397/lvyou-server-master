package com.dev.system.web.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.base.spring.SpringContextHolder;
import com.dev.system.dao.model.SysUploadfile;
import com.dev.system.service.SysUploadfileService;


/**
 * 处理附件上传的Servlet
 */
public class AjaxFileUpload extends HttpServlet {		
	private static final long serialVersionUID = 1L;	
	private static final Logger  log = LoggerFactory.getLogger(AjaxFileUpload.class);
	
	/**
	 * 图片限制大小
	 */
	private static long IMG_FILE_SIZE_LIMIT = 100 * 1024 ;       //100K 2988938	
	/**
	 * 附件限制大小
	 */
	private static long FILE_SIZE_LIMIT     = 20 * 1024 * 1024 ; //20M
	/**
	 * 私人附件限制大小
	 */
	private static long PRIVATEFILE_SIZE_LIMIT     = 3 * 1024 * 1024 ; //3M
	/**
	 * 私人附件限制大小[警告语句]
	 */
	private static String PRIVATEFILE_SIZE_LIMIT_ALERT = "3MB" ;
	/**
	 * 上传的绝对路径
	 */
	private static String uploadPath   = null ;	
	/**
	 * 上传的相对路径
	 */
	private static String relativePath = null ;
	
	/**
	 * 初始化Servlet
	 */
	public void init() throws ServletException { 	
		uploadPath = getInitParameter("upload_save_path") ;	
		
		String fileLimit = getInitParameter("IMG_FILE_SIZE_LIMIT") ;	
		if(fileLimit!=null && fileLimit.trim().length() > 0){
			try{
				FILE_SIZE_LIMIT = Long.parseLong(fileLimit) ;
			}catch(Exception e){				
			}
		}
		String imgFileLimit = getInitParameter("IMG_FILE_SIZE_LIMIT") ;	
		if(imgFileLimit!=null && imgFileLimit.trim().length() > 0){
			try{
				IMG_FILE_SIZE_LIMIT = Long.parseLong(imgFileLimit) ;
			}catch(Exception e){				
			}
		}
		
		String privatefileLimit = getInitParameter("PRIVATEFILE_SIZE_LIMIT") ;	
		if(privatefileLimit!=null && privatefileLimit.trim().length() > 0){
			try{
				PRIVATEFILE_SIZE_LIMIT = Long.parseLong(privatefileLimit) ;
			}catch(Exception e){				
			}
		}
		
		String privatefileAlert = getInitParameter("PRIVATEFILE_SIZE_LIMIT_ALERT") ;	
		if(privatefileAlert!=null && privatefileAlert.trim().length() > 0){
			try{
				PRIVATEFILE_SIZE_LIMIT_ALERT = privatefileAlert ;
			}catch(Exception e){				
			}
		}

		ServletContext sc = getServletContext() ;
		
		if(uploadPath==null || uploadPath.trim().length()==0){			
			uploadPath = sc.getRealPath("/") + "uploadfile/" ;			
			relativePath = "/uploadfile/" ;
		}
		else if(uploadPath.startsWith("/")){
			relativePath = uploadPath ;			
			uploadPath = sc.getRealPath("") + uploadPath;			
		}
		else {
			relativePath = "/" + uploadPath ;
			uploadPath = sc.getRealPath("/") + uploadPath ;		
		}
		
		if(!relativePath.endsWith("/")){
			relativePath += "/" ;
		}
		
		File f = new File(uploadPath) ;
		
		if(!f.exists()){
			f.mkdirs() ;
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response) ;
	}
	
	public void doPost(HttpServletRequest request, 
					   HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8") ;
		
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(4096);		 // 设置缓冲区大小，这里是4kb

        ServletFileUpload upload = new ServletFileUpload(factory);
        
		try {
			List fileItems = upload.parseRequest(request);
			
			if(fileItems.isEmpty()){
				return ;
			}
            
			StringBuffer fileUrls = new StringBuffer() ;
			
			String strFileType = request.getParameter("fileType") ;			
			String isFileToDb = request.getParameter("isFileToDb") ; 		
			String webSiteId = request.getParameter("webSiteId") ; 
		     System.out.println("strFileType"+strFileType+",isFileToDb"+isFileToDb+",webSiteId"+webSiteId);
			int fileType = -1;
			if (strFileType != null && strFileType.trim().length() > 0){
				fileType = Integer.parseInt(strFileType);
			}
			Iterator iterator = fileItems.iterator();
			while(iterator.hasNext()){
	            DiskFileItem fi = (DiskFileItem)iterator.next();
	        	//FileItem fi = (FileItem) iterator.next();
	        	
	            if (!fi.isFormField()) {
	                String fileName = fi.getName().toLowerCase() ;	                	               
	                
	                if(log.isDebugEnabled()){
	                	log.debug("upload fileName:" + fileName) ;
	                }
	                
	                if(fileName.indexOf("\\") > -1){
	                	int index = fileName.lastIndexOf("\\") ;
	                	fileName = fileName.substring(index + 1) ;
	                }
	                else if(fileName.indexOf("/") > -1){
	                	int index = fileName.lastIndexOf("/") ;
	                	fileName = fileName.substring(index + 1) ;
	                }
	                
	                if (fileName.indexOf(",") >= 0) throw new Exception("文件名内不能含有\",\"！");
	              	
	                if(fileType == -1){
	            		fileType = parseFileType(fileName);
	                }
	                
	                long fileSize = fi.getSize() ; 	
	                
	                String errorMsg = checkFileSize(fileType, fileSize);
		            if(errorMsg != null){
		                jsonResponse(false, null, response, errorMsg) ;
		                return ;
		            }
		    			
		            SysUploadfile uploadFile = new SysUploadfile() ;
		                
		            uploadFile.setFileName(fileName) ;
		            uploadFile.setFileSize(fileSize) ;
		            uploadFile.setFileType(fileType) ;
		            
		       
		                
		            this.createSysUploadfile(request, fi, uploadFile, webSiteId, isFileToDb);
		           
		            if (isFileToDb != null && isFileToDb.trim().length() > 0 && isFileToDb == "true"){
		        	    fileUrls.append("/uploadFile/uploadFileAction.do?action=SHOW_FILE&id=")
		        	    		.append(uploadFile.getSid());
		            }
		            else{
		        	    fileUrls.append(uploadFile.getFileUrl()).append("?id=").append(uploadFile.getSid());
		            }
		            fileUrls.append("|").append(uploadFile.getFileName()).append("|")
		            		.append(uploadFile.getFileSize()).append("|")
		            		.append(uploadFile.getImgWidth() == null ? "0" : uploadFile.getImgWidth().toString()).append("|")
		            		.append(uploadFile.getImgHeight() == null ? "0" : uploadFile.getImgHeight());
	             }	
	             //break ;
	        }			
	        jsonResponse(true, fileUrls.toString(), response, "成功上传文件！") ;	 
		} 
		catch (Exception e) {
			e.printStackTrace();
			try {
				jsonResponse(false, null, response, "上传文件失败！[" + e.getMessage() + "]") ;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * 创建上传文件对象
	 * @param request
	 * @param fileItem   文件对象
	 * @param uploadFile 文件对象信息
	 * @param webSiteId  所属站点编号[可为空]
	 * @param isFileToDb 是否将文件存入数据库[可为空]
	 * @throws Exception
	 */
	private void createSysUploadfile(HttpServletRequest request, 
								  FileItem fileItem, 
								  SysUploadfile uploadFile, 
								  String webSiteId, 
								  String isFileToDb) throws Exception{
        HttpSession session = request.getSession() ;            
       // SysUser sysUser = (SysUser) session.getAttribute(Constants.LOGIN_USER) ;	             
		//SysUploadfileService sysUploadfileService = (SysUploadfileService) BeanFactoryUtil.getBean("sysUploadfileService") ;
//		if (sysUser == null){
//			uploadFile.setUserId("0");
//		}
//		else{
//			uploadFile.setUserId(sysUser.getSid().toString());
//		}
//		if (isFileToDb != null && isFileToDb.trim().length() > 0 && isFileToDb == "true"){
//            byte[] ba = fileItem.get() ;		                
//            uploadFile.setFileData(ba) ;
//        }
//		else{
			String fileUrl = this.createNewFile(fileItem, uploadFile, webSiteId, request);
			uploadFile.setFileUrl(fileUrl);
//		}
		
		if (webSiteId != null && webSiteId.trim().length() > 0){
			uploadFile.setWebSiteId(Integer.parseInt(webSiteId));
		}
		//SysUploadfileService sysUploadfileService = (SysUploadfileService) SpringContextHolder.getBean("sysUploadfileService");
		//sysUploadfileService.createSysUploadfile(uploadFile, uploadPath);
	}
	
	/**
	 * 创建文件
	 * @param fileItem   文件对象
	 * @param uploadFile 文件对象信息
	 * @param webSiteId  所属站点编号[可为空]
	 * @return
	 * @throws Exception
	 */
	public String createNewFile(FileItem fileItem, SysUploadfile uploadFile, String webSiteId, HttpServletRequest request) throws Exception{
		StringBuffer fileUrl_relativePath = new StringBuffer(64);
//		fileUrl_relativePath.append(uploadPath).append("/");
		File file = null;
		if (webSiteId != null && webSiteId.trim().length() > 0){
			fileUrl_relativePath.append("webSite_").append(webSiteId);
		}
		else if (SysUploadfile.FILETYPE_PRIVATE == uploadFile.getFileType()){
			fileUrl_relativePath.append("private");			
		}
		else{
			fileUrl_relativePath.append("publicFile");
		}
		file = new File(uploadPath + "/" + fileUrl_relativePath.toString());
		if (!file.exists()){
			file.mkdir();
		}
		fileUrl_relativePath.append("/");
		
		switch(uploadFile.getFileType()){
			case SysUploadfile.FILETYPE_IMAGE:
				fileUrl_relativePath.append("image");
				break;
			case SysUploadfile.FILETYPE_VIEDO:
				fileUrl_relativePath.append("viedo");
				break;
			case SysUploadfile.FILETYPE_ATT:
				fileUrl_relativePath.append("att");
				break;
			case SysUploadfile.FILETYPE_NORMALFILE:
				fileUrl_relativePath.append("normalFile");
				break;
			case SysUploadfile.FILETYPE_CONTENTIMAGE:
				fileUrl_relativePath.append("contentImage");
				break;
			case SysUploadfile.FILETYPE_PRIVATE:
				HttpSession htsession = request.getSession();
				//SysUser sysUser = (SysUser) htsession.getAttribute(Constants.LOGIN_USER);
				//fileUrl_relativePath.append(sysUser.getSid());
				break;
			case SysUploadfile.FILETYPE_FLASH:
				fileUrl_relativePath.append("flash");
				break;
			case SysUploadfile.FILETYPE_TEMPLATE:
				fileUrl_relativePath.append("template");
				break;
			case SysUploadfile.FILETYPE_EXCEL:
				fileUrl_relativePath.append("excel");
				break;
			case SysUploadfile.FILETYPE_TMP:
				fileUrl_relativePath.append("temp");
				break;
		}
		file = new File(uploadPath + fileUrl_relativePath.toString());
		if (!file.exists()){
			file.mkdir();
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		fileUrl_relativePath.append("/").append(simpleDateFormat.format(new Date(System.currentTimeMillis())));
		file = new File(uploadPath + fileUrl_relativePath.toString());
		if (!file.exists()){
			file.mkdir();
		}		
		fileUrl_relativePath.append("/");
		
        Random r = new Random() ;	
        fileUrl_relativePath.append(r.nextInt(1000)).append(System.currentTimeMillis());
        
        String fileName = uploadFile.getFileName();
        fileUrl_relativePath.append(fileName.subSequence(fileName.lastIndexOf("."), fileName.length()));
        
        file = new File(uploadPath + "/" + fileUrl_relativePath.toString()) ;
        file.createNewFile() ;		                
        fileItem.write(file) ;
        
        return relativePath + fileUrl_relativePath.toString();
	}
	
	/**
	 * 校验文件大小
	 * @param fileType 文件类型
	 * @param fileSize 文件大小
	 * @return
	 */
	private String checkFileSize(Integer fileType, Long fileSize){
		String errorMsg = null;
		
//        if(SysUploadfile.FILETYPE_IMAGE == fileType){
//           	if(fileSize > IMG_FILE_SIZE_LIMIT){
//           		errorMsg = "上传的图片不能超过100K,请处理后再试!" ;
//    		}
//        }
//        else if(SysUploadfile.FILETYPE_VIEDO == fileType){
//            if(fileSize > VID_FILE_SIZE_LIMIT){
//            	errorMsg = "上传的图片不能超过10K,请处理后再试!" ;
//    		}
//        }
//        else if(SysUploadfile.FILETYPE_ATT == fileType){
//            if(fileSize > ATT_FILE_SIZE_LIMIT){
//            	errorMsg = "上传的附件不能超过20M,请处理后再试!" ;
//    		}
//        }
//        else {
//            if(fileSize > FILE_SIZE_LIMIT){
//            	errorMsg = "上传的附件不能超过20M,请处理后再试!" ;
//    		}
//        }
		
		if (SysUploadfile.FILETYPE_PRIVATE == fileType){
			if (fileSize > PRIVATEFILE_SIZE_LIMIT){
				errorMsg = "上传的附件不能超过" + PRIVATEFILE_SIZE_LIMIT_ALERT + ",请处理后再试!" ;
			}
		}
        return errorMsg;
	}

	/**
	 * 获取上传文件的类型
	 * @param fileName 文件名(含有后缀名)
	 * @return
	 */
	private Integer parseFileType(String fileName) {
		Integer fileType;
		if(fileName.endsWith(".jpg") || fileName.endsWith(".gif") || fileName.endsWith(".bmp") 
				|| fileName.endsWith(".png") || fileName.endsWith(".tif") || fileName.endsWith(".wmf")){
			fileType = SysUploadfile.FILETYPE_IMAGE ;
			
		} 
		else if( fileName.endsWith(".rar") || fileName.endsWith(".zip")
				|| fileName.endsWith(".jar") || fileName.endsWith(".war")  
				|| fileName.endsWith(".ear")){
			fileType = SysUploadfile.FILETYPE_ATT ;
			
		} 
		else if(fileName.endsWith(".asf") || fileName.endsWith(".wma") || fileName.endsWith(".mp3")
				|| fileName.endsWith(".mov") || fileName.endsWith(".avi") || fileName.endsWith(".midi")
				|| fileName.endsWith(".mp4") || fileName.endsWith(".wav") || fileName.endsWith(".au") 
				|| fileName.endsWith(".vod")){
			fileType = SysUploadfile.FILETYPE_VIEDO ;
		}
		else{
			fileType = SysUploadfile.FILETYPE_NORMALFILE ;
		}
		return fileType;
	}

	/**
	 * 反馈给前台信息
	 * @param success  是否成功
	 * @param fileUrls 反馈文件路径(包含有文件大小，以"|"分割)
	 * @param response
	 * @param msg      反馈消息
	 * @throws IOException
	 */	
	private void jsonResponse( boolean success ,
			 				   String fileUrls ,
							   HttpServletResponse response,
							   String msg) throws IOException {

	 	 response.setContentType("text/html;charset=UTF-8") ; //(JsonUtil.CONTENT_TYPE_JSON);		
	 				 	 	 	 
	 	 PrintWriter out = response.getWriter();	 	 
	 	 if(success){
	 		out.print("{success:true,message:'" + msg + "',fileUrls:'" + fileUrls + "'}");	
	 	 }
	 	 else{
	 		out.print("{success:false,error:'" + msg + "'}");
	 	 }
	}
}