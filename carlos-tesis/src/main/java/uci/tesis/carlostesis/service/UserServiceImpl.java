package uci.tesis.carlostesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.Reservation;
import uci.tesis.carlostesis.entity.User;
import uci.tesis.carlostesis.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;



    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Integer reservationId) {
        repository.deleteById(reservationId);
    }
    @Override
    public List<User> userList(){
        List<User> userList = repository.findAll();
        return  userList;
    }
}
