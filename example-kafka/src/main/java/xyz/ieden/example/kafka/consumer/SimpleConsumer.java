package xyz.ieden.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import xyz.ieden.example.kafka.config.KafkaConsumerConfig;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * SimpleConsumer
 *
 * @author gavin
 * @version 1.0
 * @date 2019/9/3 1:25
 */
public class SimpleConsumer {

    public static void main(String[] args) {
        KafkaConsumer<String, String> kafkaConsumer = null;

        try {
            // 1. 获取配置
            Properties props = KafkaConsumerConfig.getKafkaConsumerProps();

            // 2. 创建消费者
            kafkaConsumer = new KafkaConsumer<>(props);
            // 3. 订阅主题
            kafkaConsumer.subscribe(Arrays.asList("toc_1"));

            // 3. 消费信息
            while (true) {
                // 1000 ms 消费一次
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));


            }
        } finally {
            // 4. 关闭消费者
            if (kafkaConsumer != null) {
                kafkaConsumer.close();
            }
        }

    }

}
