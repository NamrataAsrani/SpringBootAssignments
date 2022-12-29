package com.rest.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.demo.Model.StudentModel;
@Repository
public interface StudentRepo extends CrudRepository<StudentModel, Integer> {

	StudentModel save(Optional<StudentModel> student);

}
