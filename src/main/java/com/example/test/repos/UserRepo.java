package com.example.test.repos;

import com.example.test.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Репозторий - механизм взаимодействия с базой
// CrudRepository несёт в себе некоторые стандартные функции(Например, findById), которые не нужно потом прописывать
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    @Query("SELECT user FROM User user WHERE user.email=:email")
    User findUserByLogin(@Param("email") String email);

    @Query("SELECT user FROM User user ORDER BY id")
    List<User> getAllUsers();
}
