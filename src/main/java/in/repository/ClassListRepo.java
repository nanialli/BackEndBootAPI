package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.ClassList;

public interface ClassListRepo extends JpaRepository<ClassList, Integer> {

}
