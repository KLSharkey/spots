package com.liftoff.spots.models.data;

import com.liftoff.spots.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface userDao extends CrudRepository<User,Integer> { //stores User objects, keys are ints

}
