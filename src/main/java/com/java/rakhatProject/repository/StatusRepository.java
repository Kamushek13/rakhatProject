package com.java.rakhatProject.repository;

import com.java.rakhatProject.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Category,Long> {

}
