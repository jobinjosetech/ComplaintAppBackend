package com.nest.ComplaintAppBackend.dao;

import com.nest.ComplaintAppBackend.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel,Integer> {
}
