package explr.spring.core.model;

import javax.persistence.*;

/**
 * Created by galih.a.pradana on 7/30/2016.
 */
@Entity(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }
}
