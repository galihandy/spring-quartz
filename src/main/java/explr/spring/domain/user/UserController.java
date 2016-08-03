package explr.spring.domain.user;

import explr.spring.core.model.User;
import explr.spring.domain.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}")
    public User getUser(@PathVariable int id) {
        User user = userRepository.findById(id);
        return user;
    }
}
