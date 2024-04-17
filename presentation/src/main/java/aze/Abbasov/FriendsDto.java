package aze.Abbasov;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendsDto {
    public Long firstFriend;
    public Long secondFriend;

    public FriendsDto() {
    }
}
