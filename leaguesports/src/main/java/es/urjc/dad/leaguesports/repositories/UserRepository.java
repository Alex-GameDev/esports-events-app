package es.urjc.dad.leaguesports.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.leaguesports.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUserName(String userName);
}
