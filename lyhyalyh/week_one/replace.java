import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class replace {
	public static void main(String args[]) throws IOException{
		//���ļ�
		File f=new File("C:/Users/admin/Desktop/git/��Ҫѧϰ/Java��̨��һ��/email.html");
		File fo=new File("C:/Users/admin/Desktop/git/��Ҫѧϰ/Java��̨��һ��/test.html");
		fo=newfile(f,fo);
		BufferedReader fr=new BufferedReader(new InputStreamReader(new FileInputStream(fo),"UTF-8"));
		String i=fr.readLine();
		BufferedWriter fw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fo),"UTF-8"));
		//�ҵ���һ���ؼ���
		while(i.indexOf("|reg_Name|")==-1){
			fw.write(i);
			i=fr.readLine();
		}
		System.out.println("������������֣�");
		Scanner re=new Scanner(System.in);
		String str=re.nextLine();
		//�滻
		do{
			if(i.indexOf("|reg_Name|")>=0){
				i = i.replace("|reg_Name|", str);
				fw.write(i);
			}else{
				fw.write(i);
			}
			}while((i=fr.readLine())!=null);
		re.close();
		fr.close();
		fw.close();
	}

   static File newfile(File oldf, File newf) throws IOException {    
    InputStream input = null;    
    OutputStream output = null;    
    try {
           input = new FileInputStream(oldf);
           output = new FileOutputStream(newf);        
           byte[] buf = new byte[1024];        
           int bytesRead;        
           while ((bytesRead = input.read(buf)) > 0) {
               output.write(buf, 0, bytesRead);
           }
    } finally {
        input.close();
        output.close();
    }
	return newf;
}
}