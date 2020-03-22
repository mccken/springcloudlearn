package sprringcloudlearn.kafkademo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: springcloudlearn
 * @description: 信息类
 * @author: mccken
 * @create: 2020-02-03 22:58
 **/
@Data
@Accessors
public class Message {

	private String username;
	private String userid;
	private String state;
}
