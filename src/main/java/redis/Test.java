package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {



    static class TestRedis implements Runnable {

        JedisPool jedisPool;
        public TestRedis(JedisPool jedisPool){
            this.jedisPool = jedisPool;
        }
        @Override
        public void run() {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.incr("test");
                jedisPool.returnResource(jedis);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if (jedis != null){
                    jedis.close();
                }
            }
        }
    }
    /**
     * 高并发对同一key做更新需要加锁嘛？
     */
    public static void main(String[] args) {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(3000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 300, "123456");

        ExecutorService executors =  Executors.newFixedThreadPool(50);
        for(int i = 0; i < 50; i++){
            System.out.println(i);
            executors.submit(new TestRedis(jedisPool));
        }

    }
}
