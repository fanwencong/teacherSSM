package tenThreadInsert;

public class Test {

	public static void main(String[] args) {
		InsertTOMysql is=new InsertTOMysql();
		for (int i = 1; i <=10; i++) {
		      new Thread(is).start();
			}
	}
	
}
