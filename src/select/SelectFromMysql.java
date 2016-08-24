package select;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SelectFromMysql {
	   public static void main(String[] args) {
		   	JedisPool pool;
	      
	        JedisPoolConfig config = new JedisPoolConfig();//创建redis连接池
	        // 设置最大连接数，-1无限制
	        config.setMaxTotal(300);
	        // 设置最大空闲连接
	        config.setMaxIdle(100);
	        // 设置最大阻塞时间，记住是毫秒数milliseconds
	        config.setMaxWaitMillis(100000);
	        // 创建连接池
	        pool = new JedisPool(config, "127.0.0.1", 6379,2000);
	      for (int i =1; i <=10000; i++) {//这里自己设置用多少线程并发访问
				String teacherName=String.valueOf(i);
				new ThreadToMysql(teacherName, "123456",pool).start();
			}
	 }
}
