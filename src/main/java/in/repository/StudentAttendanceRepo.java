package in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.entity.StudentAttendance;

public interface StudentAttendanceRepo extends JpaRepository<StudentAttendance, Integer> {
	@Query("SELECT userId FROM StudentAttendance WHERE attendanceStatus ='N' AND date = :date")
	public List<Integer> findAbsents(String date);

}
