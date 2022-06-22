package uz.atm.consumer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.services.RbtMsgsService;

import java.io.IOException;
import java.util.ArrayList;

//
@Component
public class QueueConsumer {
	ArrayList<String> msgFromRbt = new ArrayList<>();
	RbtMsgsService rbtMsgsService;
	ResultatMethod resultatMethod = null;
	Gson gson = new Gson();

//	@RabbitListener(queues = {"${queue.name}"})
	public void receive(@Payload String fileBody) throws IOException
	{
//		String formattedStr = fileBody.trim();
		String formattedStr = fileBody.replaceAll("\n", "");
		String tStr = formattedStr.strip();

		if (fileBody.contains("RESULTAT\""))
		{
			msgFromRbt.add(fileBody);
//			resultatMethod = gson.fromJson(formattedStr, ResultatMethod.class);

//			System.out.println(formattedStr);
			System.out.println("### resultatMethod ###");

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try
			{
				ResultatMethod rmt = mapper.readValue(formattedStr, ResultatMethod.class);
				System.out.println(rmt.toString());
				System.out.println("### resultatMethod ###");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
//			System.out.println(resultatMethod.toString());
//			System.out.println(resultatMethod.getMethod_name());
//			System.out.println(msgFromRbt);
//			final ObjectMapper mapper = new ObjectMapper();

			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

//			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			byte[] data = formattedStr.getBytes();
//			System.out.println(data.toString());

			//			System.out.println(msgFromRbt.get(0));
//			byte[] jsonData = msgFromRbt;
			ObjectMapper objectMapper = new ObjectMapper();
//			ResultatMethod result = objectMapper.readValue(data, ResultatMethod.class);
//
////			JsonNode jsonNode = mapper.readTree(fileBody);
////			JsonNode jsonNode = mapper.readTree(msgFromRbt.get(0));
//			System.out.println(
//			 "##################################result" + "#############################################");
//			System.out.println(result);
//			rbtMsgsService.save(result);

//mapper.readValue()
//			ResultatMethod resultatMethod = mapper.readValue(fileBody, ResultatMethod.class);
//			ResultatMethod resultatMethod = jsonNode.toString();
//			rbtMsgsService.save(resultatMethod);


//			System.out.println("Users Saved!");
			//			msgFromRbt.forEach((n) ->
//			for (int i = 0; i < msgFromRbt.size(); i++)
//			{
////				System.out.println("msgFromRbt.get(i)");
////				System.out.println(msgFromRbt.get(i));
//				final TypeReference<List<ResultatMethod>> typeReference = new TypeReference<List<ResultatMethod>>() {};
//				final InputStream inputStream = TypeReference.class.getResourceAsStream(msgFromRbt.get(i));
//				try
//				{
//					final List<ResultatMethod> users = mapper.readValue(inputStream, typeReference);
//					rbtMsgsService.save(users);
//					System.out.println("Users Saved!");
//				} catch (final IOException e)
//				{
//					System.out.println("Unable to save users: " + e.getMessage());
//				}
//			}
		} else
		{
			System.out.println("doesn`t");
		}
	}
}



