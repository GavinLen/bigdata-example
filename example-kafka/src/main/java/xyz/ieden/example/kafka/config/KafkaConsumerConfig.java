package xyz.ieden.example.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * KafkaProducerConfig
 *
 * @author gavin
 * @version 1.0
 * @date 2019/9/3 0:57
 */
public class KafkaConsumerConfig {

    public static Properties getKafkaConsumerProps() {
        Properties props = new Properties();
        // Kafka 服务器地址
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "c-108:9092");
        // 所有副本必须确认之后在发送
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, Boolean.TRUE);
        // 发送失败后重试发送的次数
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        // 批处理
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        // 请求间隔：ms
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        // 缓存大小
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1 * 1024 * 1024);
        // Key 序列化
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Value 序列化
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

}
