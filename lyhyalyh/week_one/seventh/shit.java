package lyhyalyh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class shit {
	public Map<String,Student> stu;
    public shit() {
        this.stu=new HashMap<String,Student>();
    }
	public void add(){
		System.out.println("��������Ҫ���ӵ�ѧ��ѧ�ţ�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(!stu.containsKey(str1)){
			System.out.println("������ѧ��������");
			@SuppressWarnings("resource")
			Scanner name=new Scanner(System.in);
			String str2=name.nextLine();
			Student stud=new Student(str1,str2);
			stu.put(str1,stud);
		}else{
			System.out.println("ѧ���ظ���");
		}
	}
	public void delete(){
		System.out.println("��������Ҫɾ����ѧ��ѧ�ţ�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(stu.containsKey(str1)){
			if(stu.remove(str1) != null){
				System.out.println("ɾ���ɹ���");
			}
		}else{
			System.out.println("�����ڴ�ѧ����");
		}
	}
	public void replace(){
		System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(stu.containsKey(str1)){
			System.out.println("��������Ҫ�޸ĵ�������");
			@SuppressWarnings("resource")
			Scanner name=new Scanner(System.in);
			String str2=name.nextLine();
			Student stud=new Student(str1,str2);
			stu.put(str1,stud);
		}else{
			System.out.println("�����ڴ�ѧ����");
		}
	}
	public void search(){
		System.out.println("��������Ҫ��ѯ��ѧ��ѧ�ţ�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(stu.containsKey(str1)){
			System.out.println(stu.get(str1).getname()+"  "+stu.get(str1).getnumber());
		}else{
			System.out.println("�����ڴ�ѧ����");
		}
	}
}
