package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    @JsonProperty("code")
    private int statusCode;
    @JsonProperty("meta")
    private String metaData;
    @JsonProperty("data")
    private UserCreationResponse userCreationResponse;


}
