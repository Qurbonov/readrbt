package uz.atm.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import uz.atm.repository.RbtMsgsRepository;
import uz.atm.services.GeneralService;

import java.io.IOException;

@Component
public class QueueConsumer {
    private final RbtMsgsRepository repository;
    GeneralService generalService;


    public QueueConsumer(RbtMsgsRepository repository, GeneralService generalService) {
        this.repository = repository;
        this.generalService = generalService;
    }


//        @RabbitListener(queues = {"cportal_in"})

    public void receive(@Payload String fileBody) {
//		System.out.println(fileBody);
        generalService.parser(fileBody);
    }
}



