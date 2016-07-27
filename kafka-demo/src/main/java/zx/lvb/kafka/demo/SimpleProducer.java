package zx.lvb.kafka.demo;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SimpleProducer {
    private static Producer<Integer,String> producer;
    private final Properties props=new Properties();
    public SimpleProducer(){
        //定义连接的broker list
        props.put("metadata.broker.list", "192.168.6.156:9092");
        //定义序列化类（Java对象传输前要序列化）
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        producer = new Producer<Integer, String>(new ProducerConfig(props));
    }
    public static void main(String[] args) {
        SimpleProducer sp=new SimpleProducer();
        //定义topic
        String topic="test2";
        //定义要发送给topic的消息
        String messageStr = "hahahahahaha send a message to broker ";
        //构建消息对象
        KeyedMessage<Integer, String> data = new KeyedMessage<Integer, String>(topic, messageStr);
        //推送消息到broker
        producer.send(data);
        producer.close();
    }
}
