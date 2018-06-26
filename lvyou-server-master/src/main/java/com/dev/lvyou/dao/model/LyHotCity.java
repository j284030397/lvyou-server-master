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
@Table(name="T_Ly_HotCity") 
public class LyHotCity  extends BaseObject{
	private static final long serialVersionUID = -7681644943973061799L;
	
	public static final String T_NAME = "T_Ly_HotCity";
	
	public final static String C_SID="SID";
	public final static String C_CITYSID="CitySid";
	public final static String C_TOTALPEOPLE="TotalPeople";
	public final static String C_CTIME="CTime";
	public final static String C_MEMO="Memo";

	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="SID")	 
	private Integer sid;  


	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "CitySid")
	private LyAreaInfo lyAreaInfo;	
	public LyAreaInfo getLyAreaInfo() {
		return lyAreaInfo;
	}
	public void setLyAreaInfo(LyAreaInfo lyAreaInfo) {
		this.lyAreaInfo = lyAreaInfo;
	}


	@Column(name="TotalPeople")	 
	private Integer totalPeople;

	@Column(name="CTime")	 
	private Timestamp cTime;

	@Column(name="Memo",length=200)	 
	private String memo;

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getTotalPeople() {
		return totalPeople;
	}
	public void setTotalPeople(Integer totalPeople) {
		this.totalPeople = totalPeople;
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
