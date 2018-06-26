package com.dev.lvyou.dao.model;
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
@Table(name="T_Ly_UserSessionInfo") 
public class LyUserSessionInfo  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_UserSessionInfo";
	
	public final static String C_SID="SID";
	public final static String C_TOKEN="Token";
	public final static String C_USERSID="UserSid";
	public final static String C_USERNAME="UserName";
	public final static String C_CHANNELCODE="ChannelCode";
	public final static String C_LOGINTIME="LoginTime";
	public final static String C_EXPIRETIME="ExpireTime";
	public final static String C_LASTLIVETIME="LastLiveTime";
	public final static String C_STATUS="Status";
	public final static String C_SESSIONID="SessionId";
	public final static String C_POS="Pos";
	public final static String C_CTIME="CTime";
	public final static String C_MEMO="Memo";

	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="SID")	 
	private Integer sid;  



	@Column(name="Token",length=50)	 
	private String token;

	@Column(name="UserSid")	 
	private Integer userSid;

	@Column(name="UserName",length=50)	 
	private String userName;

	@Column(name="ChannelCode",length=30)	 
	private String channelCode;

	@Column(name="LoginTime")	 
	private Timestamp loginTime;

	@Column(name="ExpireTime")	 
	private Timestamp expireTime;

	@Column(name="LastLiveTime")	 
	private Timestamp lastLiveTime;

	@Column(name="Status")	 
	private Integer status;

	@Column(name="SessionId",length=100)	 
	private String sessionId;

	@Column(name="Pos")	 
	private Integer pos;

	@Column(name="CTime")	 
	private Timestamp cTime;

	@Column(name="Memo",length=200)	 
	private String memo;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getUserSid() {
		return userSid;
	}
	public void setUserSid(Integer userSid) {
		this.userSid = userSid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public Timestamp getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}
	public Timestamp getLastLiveTime() {
		return lastLiveTime;
	}
	public void setLastLiveTime(Timestamp lastLiveTime) {
		this.lastLiveTime = lastLiveTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getPos() {
		return pos;
	}
	public void setPos(Integer pos) {
		this.pos = pos;
	}
	public Timestamp getCTime() {
		return cTime;
	}
	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
