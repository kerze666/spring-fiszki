package pl.fiszki.models.user;

import javax.persistence.*;
import java.util.List;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private long id_role;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> userList;

    public Role() {
    }

    public Role(String role, List<User> userList) {
        this.role = role;
        this.userList = userList;
    }

    public long getId_role() {
        return id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

