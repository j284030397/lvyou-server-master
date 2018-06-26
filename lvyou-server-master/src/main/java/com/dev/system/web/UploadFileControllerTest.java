package com.dev.system.web;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dev.base.util.ContextUtil;
@Controller
public class UploadFileControllerTest {
		private static final Logger  log = LoggerFactory.getLogger(UploadFileControllerTest.class);
	    private final int MAX_SIZE = 1024 * 1024 * 1;   //限制用户头像的最大值为1M
	    private String[] extendNamesArray = {".jpg",".jpeg",".png"};   //用户头像的扩展名数组，方面验证
	    private String rootPath;                    //文件根路径
	    private String imageNewPath;        //头像新路径（包含头像名以及扩展名）
	    private String imageOldPath;        //头像在数据库中的原有路径（包含头像名以及扩展名）
	    private String imageNames;          //头像的新名字（时间+用户名），时间精确到毫秒
	    private String extendName ;         //头像的扩展名，进行扩展名验证，以达到对用户头像的图片类型限制
	    private String message;                 //用于返回上传头像的信息
	    private String imageURL;                //用于返回用户头像存放的物理路径
	    private MultipartFile imageFile;
	    
	    
	    
	    
	    
	    
	    //@ResponseBody  
	   // @RequestMapping ( "/showViewTest" )
	    public List showView() {
	       ModelAndView modelAndView = new ModelAndView();
	       modelAndView.setViewName( "viewName" );
	       System.out.println("showView...");
	       List list=new ArrayList();
	       Map<String,String> map=new HashMap();
	       map.put("id", "987543");
	       map.put("name", "xiaojianjun");
	       Map<String,String> map2=new HashMap();
	       map2.put("id", "987543");
	       map2.put("name", "xiaojianjun");
	       list.add(map);
	       list.add(map2);
	       modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 " );
	       return list;
	    }

	                        
	//测试时使用方法
	   // @RequestMapping(value="/uploadTest",method= RequestMethod.GET)
	    public void  upload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	    {
	    	log.debug("进入upload 方法  Get");
	        request.getRequestDispatcher("../MyJsp.jsp").forward(request,response);
	        return;
	    }
	   // @RequestMapping(value="/uploadTest",method= RequestMethod.POST)
	    //@ResponseBody
	    public Map<String,String> uploadHeadPortrait(String account,HttpServletRequest request){
	    	log.debug("进入upload 方法 Post");
	        String imageAccount = account;      //存储用户临时的用户名，以便进行文件的命名
	        Map<String,String> map = new HashMap<String,String>();
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        //获取上传头像
	        imageFile = multipartRequest.getFile("file");
	        //获取上传头像的文件名
	        String fileName = imageFile.getOriginalFilename();
	        System.out.println("OriginalFilename:"+fileName);
	        //获取文件扩展名
	        extendName = fileName.substring(fileName.lastIndexOf("."));
	        //获取上传头像的大小
	        int imageSize = (int) imageFile.getSize();
	        //验证头像的扩展名是否符合要求
	        if((extendName.equals(extendNamesArray[0])||extendName.equals(extendNamesArray[1])||extendName.equals(extendNamesArray[2]))&&(imageSize<=MAX_SIZE)){
	           // rootPath =  request.getSession().getServletContext().getRealPath("//upload");
	           // Constants.CONTEXT_PATH
	            rootPath=ContextUtil.getCtx().getRealPath("//upload");
	            
	            System.out.println("rootPath:"+rootPath);
	            imageNames = getUploadCurrentTime() + imageAccount; //重新命名上传头像名称
	            System.out.println("imageNames:"+imageNames);
	            imageNewPath = rootPath+"\\"+imageNames+extendName;
	            System.out.println("imageNewPath:"+imageNewPath);
	            //判断新路径是否等于数据库中已存在的路径，不等于，则存储新路径，删除原有头像文件
	            if(!imageNewPath.equals("")){
	                if(imageNewPath!=""){
	                    File file = new File("");
	                    if(imageSave(imageNewPath)){
	                        if(file.exists()){
	                            file.delete();
	                        }
	                        message = "头像上传成功";
	                        imageURL = imageNewPath;
	                        map.put("message",message);
	                        map.put("imageURL",imageURL);
	                    }else{
	                        //保存失败
	                        message = "头像保存失败";
	                        imageURL = null;
	                        map.put("message",message);
	                        map.put("imageURL",imageURL);
	                                            
	                    }
	                                        
	                }
	                                    
	            }else{
	                message = "头像上传失败";
	                imageURL = null;
	                map.put("message",message);
	                map.put("imageURL",imageURL);
	            }
	                                
	        }else{      //图像格式不符合或者头像的大小大于1M
	            message = "头像上传失败，格式或大小不符合";
	            imageURL = null;
	            map.put("message",message);
	            map.put("imageURL",imageURL);
	        }
	        return map;
	    }
	    //获取头上上传的当前时间
	    private String getUploadCurrentTime(){
	        return new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date() );
	    }
	    //获取数据库中原有路径，如有则返回路径，否则返回可能为空或“”
//	    private String getDatabaseImageOldPath(String account){
//	        UserDetail userDetatilOldPath=userService.findByUsername(account).getDetail();
//	        imageOldPath =  userDetatilOldPath.getAvatar();
//	        return imageOldPath;
//	    }
	    //对原有头像的新路径进行存储，存储后进行检查，时候已经存储，存储成功返回true，失败则返回false
	    private boolean imageSave(String imageNewPath){
	        File uploadFile = new File(imageNewPath);
	        try {
	            FileCopyUtils.copy(imageFile.getBytes(), uploadFile);
	            FileUtils.copyInputStreamToFile(imageFile.getInputStream(), new File(imageNewPath));
//	            UserDetail ud=userService.findByUsername(account).getDetail();
//	            ud.setAvatar(imageNewPath);     //设置头像新路径
//	            userDetailService.update(ud) ;      //对头像进行数据库更新操作
//	            if(getDatabaseImageOldPath(account)!=null||getDatabaseImageOldPath(account).equals("")){
//	                return true;
//	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("【上传头像失败...】");
	            return false;
	        }
	        return false;
	    }
//	    @Autowired
//	    private UserDetailService userDetailService;
//	    @Autowired
//	    private UserService userService;
	    
	    
	    //++++++++++++++++以下为参考+++++++++++++++++++
//	    1、创建一个控制类: FileUploadController，一个返回提交文件的页面
//	    2、编写提交表单的action:
//
//	    3、使用SpringMVC注解RequestParam来指定表单中的idPic参数；
//	    4、指定一个用于保存文件的web项目路径
//	    5、通过MultipartFile的transferTo(File dest)这个方法来转存文件到指定的路径。MultipartFile转存后，无法再操作，会报错
	    /** 
	     * 多文件上传 
	     * @param multipartfiles 
	     * @return 
	     * @throws IllegalStateException 
	     * @throws IOException 
	     * 对应表单
	     * <form action="multiUploadId" method="post" enctype="multipart/form-data">  
		    <input type="file" name="idPic" />  
		    <input type="file" name="idPic" />  
		    <input type="file" name="idPic" />  
		    <button >Submit</button>  
		</form>  
	     */  
	    @Autowired  
	    private HttpServletRequest request;  
	   // @RequestMapping(value = "/multiUploadId")  
	    public String multiUpload(@RequestParam("idPic") MultipartFile[] multipartfiles)   
	            throws IllegalStateException, IOException {  
	        //保存文件的目录  
	        String savePath = request.getSession().getServletContext().getRealPath("/") + "/uploadTempDirectory/";  
	        if(null != multipartfiles && multipartfiles.length > 0){  
	            //遍历并保存文件  
	            for(MultipartFile file : multipartfiles){  
	                file.transferTo(new File(savePath + file.getOriginalFilename()));  
	            }  
	        }  
	        return "redirect:uploadPage";  
	    } 
	    
	    /** 
	     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile  
	     * @param multipartfile 
	     * @return 
	     * @throws IOException  
	     */  
	   //// @RequestMapping(value = "/uploadId")  
	   // @ResponseBody  
	    public ResponseEntity<byte[]> idIdentification(@RequestParam("idPic") MultipartFile multipartfile) throws IOException {  
	        System.out.println("getOriginalFilename:"+multipartfile.getOriginalFilename());  
	        System.out.println("getName:"+multipartfile.getName());  
	        // 设置格式,图片  
	        HttpHeaders headers = new HttpHeaders();  
	        headers.setContentType(MediaType.IMAGE_JPEG);  
	          
	        //保存文件到临时目录  
	        String savePath = request.getSession().getServletContext().getRealPath("/")  
	                + "/uploadTempDirectory/" + multipartfile.getOriginalFilename();  
	        File saveFile = new File(savePath);  
	        multipartfile.transferTo(saveFile);  
	        //页面显示用户上传的图片  
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);  
	    }  
	}
