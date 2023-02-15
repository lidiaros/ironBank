package com.example.ironBank.repositories.user;
import com.example.ironBank.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
