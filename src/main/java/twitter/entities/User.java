package twitter.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "twitter_users")
@NamedQueries(
        @NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE " + "u.username LIKE :userName")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @OneToMany
    private List<Message> userMessages;

    public User() {
    }

    public User(Integer id,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
