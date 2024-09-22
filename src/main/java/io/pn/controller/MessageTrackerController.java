package io.pn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.CricketScore;
import io.pn.service.KafkaMessageProducerServiceImpl;

@RestController
public class MessageTrackerController {
	
	@Autowired
	KafkaMessageProducerServiceImpl messageProducer;
	
	@GetMapping("/api/send/{data}")
	public String sendMessage(@PathVariable String data) {
		messageProducer.sendMessage("quickstart-events", data);
		return "Message sent...";
	}
	
	@PostMapping("/api/cricket-score")
	public String sendMessage(@RequestBody CricketScore score) {
		messageProducer.sendMessage("quickstart-events", score);
		return "Message sent...";
	}
}
