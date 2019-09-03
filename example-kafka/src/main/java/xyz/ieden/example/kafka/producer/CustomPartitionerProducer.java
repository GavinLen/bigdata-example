package xyz.ieden.example.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import xyz.ieden.example.kafka.component.CustomPartitioner;
import xyz.ieden.example.kafka.config.KafkaProducerConfig;

import java.util.Properties;

/**
 * CustomPartitionerProducer
 *
 * @author gavin
 * @version 1.0
 * @date 2019/9/4 0:17
 */
public class CustomPartitionerProducer {

    public static void main(String[] args) {

        // 1. 获取生产者配置
        Properties props = KafkaProducerConfig.getKafkaProducerProps();
        // 配置生产者分区策略
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);

        // 2. 创建生产者
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
    }

}
