package cn.jt.tool;



import cn.jt.pojo.Admin;

public class UserThreadLocal {
	
	//如果保存数据有多个,则使用Map集合
	private static ThreadLocal<Admin> userThread = new ThreadLocal<Admin>();
	
	public static void set(Admin admin){
		
		userThread.set(admin);
	}
	
	public static Admin get(){
		
		return userThread.get();
	}
	
	//线程销毁方法
	public static void remove(){
		
		userThread.remove();
	}
}
