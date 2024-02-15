package com.ts.readersHeaven.kafka_tests;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaTesting {
	

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("bootstrap.servers", "127.0.0.1:9092");

        Producer<String, String> producer = new KafkaProducer<>(props);

        // Generated synthetic order data
        for (int i = 1; i <= 1000; i++) {
            String order = "order" + i;
            producer.send(new ProducerRecord<>("order-processing-topic", order));
            Thread.sleep(10); // Adjust delay based on desired throughput
        }

        producer.close();
    }


}
