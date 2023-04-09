package com.theinsideshine.springcloud.msvc.users.repositories;

import com.theinsideshine.springcloud.msvc.users.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User,Long>{
}
