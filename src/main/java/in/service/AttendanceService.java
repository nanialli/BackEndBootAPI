package in.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.entity.StudentAttendance;
import in.entity.User;
import in.repository.StudentAttendanceRepo;
import in.repository.UserRepo;

@Service
public class AttendanceService {

	@Autowired
	StudentAttendanceRepo attRepo ;
	@Autowired
	UserRepo urepo ;
	
	public boolean doAttendanceStudent(List<StudentAttendance> dtoList) {
		
		try{
			attRepo.saveAll(dtoList) ;
		}catch ( Exception e) {
			return false ;
		}
		return true ;
	}
	
	public List<User> getAbsentStudents (LocalDate date){
		List<Integer> userIds = attRepo.findAbsents(date.toString()) ;
		return urepo.findAllById(userIds) ;
		
	}
}
