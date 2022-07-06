package uz.atm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import uz.atm.dto.auth.AuthUserCreateDto;
import uz.atm.enums.Role;
import uz.atm.properties.OpenApiProperties;
import uz.atm.services.auth.AuthUserService;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(value = OpenApiProperties.class)
public class ReadRbtMsgApplication {


    public static void main(String[] args) {
        SpringApplication.run(ReadRbtMsgApplication.class, args);
    }
/*
    @Bean
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
