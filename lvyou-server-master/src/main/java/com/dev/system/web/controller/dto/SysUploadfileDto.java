package com.dev.system.web.controller.dto;
import java.sql.Timestamp;
import com.dev.model.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("sysUploadfile")
public class SysUploadfileDto extends BaseObject{


		@JsonProperty("sid")
		private Long sid;  
		@JsonProperty("fileName")
		private String fileName;  
		@JsonProperty("fileSize")
		private Long fileSize;  
		@JsonProperty("fileType")
		private Integer fileType;  
		@JsonProperty("createDate")
		private Timestamp createDate;  
		@JsonProperty("userId")
		private String userId;  
		@JsonProperty("webSiteId")
		private Integer webSiteId;  
		@JsonProperty("fileUrl")
		private Integer fileUrl;  
		@JsonProperty("imgWidth")
		private Integer imgWidth;  
		@JsonProperty("imgHeight")
		private Integer imgHeight;  
		//region 字典
		/**
		 * 文件类型：图片
		 */
		public final static int FILETYPE_IMAGE = 0 ;	  
		/**
		 * 文件类型：视频
		 */ 
		public final static int FILETYPE_VIEDO = 1 ;
		/**
		 * 文件类型：附件压缩文档
		 */
		public final static int FILETYPE_ATT = 2 ;
		/**
		 * 文件类型：普通文档	
		 */
		public final static int FILETYPE_NORMALFILE = 3 ;
		/**
		 * 文件类型：正文图片	
		 */
		public final static int FILETYPE_CONTENTIMAGE = 4 ;
		/**
		 * 文件类型：私人文件	
		 */
		public final static int FILETYPE_PRIVATE = 5 ;
		/**
		 * 文件类型：FLASH文件	
		 */
		public final static int FILETYPE_FLASH = 6 ;
		/**
		 * 文件类型：模板文件
		 */
		public final static int FILETYPE_TEMPLATE = 7;
		/**
		 * 文件类型：Excel文件
		 */
		public final static int FILETYPE_EXCEL = 8;
		/**
		 * 文件类型：临时保存文件
		 */
		public final static int FILETYPE_TMP = 9 ; 
		//endregion
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	public Integer getFileType() {
		return fileType;
	}
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public Integer getWebSiteId() {
		return webSiteId;
	}
	public void setWebSiteId(Integer webSiteId) {
		this.webSiteId = webSiteId;
	}
	
	
	public Integer getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(Integer fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	
	public Integer getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(Integer imgWidth) {
		this.imgWidth = imgWidth;
	}
	
	
	public Integer getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(Integer imgHeight) {
		this.imgHeight = imgHeight;
	}
	

	@Override
	public String toString() {
		return "sysUploadfile [sid=" + sid + ",fileName=" + fileName + ",fileSize=" + fileSize + ",fileType=" + fileType + ",createDate=" + createDate + ",userId=" + userId + ",webSiteId=" + webSiteId + ",fileUrl=" + fileUrl + ",imgWidth=" + imgWidth + ",imgHeight=" + imgHeight + "]";
	}

}

