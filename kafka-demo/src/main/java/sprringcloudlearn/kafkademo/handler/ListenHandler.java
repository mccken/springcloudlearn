package sprringcloudlearn.kafkademo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import sprringcloudlearn.kafkademo.model.Message;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-03-23 00:32
 **/
@Component
@KafkaListener(id = "handler", topics = {"test"})
public class ListenHandler {

	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;

	@KafkaHandler
	public void foo(@Payload Message foo, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
		System.out.println("key:" + key);
		System.out.println("foo:" + foo.toString());
	}

	@PostMapping("/foo")
	public void send(Message foo){
		kafkaTemplate.send("foo", "modelOne", foo);
	}

//	@KafkaHandler
//	public void foo(Bar bar) {
//		System.out.println("bar:" + bar.toString());
//	}
}
