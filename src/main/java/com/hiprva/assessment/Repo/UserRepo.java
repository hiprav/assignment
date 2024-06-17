package com.hiprva.assessment.Repo;

import com.hiprva.assessment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
        User findByUsername(String username);
}
