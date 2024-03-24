package in.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StudentAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY   )
	private Integer attendanceId;
	private String attendanceStatus;
	@CreatedDate
	private LocalDate date;
	
	private Integer userId;

}
