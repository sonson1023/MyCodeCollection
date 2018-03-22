package kafka.sw.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kafka.javaapi.producer.Producer;

import kafka.producer.KeyedMessage;

import kafka.producer.ProducerConfig;

public class ProducerExample {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();

		props.put("metadata.broker.list", "192.168.0.132:9092,192.168.0.136:9092,192.168.0.134:9092");

		props.put("serializer.class", "kafka.serializer.StringEncoder");

		ProducerConfig producerConfig = new ProducerConfig(props);

		Producer<String, String> producer = new Producer<String, String>(producerConfig);

		List<KeyedMessage<String, String>> messages = new ArrayList<KeyedMessage<String, String>>();
		for (int i = 0; i < 10; i++) {
			messages.add(new KeyedMessage<String, String>("test", "Hello, World! - "+i));
		} 
		producer.send(messages);

		producer.close();

		
		System.out.println("finish");
		
	}

}