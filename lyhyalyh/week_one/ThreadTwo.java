
public class ThreadTwo extends Thread{
	private int i;
	String id;
	ThreadTwo(String id){
		this.id=id;
	}
	public void run(){
		for(i=0;i<5;i++){
			System.out.println(ThreadOne.id+"�����߳�������");
		}
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
