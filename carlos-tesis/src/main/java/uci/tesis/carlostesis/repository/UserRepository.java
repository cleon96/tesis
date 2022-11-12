package uci.tesis.carlostesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uci.tesis.carlostesis.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User,Integer> {
}
