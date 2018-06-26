package com.dev.system.dao.model;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.dev.model.BaseObject;
/*
* tableComment
*/
@Entity  
@Table(name="T_Sys_Uploadfile") 
public class SysUploadfile  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Sys_Uploadfile";
	
	public final static String C_SID="sid";
	public final static String C_FILENAME="fileName";
	public final static String C_FILESIZE="fileSize";
	public final static String C_FILETYPE="fileType";
	public final static String C_CREATEDATE="createDate";
	public final static String C_USERID="userId";
	public final static String C_WEBSITEID="webSiteId";
	public final static String C_FILEURL="fileUrl";
	public final static String C_IMGWIDTH="imgWidth";
	public final static String C_IMGHEIGHT="imgHeight";
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
	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="sid")	 
	private Long sid;  



	@Column(name="fileName",length=200)	 
	private String fileName;

	@Column(name="fileSize")	 
	private Long fileSize;

	@Column(name="fileType")	 
	private Integer fileType;

	@Column(name="createDate")	 
	private Timestamp createDate;

	@Column(name="userId",length=50)	 
	private String userId;

	@Column(name="webSiteId")	 
	private Integer webSiteId;

	@Column(name="fileUrl",length=200)	 
	private String fileUrl;

	@Column(name="imgWidth")	 
	private Integer imgWidth;

	@Column(name="imgHeight")	 
	private Integer imgHeight;

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
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
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
		// TODO Auto-generated method stub
		return null;
	}
}
