package io.pn.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.util.ErrorHandler;

import com.fasterxml.jackson.databind.JsonDeserializer;

@Configuration
public class KafkaConsumerConfiguration {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServer;
	
	@Bean
	ConsumerFactory<String, String> consumerFactory(){
		
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "second-group");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(configProps);
	}
	
	
	//@Bean
	ConsumerFactory<String, String> consumerFactoryForJson(){
		
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "second-group");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(configProps);
	}
	
	@Bean
	ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> kafkaConsumer = new ConcurrentKafkaListenerContainerFactory<>();
		kafkaConsumer.setConsumerFactory(consumerFactory());
		return kafkaConsumer;
	}
	
	
	
	@Bean
	ErrorHandler errorHandler() {
		new ErrorHandler() {
			
			@Override
			public void handleError(Throwable t) {
			//	 List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer
			}
		};
		return null;
	}
}
