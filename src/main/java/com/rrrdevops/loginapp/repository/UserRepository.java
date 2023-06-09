package com.rrrdevops.loginapp.repository;

import com.rrrdevops.loginapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value="SELECT id  FROM User  WHERE  user_name = :username and password = :password",nativeQuery = true)
   String findUserbyCreds(@Param("username") String username,@Param("password") String password);
}
