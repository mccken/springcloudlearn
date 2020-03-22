package sprringcloudlearn.kafkademo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import sprringcloudlearn.kafkademo.model.Message;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2020-02-03 23:02
 **/
@Component
public class MessageProducer {

	@Autowired
	private KafkaTemplate kafkaTemplate;

	public void sendlog(String userid) {
		Message userlog = new Message();
		userlog.setUsername("cxy");
		userlog.setState("1");
		userlog.setUserid(userid);

		System.err.println(userlog + "1");

		kafkaTemplate.send("userLog", JSON.toJSONString(userlog));

	}
}
