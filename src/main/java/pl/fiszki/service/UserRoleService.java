package pl.fiszki.service;

import pl.fiszki.models.user.UserRole;

/**
 * Created by Bartek on 24.04.2017.
 */
public interface UserRoleService {

    void addRolesUser(UserRole userRole);

    void deleteRolesUser(long idUser);

    long getRoleUserid(long iduser);
}
