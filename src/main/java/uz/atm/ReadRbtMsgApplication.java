package uz.atm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ReadRbtMsgApplication {


    public static void main(String[] args) {
        SpringApplication.run(ReadRbtMsgApplication.class, args);
    }

//	@Bean
//	static CommandLineRunner runner(final RbtMsgsService rbtMsgsService)
//	{
//		return args -> {
//			// read json and write to db
//			final ObjectMapper mapper = new ObjectMapper();
//			final TypeReference<List<ResultatMethod>> typeReference = new TypeReference<List<ResultatMethod>>() {};
//			final InputStream inputStream = TypeReference.class.getResourceAsStream(q);
//			try
//			{
//				final List<ResultatMethod> users = mapper.readValue(inputStream, typeReference);
//				rbtMsgsService.save(users);
//				System.out.println("Users Saved!");
//			} catch (final IOException e)
//			{
//				System.out.println("Unable to save users: " + e.getMessage());
//			}
//		};
//	}


}
