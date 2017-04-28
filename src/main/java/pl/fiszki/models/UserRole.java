package pl.fiszki.models;

import javax.persistence.*;


@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_role_id")
    private long idUserRole;

    @Column(name = "user_id")
    private long userId;

    public UserRole() {
    }

    public UserRole(long idUser, long idRole) {
        this.idUserRole = idRole;
        this.userId = idUser;
    }

    public long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(long idUserRole) {
        this.idUserRole = idUserRole;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
