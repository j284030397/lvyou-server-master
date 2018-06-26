package com.dev.lvyou.model.request;

import java.io.Serializable;

/**
 * 
 * REST方式访问响应实体对象
 *
 * @author create by ZhuangZhenyan
 * 
 */

public class RestRspEntity implements Serializable {
	private static final long serialVersionUID = 1277063299363529897L;
	
	/**
	 * 调用结果（0：调用成功	-1：没有请求头	-2：参数不正确	-999：其他异常）
	 */
	private Integer invokeResult;
	
	/**
	 * 应答状态
	 */
	private Integer status;
	
	/**
	 * 应答实体对象
	 */
	private Object entity;
	
	public RestRspEntity() {
		
	}
	
	public RestRspEntity(Integer invokeResult, Integer status, Object entity) {
		this.invokeResult = invokeResult;
		this.status = status;
		this.entity = entity;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Integer getInvokeResult() {
		return invokeResult;
	}

	public void setInvokeResult(Integer invokeResult) {
		this.invokeResult = invokeResult;
	}
}
