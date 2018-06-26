package com.dev.lvyou.model.request;

public class ReqParaExt<Object> extends ReqPara {
	public Object getMsgbody() {
		return msgbody;
	}

	public void setMsgbody(Object msgbody) {
		this.msgbody = msgbody;
	}

	public Object msgbody;
}
