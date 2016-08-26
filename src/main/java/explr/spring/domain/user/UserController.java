package explr.spring.domain.user;

import explr.spring.core.model.User;
import explr.spring.domain.user.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public User addUser(@RequestBody User user,
                        @RequestHeader(name = "Content-Type") String contentType) {
        LoggerFactory.getLogger(this.getClass()).info("Add User {}, content {}", user.getEmail(), contentType);
        return user;
    }
}
