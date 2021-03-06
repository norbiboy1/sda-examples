package model.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    @JsonProperty("title")
    private  String postTitle;
    @JsonProperty("body")
    private String postMessage;

}
