package jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author LYJ
 * @create 2021-07-30 12:51
 */
public class TestPing {

    public static void main(String[] args) {
        // 1、新建Jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "yunjie");

        // 开启事务
        Transaction multi = jedis.multi();
        String string = jsonObject.toJSONString();

        try {
            multi.set("user1", string);
            multi.set("user2", string);
            int i = 1 / 0;
            // 执行事务
            multi.exec();
        } catch (Exception e){
            // 放弃事务
            multi.discard();
            e.printStackTrace();
        } finally {
            // 3、断开连接
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }

    }
}
