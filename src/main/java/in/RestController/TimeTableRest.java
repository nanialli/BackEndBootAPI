package in.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bindings.StatusDto;
import in.bindings.UserIdDto;
import in.entity.StudentTimeTable;
import in.entity.TeacherTimeTable;
import in.service.TimeTable;

@RestController
public class TimeTableRest {

	@Autowired
	private StatusDto status;
	@Autowired
	private TimeTable ttservice;
	
	

	@PutMapping("/updatestudenttimetable")
	public StatusDto updateStudentTimeTable(List<StudentTimeTable> stt) {
		status.setStatus(ttservice.updateStudentTimeTable(stt));
		return status;
	}

	@GetMapping("/getstudenttimetable")
	public List<StudentTimeTable> getStudentTimetable(Integer classId) {
		return ttservice.getStudentTimeTableByClassName(ttservice.getClassList(classId));
	}
	@PostMapping("/getteachertimetable")
	public List<TeacherTimeTable> getTeacherTimeTable ( UserIdDto id){
		return ttservice.getTeacherTimeTable(id.getUserId()) ;
	}
	
	@PutMapping("/updateteachertimetable")
	public StatusDto updateTeacherTimeTable(List<TeacherTimeTable> tttlist) {
		status.setStatus(ttservice.updateTeacherTimeTable(tttlist)) ;
		return status ;
	}
	
}
