package in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bindings.Marks;
import in.entity.TypeOfExam;
import in.entity.User;
import in.repository.MarksRepo;
import in.repository.TypeOfExamRepo;
import in.repository.UserRepo;

@Service
public class MarksService {
	@Autowired
	private TypeOfExamRepo exam;
	@Autowired
	private UserRepo urepo ;
	@Autowired
	private MarksRepo mrepo ;

	public boolean addExamName(String Name) {
		TypeOfExam examName = new TypeOfExam(Name);
		exam.save(examName);
		return true;

	}
 
	public boolean addMarks ( Marks marks) {
		Optional<User> u = urepo.findById(marks.getUserId()) ;
		if (u.isPresent()) {
			User user = u.get();
			in.entity.Marks m = new in.entity.Marks () ;
			m.setUser(user);
			m.setExamDate(marks.getExamDate());
			m.setStudentMarks(marks.getStudentMarks());
			m.setTotalMarks(marks.getTotalMarks());
			m.setSubject(marks.getSubject());
			m.setTypeOfExam(marks.getTypeOfExam());
			
			mrepo.save(m) ;
			return true ;
		}
		return false ;
	}
	public boolean updateMarks ( in.entity.Marks marks) {
		try{
			 mrepo.save(marks);
			return true ;
		}catch ( Exception e) {
			
		}
		return false ;
	}
}