package uz.atm.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import uz.atm.services.GeneralService;

@Component
public class QueueConsumer {
    GeneralService generalService;


    public QueueConsumer(GeneralService generalService) {
        this.generalService = generalService;
    }


    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
        System.out.println(fileBody);
        generalService.parser(fileBody);
    }
}



