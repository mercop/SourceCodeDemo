package com.marving.code.java.jvm.oom;


/**
 * 栈溢出
 * VM args：-Xss10M
 * Created by mercop on 2017/7/15.
 */
public class JavaVMStackOOM {
	private void dontStop(){
		while(true){
			
		}	
	}
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable(){

				@Override
				public void run() {
					dontStop();
				}
				
			});
			thread.start();
		}
	}
	public static void main(String[] args){
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
