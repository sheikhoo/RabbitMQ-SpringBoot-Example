package ir.sheikhoo.rabbitmqspringboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.sheikhoo.rabbitmqspringboot.config.QueueConsumer;
import ir.sheikhoo.rabbitmqspringboot.config.QueueProducer;
import ir.sheikhoo.rabbitmqspringboot.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RabbitMqSpringBootApplicationTests {
	@Autowired
	private QueueProducer queueProducer;
	@Autowired
	private QueueConsumer queueConsumer;

	@Test
	public void checkProducerAndConsumer() throws JsonProcessingException {
		Message message=new Message("test","this is a test","system");
		queueProducer.produce(message);
		assertThat(queueConsumer.processMessage().getTitle()).isEqualTo(message.getTitle());
	}

}
