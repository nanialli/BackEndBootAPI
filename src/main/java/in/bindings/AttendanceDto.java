package in.bindings;

import java.time.LocalDate;

import in.entity.User;
import lombok.Data;

@Data
public class AttendanceDto {

	private Integer attendanceId ;
	private String  attendanceStatus ;
	private LocalDate date ;
	
	
	private Integer userId ;
}
