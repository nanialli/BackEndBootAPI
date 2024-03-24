package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.Marks;

public interface MarksRepo extends JpaRepository<Marks, Integer> {

}
