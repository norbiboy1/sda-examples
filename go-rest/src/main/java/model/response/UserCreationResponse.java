package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import model.payload.User;
@Getter
@Setter
public class UserCreationResponse extends User {
    @JsonProperty("id")
    private int id;
    @JsonProperty("created_at")
    private String createTimestamp;
    @JsonProperty("updated_at")
    private String dateTimestamp;
}
