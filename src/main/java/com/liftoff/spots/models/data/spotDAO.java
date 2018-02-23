package com.liftoff.spots.models.data;

import com.liftoff.spots.models.Spot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface spotDAO extends CrudRepository<Spot,Integer> {

}
