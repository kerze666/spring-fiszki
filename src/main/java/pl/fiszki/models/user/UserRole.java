package pl.fiszki.models.user;

import javax.persistence.*;


@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "id_role")
    private long idUserRole;

    @Column(name = "id_user")
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
