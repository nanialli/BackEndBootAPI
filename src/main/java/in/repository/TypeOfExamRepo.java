package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.TypeOfExam;

public interface TypeOfExamRepo extends JpaRepository<TypeOfExam, String>{

}
