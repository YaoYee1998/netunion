
public class ThreadOne extends Thread {
	private int i;
	static String id;
	ThreadOne(String id){
		this.id=id;
	}
	public void run(){
		for(i=0;i<5;i++){
			System.out.println(ThreadOne.id+"һ���߳�������");
		}
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}