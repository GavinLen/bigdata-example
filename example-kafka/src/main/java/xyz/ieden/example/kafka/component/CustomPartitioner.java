package xyz.ieden.example.kafka.component;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * CustomPartitioner
 *
 * @author gavin
 * @version 1.0
 * @date 2019/9/4 0:14
 */
public class CustomPartitioner implements Partitioner {

    /**
     * 分区
     *
     * @param topic
     * @param key
     * @param keyBytes
     * @param value
     * @param valueBytes
     * @param cluster
     * @return
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        return 0;
    }

    /**
     * 关闭
     */
    @Override
    public void close() {

    }

    /**
     * 配置
     *
     * @param configs
     */
    @Override
    public void configure(Map<String, ?> configs) {

    }
}
