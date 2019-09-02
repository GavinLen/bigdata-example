package xyz.ieden.example.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import xyz.ieden.example.kafka.config.KafkaProducerConfig;

import java.util.Properties;

/**
 * SimpleProducer
 *
 * @author gavin
 * @version 1.0
 * @date 2019/9/3 0:53
 */
public class SimpleProducer {
    public static void main(String[] args) {

        KafkaProducer<String, String> kafkaProducer = null;

        try {
            // 1. 获取配置
            Properties props = KafkaProducerConfig.getKafkaProducerProps();
            // 2. 创建 Kafka 生产者
            kafkaProducer = new KafkaProducer<>(props);

            // 3. 发送消息
            for (int i = 0; i < 100; i++) {
                kafkaProducer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), "val_" + i));
            }
        } finally {
            // 4. 关闭消费者

            if (kafkaProducer != null) {
                kafkaProducer.close();
            }
        }
    }
}
