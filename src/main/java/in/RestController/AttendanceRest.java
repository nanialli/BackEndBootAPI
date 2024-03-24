package in.RestController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bindings.StatusDto;
import in.entity.StudentAttendance;
import in.entity.User;
import in.service.AttendanceService;

@RestController
public class AttendanceRest {

	@Autowired
	private AttendanceService attService;
	@Autowired
	private StatusDto status;

	@PostMapping("/attendancetodo")
	public StatusDto doAttendanceStudent(List<StudentAttendance> dtoList) {

		status.setStatus(attService.doAttendanceStudent(dtoList));
		return status;
	}

	@GetMapping("getabsents")
	public List<User> getAbsernts(LocalDate date) {

		return attService.getAbsentStudents(date);
	}
}
