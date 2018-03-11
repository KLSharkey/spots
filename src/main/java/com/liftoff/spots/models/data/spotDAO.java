package com.liftoff.spots.models.data;

import com.liftoff.spots.models.Spot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface spotDAO extends CrudRepository<Spot,Integer> {


}
