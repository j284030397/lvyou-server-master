package com.dev.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dev.model.BaseObject;

/**
 * 
 * @struts.form include-all="true" extends="BaseForm"
 * @hibernate.class table="T_SYS_ALLOTPOWER"
 * @hibernate.comment 分配权限表
 *
 */
@Entity  
@Table(name="T_SYS_ALLOTPOWER") 
public class SysAllotPower extends BaseObject {
	private static final long serialVersionUID = 1L;
	@Id  
	@GeneratedValue(strategy= GenerationType.AUTO)  
	@Column(name="id")	 
	private Integer id;							 //编号
	@Column(name="roleId")	 
	private Integer roleId;						 //角色编号
	@Column(name="powerId")	 
	private Integer powerId;					 //权限编号
	@Column(name="resourceCode",length=200)	 
	private String resourceCode;				 //资源编码
	
	
	/**
	 * @hibernate.id unsaved-value="null"
	 * @hibernate.generator class="native"
	 * @hibernate.column comment="主键ID"
     * @form.no_search
     * @form.no_list
	 * @return id 
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @hibernate.property
	 * @hibernate.column not-null="true" comment="角色编号"
	 */
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * @hibernate.property
	 * @hibernate.column not-null="true" comment="权限编号"
	 */
	public Integer getPowerId() {
		return powerId;
	}
	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}
	
	/**
	 * @hibernate.property
	 * @hibernate.column not-null="true" comment="资源编码"
	 */
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	/**
	 * Returns <code>true</code> if this <code>SysAllotPower</code> is the same as the o argument.
	 *
	 * @return <code>true</code> if this <code>SysAllotPower</code> is the same as the o argument.
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != getClass()) {
			return false;
		}
		SysAllotPower castedObj = (SysAllotPower) o;
		return ((this.id == null ? castedObj.id == null : this.id
			.equals(castedObj.id))
			&& (this.roleId == null ? castedObj.roleId == null : this.roleId
				.equals(castedObj.roleId))
			&& (this.powerId == null ? castedObj.powerId == null : this.powerId
				.equals(castedObj.powerId)) && (this.resourceCode == null
			? castedObj.resourceCode == null
			: this.resourceCode.equals(castedObj.resourceCode)));
	}
	/**
	 * Override hashCode.
	 *
	 * @return the Objects hashcode.
	 */
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = 31 * hashCode + (id == null ? 0 : id.hashCode());
		hashCode = 31 * hashCode + (roleId == null ? 0 : roleId.hashCode());
		hashCode = 31 * hashCode + (powerId == null ? 0 : powerId.hashCode());
		hashCode = 31
			* hashCode
			+ (resourceCode == null ? 0 : resourceCode.hashCode());
		return hashCode;
	}
	public String toString() {
			StringBuffer buffer = new StringBuffer();
			buffer.append("[SysAllotPower:");
			buffer.append(" id: ");
			buffer.append(id);
			buffer.append(" roleId: ");
			buffer.append(roleId);
			buffer.append(" powerId: ");
			buffer.append(powerId);
			buffer.append(" resourceCode: ");
			buffer.append(resourceCode);
			buffer.append("]");
			return buffer.toString();
		}
}
