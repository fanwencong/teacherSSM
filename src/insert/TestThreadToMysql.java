package insert;

public class TestThreadToMysql {

	public static void main(String[] args) {
		for (int i = 1; i <=10000; i++) {
			String teacherName=String.valueOf(i);
			new ThreadToMysql(teacherName, "123456").start();
		}
	}

}
