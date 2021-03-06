package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {
    @JsonProperty("code")
    private int statusCode;
    @JsonProperty("meta")
    private String metadata;
    @JsonProperty("data")
    private PostCreationResponse postCreationResponse;


}
