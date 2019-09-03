package xyz.ieden.example.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import xyz.ieden.example.kafka.config.KafkaProducerConfig;

import java.util.Properties;

/**
 * CallBackProducer
 *
 * @author gavin
 * @version 1.0
 * @date 2019/9/3 23:59
 */
public class CallBackProducer {
    public static void main(String[] args) {

        // 1. 获取生产者配置
        Properties props = KafkaProducerConfig.getKafkaProducerProps();
        // 2. 创建生产者
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
        // 3. 发送消息

        for (int i = 0; i < 100; i++) {
            kafkaProducer.send(new ProducerRecord<String, String>("topic_1", Integer.toString(i), "val_" + i), (metadata, exception) -> {
                if (metadata != null) {
                    System.err.println(metadata.offset());
                }
            });
        }
    }
}
