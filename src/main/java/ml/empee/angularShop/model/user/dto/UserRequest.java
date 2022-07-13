package ml.empee.angularShop.model.user.dto;

import lombok.Getter;
import lombok.Setter;
import ml.empee.angularShop.model.CommonDTO;
import ml.empee.angularShop.model.user.UserEntity;

@Getter @Setter
public class UserRequest extends CommonDTO<UserEntity, UserRequest> {

    private String username;
    private String password;

}
