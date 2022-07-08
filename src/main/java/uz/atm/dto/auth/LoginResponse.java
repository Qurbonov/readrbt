package uz.atm.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private Boolean status;
    private String title;
    private Boolean isExist;

    private String token;

    public LoginResponse(Boolean status, String title, Boolean isExist) {
        this.status = status;
        this.title = title;
        this.isExist = isExist;
    }

}
