package com.project.springapidb.repo;

import com.project.springapidb.component.Student;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
