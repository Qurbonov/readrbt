package uz.atm.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    public Boolean status;
    public String title;
    public Boolean isExist;

    public String token;

    public LoginResponse(Boolean status, String title, Boolean isExist) {
        this.status = status;
        this.title = title;
        this.isExist = isExist;
    }

}
