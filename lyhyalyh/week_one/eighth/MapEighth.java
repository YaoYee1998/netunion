package lyh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEighth extends Weekone_eighth {
	public Map<String,String> eight;
    public MapEighth() {
        this.eight=new HashMap<String,String>();
    }
	public void add(){
		System.out.println("��������Ҫ���ӵĿγ̺ţ�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(str1!=null){
				switch(str1){
				case "0001":
					eight.put("0001", "�����źŴ���");
					break;
				case "0002":
					eight.put("0002", "����źŷ���");
					break;
				case "0003":
					eight.put("0003", "��������ԭ��");
					break;
				case "0004":
					eight.put("0004", "����ϵͳ");
					break;
				case "0005":
					eight.put("0005", "����");
					break;
				default:
					System.out.println("�����ڴ˿γ̣�");
					}
		}else{
			System.out.println("�����ڴ˿γ̣�");
		}
	}
	public void delete(){
		System.out.println("��������Ҫɾ���Ŀγ̣�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(eight.containsKey(str1)){
			if(eight.remove(str1) != null){
				System.out.println("ɾ���ɹ���");
			}
		}else{
			System.out.println("δѡ�˿γ̣�");
		}
	}
	public void replace(){
		System.out.println("��������Ҫ�޸ĵĿγ̣�");
		@SuppressWarnings("resource")
		Scanner number=new Scanner(System.in);
		String str1=number.nextLine();
		if(eight.containsKey(str1)){
			System.out.println("��������Ҫ�޸ĵĿγ̺ţ�");
			@SuppressWarnings("resource")
			Scanner number1=new Scanner(System.in);
			String str2=number1.nextLine();
			eight.remove(str2);
			System.out.println("��������Ҫ�޸ĳ�Ϊ�Ŀγ̺ţ�");
			@SuppressWarnings("resource")
			Scanner number2=new Scanner(System.in);
			String str3=number2.nextLine();
			switch(str3){
			case "0001":
				eight.put("0001", "�����źŴ���");
				break;
			case "0002":
				eight.put("0002", "����źŷ���");
				break;
			case "0003":
				eight.put("0003", "��������ԭ��");
				break;
			case "0004":
				eight.put("0004", "����ϵͳ");
				break;
			case "0005":
				eight.put("0005", "����");
				break;
			default:
				System.out.println("�����ڴ˿γ̣�");
				}
			}
	}
	public void search(){
		System.out.println(eight.entrySet());
	}
}
