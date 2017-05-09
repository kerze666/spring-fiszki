package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.dao.UserRoleDAO;
import pl.fiszki.models.user.UserRole;
import pl.fiszki.service.UserRoleService;

/**
 * Created by Bartek on 24.04.2017.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Transactional
    public void addRolesUser(UserRole userRole) {
        userRoleDAO.save(userRole);
    }

    @Transactional
    public void deleteRolesUser(long idUser) {
        userRoleDAO.deleteByUserId(idUser);
    }

    public long getRoleUserid(long iduser) {
        return userRoleDAO.getUserRoleByUserId(iduser);
    }
}
