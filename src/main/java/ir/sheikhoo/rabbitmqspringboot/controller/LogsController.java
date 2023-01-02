package ir.sheikhoo.rabbitmqspringboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.sheikhoo.rabbitmqspringboot.config.QueueConsumer;
import ir.sheikhoo.rabbitmqspringboot.config.QueueProducer;
import ir.sheikhoo.rabbitmqspringboot.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LogsController {

    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private QueueConsumer queueConsumer;

    @GetMapping("getMessage")
    public ResponseEntity<?> getMessage() throws JsonProcessingException {
        Message message = queueConsumer.processMessage();
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @PostMapping("sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) throws JsonProcessingException {
        queueProducer.produce(message);
        return new ResponseEntity<Message>(HttpStatus.CREATED);
    }
}
