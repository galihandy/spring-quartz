package explr.spring.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
