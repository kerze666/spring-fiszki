package pl.fiszki.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.dao.UserDAO;
import pl.fiszki.models.user.Role;
import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserStatus;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsernameAndStatus(username, UserStatus.ACTIVE);
        if (user != null) {
            logger.warn("Founded user "+user.toString());
            boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
            boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
            boolean credientialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
            boolean accountNonLocker = user.getStatus().equals(UserStatus.ACTIVE);

            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }

            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    enabled,
                    accountNonExpired,
                    credientialsNonExpired,
                    accountNonLocker,
                    authorities);
        } else {
            logger.debug("user not found");
            throw new UsernameNotFoundException(String.format("User not found:  %1$d", username));
        }
    }
}
