package ml.empee.angularShop.model.user;

import ml.empee.angularShop.model.user.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UsersRepository repository;

    public UserService(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Can't find the username " + username);
        }

        return new UserResponse().copyFrom(user);
    }
}
