package explr.spring.domain.user.repositories;

import explr.spring.core.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
public interface UserRepository extends CrudRepository<User, Integer>{

    User findById(int id);
}
