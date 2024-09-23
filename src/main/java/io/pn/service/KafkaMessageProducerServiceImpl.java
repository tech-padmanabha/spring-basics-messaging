package io.pn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pn.dto.CricketScore;

@Service
public class KafkaMessageProducerServiceImpl {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	public void sendMessage(String topic,String data) {
		kafkaTemplate.send(topic, data);
	}
	
//	public void sendMessage(String topic,CricketScore data) {
//		String writeValueAsString = null;
//		try {
//			writeValueAsString = mapper.writeValueAsString(data);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		kafkaTemplate.send(topic, writeValueAsString);
//	}
	
	public void sendMessage(String topic,CricketScore data) {
		String writeValueAsString = null;
		try {
			writeValueAsString = mapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		kafkaTemplate.send(topic, writeValueAsString);
	}
}
