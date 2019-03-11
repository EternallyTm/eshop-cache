package com.wangx.eshop.cache.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: wangx
 * @email: 1028106567@QQ.COM
 * @since: 2019/3/8 0008
 * @version: 1.0
 * Copyright: Copyright (c) 2019
 */

public class KafkaConsumer implements Runnable{
    private ConsumerConnector consumerConnector;
    private static String topic;

    public KafkaConsumer(String topic) {
        this.consumerConnector = Consumer.createJavaConsumerConnector(createConsumerConfig());
        this.topic = topic;
    }
    @Override
    public void run() {
        HashMap<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, 1);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        for (final KafkaStream stream : streams) {
            new Thread(new KafkaMessageProcessor(stream)).start();
        }
    }
    public static ConsumerConfig createConsumerConfig() {
        Properties properties = new Properties();
        Resource resource = new ClassPathResource("kafkaConfig.properties");
        InputStream inputStream;
        try {
            inputStream = resource.getInputStream();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ConsumerConfig(properties);
    }
}
