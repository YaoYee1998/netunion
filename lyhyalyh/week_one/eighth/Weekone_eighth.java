package lyh;

import java.util.Scanner;

public class Weekone_eighth {
	public static void main(String[] args){
		MapEighth map=new MapEighth();
		System.out.println("����������ִ�еĲ�����\n1: ѡ��γ�\n2��ɾ����ѡ�γ�\n3���޸���ѡ�γ�\n4���鿴��ѡ�γ�\n5: �˳�");
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
			System.out.println("����������ִ�еĲ�����\n1:ѡ��γ�\n2��ɾ����ѡ�γ�\n3���޸���ѡ�γ�\n4���鿴��ѡ�γ�\n5: �˳�");
			input=new Scanner(System.in);
			i=input.nextInt();
			}
		}
}
