package in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.TeacherTimeTable;
import in.entity.User;

public interface TeacherTimeTableRepo extends JpaRepository<TeacherTimeTable, Integer>{

	public List<TeacherTimeTable> findAllByUser(User u) ;
}
