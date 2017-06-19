package com.hoanghiep.webtravel.repo;

import com.hoanghiep.webtravel.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hoanghiep on 6/18/17.
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}
