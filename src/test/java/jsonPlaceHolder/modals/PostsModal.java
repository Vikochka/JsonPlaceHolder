package jsonPlaceHolder.modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostsModal {
    int userId;
    int id;
    String title;
    String body;
}
