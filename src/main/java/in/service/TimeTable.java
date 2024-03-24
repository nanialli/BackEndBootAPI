package in.service;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.entity.ClassList;
import in.entity.StudentTimeTable;
import in.entity.TeacherTimeTable;
import in.entity.User;
import in.repository.ClassListRepo;
import in.repository.StudentTimeTableRepo;
import in.repository.TeacherTimeTableRepo;
import in.repository.UserRepo;

@Service
public class TimeTable {

	@Autowired
	private StudentTimeTableRepo sttRepo;
	@Autowired
	private ClassListRepo clrepo;
	@Autowired
	private UserRepo urepo ;
	@Autowired
	private TeacherTimeTableRepo tttRepo ;

	public boolean updateStudentTimeTable(List<StudentTimeTable> stt) {
		try {
			sttRepo.saveAll(stt);
		} catch (Exception e) {
			System.out.println("exception .class");
			return false;
		}
		return true;
	}

	public List<StudentTimeTable> getStudentTimeTableByClassName(ClassList classId) {
		return sttRepo.findAllByClassList(classId);
	}

	public ClassList getClassList(Integer id) {
		Optional<ClassList> findById = clrepo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	 

	public void createTimeTableForClass(ClassList classId) {
		StudentTimeTable stt1 = new StudentTimeTable();
		StudentTimeTable stt2 = new StudentTimeTable();
		StudentTimeTable stt3 = new StudentTimeTable();
		StudentTimeTable stt4 = new StudentTimeTable();
		StudentTimeTable stt5 = new StudentTimeTable();
		StudentTimeTable stt6 = new StudentTimeTable();
		stt1.setClassList(classId);
		stt1.setDayOfWeek(DayOfWeek.MONDAY.toString());
		stt2.setClassList(classId);
		stt2.setDayOfWeek(DayOfWeek.TUESDAY.toString());
		stt3.setClassList(classId);
		stt3.setDayOfWeek(DayOfWeek.WEDNESDAY.toString());
		stt4.setClassList(classId);
		stt4.setDayOfWeek(DayOfWeek.THURSDAY.toString());
		stt5.setClassList(classId);
		stt5.setDayOfWeek(DayOfWeek.FRIDAY.toString());
		stt6.setClassList(classId);
		stt6.setDayOfWeek(DayOfWeek.SATURDAY.toString());
		try {
			sttRepo.saveAll(Arrays.asList(stt1, stt2, stt3, stt4, stt5, stt6));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void createTeacherTimeTable(User u) {
		TeacherTimeTable ttt1 = new TeacherTimeTable();
		TeacherTimeTable ttt2 = new TeacherTimeTable();
		TeacherTimeTable ttt3 = new TeacherTimeTable();
		TeacherTimeTable ttt4 = new TeacherTimeTable();
		TeacherTimeTable ttt5 = new TeacherTimeTable();
		TeacherTimeTable ttt6 = new TeacherTimeTable();
		
		ttt1.setDayOfWeek(DayOfWeek.MONDAY.toString());
		ttt1.setUser(u);
		ttt2.setDayOfWeek(DayOfWeek.MONDAY.toString());
		ttt2.setUser(u);
		ttt3.setDayOfWeek(DayOfWeek.MONDAY.toString());
		ttt3.setUser(u);
		ttt4.setDayOfWeek(DayOfWeek.MONDAY.toString());
		ttt4.setUser(u);
		ttt5.setDayOfWeek(DayOfWeek.MONDAY.toString());
		ttt5.setUser(u);
		ttt6.setDayOfWeek(DayOfWeek.MONDAY.toString());
		ttt6.setUser(u);
		tttRepo.saveAll(Arrays.asList(ttt1,ttt2,ttt3,ttt4,ttt5,ttt6)) ;
	}
	
	public List<TeacherTimeTable> getTeacherTimeTable (Integer teacherId){
		
		Optional<User> u = urepo.findById(teacherId);
		if (u.isPresent()) {
			User user = u.get();
			return tttRepo.findAllByUser(user) ;
			
		}
		return null ;
	}
	
	public boolean updateTeacherTimeTable (List<TeacherTimeTable> ttt) {
		tttRepo.saveAll(ttt) ;
		return true ;
	}

	public void deleteTeacherTimeTable(User userr) {
		List<TeacherTimeTable> tttlist = tttRepo.findAllByUser(userr);
		tttRepo.deleteAll(tttlist);
	}
}
