package lyhyalyh;


import java.util.Scanner;

public class seventh {
	public static void main(String[] args){
		shit map=new shit();
		System.out.println("����������ִ�еĲ�����\n1:����ѧ����Ϣ\n2��ɾ��ѧ����Ϣ\n3���޸�ѧ����Ϣ\n4����ѯѧ����Ϣ\n5: �˳�");
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		int i=input.nextInt();
		for(;;){
			switch(i){
			case 1:
				map.add();
				break;
			case 2:
				map.delete();
				break;
			case 3:
				map.replace();
				break;
			case 4:
				map.search();
				break;
			case 5:
				return;
			default:
				System.out.println("�������");
				}
			input=new Scanner(System.in);
			i=input.nextInt();
			}
		}
}
