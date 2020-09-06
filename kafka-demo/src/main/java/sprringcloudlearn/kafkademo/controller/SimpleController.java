package sprringcloudlearn.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sprringcloudlearn.kafkademo.model.Message;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-03-22 20:45
 **/

@AllArgsConstructor
@RestController
public class SimpleController {
	
	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;

	@GetMapping("/send")
	public Message send(@RequestBody Message messge) {
		kafkaTemplate.send("topic1", messge);
		kafkaTemplate.send("test", messge);
		return messge;
	}
	
}
