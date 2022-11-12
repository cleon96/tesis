package uci.tesis.carlostesis.service;

import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.User;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    void deleteUser(Integer reservationId);
    List<User> userList();
}
