import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GetInput {
	 public static void main(String args[]) throws IOException{
		 //����һ���ļ�
		 File f=new File("got.txt");
		 if(!f.exists()){
			 try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 String str=new String();
		 System.out.println("���������ݣ�");
		 Scanner s = new Scanner(System.in);
		 str = s.nextLine();
		 s.close();
		 BufferedWriter fr=new BufferedWriter(new FileWriter(f));
		 fr.write(str);
		 fr.close();
	 }
}
