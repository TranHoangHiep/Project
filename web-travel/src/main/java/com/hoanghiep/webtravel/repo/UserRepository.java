package com.hoanghiep.webtravel.repo;

import com.hoanghiep.webtravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hoanghiep on 6/18/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email) ;

}
