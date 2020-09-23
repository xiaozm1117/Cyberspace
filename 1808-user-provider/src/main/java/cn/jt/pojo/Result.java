package cn.jt.pojo;

public class Result {
	private Object data;
	private String msg;
	private int state=400;
	
	public Result(String s) {
		this.msg=s;
		if(s=="ok"){
			this.state=200;}else {
			this.state=400;}
	}
	
	public Result(Object obj) {
		this.data=obj;
		this.msg="ok";
		this.state=200;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return msg;
	}
	public void setMessage(String message) {
		this.msg = message;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
