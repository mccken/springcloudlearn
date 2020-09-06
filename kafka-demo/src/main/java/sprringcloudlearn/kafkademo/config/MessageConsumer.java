package sprringcloudlearn.kafkademo.config;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-02-03 23:04
 **/
@Component
public class MessageConsumer {

	@KafkaListener(topics = {"test"})
	public void consumer(ConsumerRecord consumerRecord) {
		Optional kafkaMsg = Optional.ofNullable(consumerRecord.value());
		System.out.println(111);
		if (kafkaMsg.isPresent()) {
			System.out.println(222);
//			Object msg = kafkaMsg.get();
//			System.err.println(msg);
		}

		System.out.println(333);
	}

}
