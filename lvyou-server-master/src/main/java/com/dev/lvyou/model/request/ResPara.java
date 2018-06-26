package com.dev.lvyou.model.request;

public class ResPara {
	public ResponseHeader responseHeader;
	public Object msgbody;
	
	
	public Object getMsgbody() {
		return msgbody;
	}
	public void setMsgbody(Object msgbody) {
		this.msgbody = msgbody;
	}

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	

	public static class PageObj {
		public String pageSize;

		public String getPageSize() {
			return pageSize;
		}

		public void setPageSize(String pageSize) {
			this.pageSize = pageSize;
		}

		public String getCurrPage() {
			return currPage;
		}

		public void setCurrPage(String currPage) {
			this.currPage = currPage;
		}

		public String currPage;
	}
}
