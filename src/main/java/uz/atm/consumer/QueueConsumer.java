package uz.atm.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import uz.atm.repository.RbtMsgsRepository;
import uz.atm.services.GeneralService;

import java.io.IOException;

@Component

public class QueueConsumer {
    @Autowired
    private RbtMsgsRepository repository;

    @Autowired
    GeneralService generalService;

/*	public QueueConsumer(RbtMsgsRepository repository, GeneralService generalService)
	{
		this.repository = repository;
		this.generalService = generalService;
	}*/

    public QueueConsumer(RbtMsgsRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) throws IOException {
        System.out.println(fileBody);
        generalService.parse(fileBody);
    }
}



