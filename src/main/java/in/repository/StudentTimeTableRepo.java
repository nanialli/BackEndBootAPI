package in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.ClassList;
import in.entity.StudentTimeTable;

public interface StudentTimeTableRepo extends JpaRepository<StudentTimeTable, Integer> {

	public StudentTimeTable findByClassListAndDayOfWeek(ClassList classList , String DayOfweek) ;

	public List<StudentTimeTable> findAllByClassList(ClassList classId);
}
