package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import model.payload.Post;
@Getter
@Setter
public class PostCreationResponse extends Post {
    @JsonProperty("id")
    private int postId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("created_at")
    private String postCreationTimestemp;
    @JsonProperty("updated_at")
    private String postUpdateTimestemp;

}
