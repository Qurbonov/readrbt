package uz.atm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.atm.properties.OpenApiProperties;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(value = OpenApiProperties.class)
public class ReadRbtMsgApplication {


    public static void main(String[] args) {
        SpringApplication.run(ReadRbtMsgApplication.class, args);
    }

/*    @Bean
    static CommandLineRunner runner(final AuthUserService service) {
        return args -> {
            service.create(AuthUserCreateDto.builder()
                    .username("admin")
                    .password("admin")
                    .role(Role.ADMIN)
                    .build());
        };
    }*/


}
