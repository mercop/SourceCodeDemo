package com.marving.code.java.jvm.oom;

public class RuntimeConstantPoolOOM {
	public static void main(String[] args){
		//�������Ѵ���
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern()== str2);
		
		//�״�ʹ��
		String str1 = new StringBuilder("�����").append("���").toString();
		System.out.println(str1.intern() == str1);

	}
}
