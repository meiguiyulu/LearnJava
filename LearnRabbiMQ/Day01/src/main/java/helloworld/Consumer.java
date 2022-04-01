package helloworld;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    @Test
    public void test() throws IOException, TimeoutException {
        // 创建连接mq的连接工厂对象
/*        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接rabbitmq的主机ip
        connectionFactory.setHost("127.0.0.1");
        // 设置端口号
        connectionFactory.setPort(5672);
        // 设计连接的虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();*/

        /*通过工具类获取连接*/
        Connection connection = RabbitMQUtils.getConnection();

        //获取连接中通道
        Channel channel = connection.createChannel();

        //通道绑定对应消息队列
        //参数1:  队列名称 如果队列不存在自动创建
        //参数2:  用来定义队列特性是否要持久化 true 持久化队列   false 不持久化
        //参数3:  exclusive 是否独占队列  true 独占队列   false  不独占
        //参数4:  autoDelete: 是否在消费完成后自动删除队列  true 自动删除  false 不自动删除
        //参数5:  额外附加参数
        channel.queueDeclare("hello", true, false, false, null);

        //发布消息
        //参数1: 队列名称
        //参数2: 开始消息的自动确认机制
        //参数3: 回调接口
        channel.basicConsume("hello", true, new DefaultConsumer(channel){
            // 最后一个参数是消息队列中的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new String(body):\t" + new String(body));
            }
        });

//        不建议关闭消费端
        channel.close();
        connection.close();
    }

}
