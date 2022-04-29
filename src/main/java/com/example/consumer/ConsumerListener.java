package com.example.consumer;

import com.example.consumer.config.RabbitMqConfig;
import com.example.consumer.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listener(MessageDto messageDto){
        System.out.println("DIRECT EXCHANGE");
        System.out.println(messageDto);
        System.out.println("Direct: "+messageDto.getMessage());
    }

    @RabbitListener(queues = "fanout_queque")
    public void listenerFanout(MessageDto messageDto){
        System.out.println("FANOUT EXCHANGE");
        System.out.println("Fanout: "+messageDto.getMessage());
        System.out.println(messageDto);
    }

    @RabbitListener(queues = "teacher")
    public void listenerListofTopic(MessageDto messageDto){
        System.out.println("TEACHER TOPIC");
        System.out.println("Teacher: "+messageDto.getMessage());
        System.out.println(messageDto);
    }

    @RabbitListener(queues = "estudiantes")
    public void listenerEstudiantesListofTopic(MessageDto messageDto){
        System.out.println("STUDIANTES TOPIC");
        System.out.println("Estudiantes: "+messageDto.getMessage());
        System.out.println(messageDto);
    }
}
