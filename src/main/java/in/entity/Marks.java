package in.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@CreatedDate
	private LocalDate createdDate ;
	@LastModifiedDate
	private LocalDate updatedDate ;
	
	private LocalDate ExamDate ;
	private String typeOfExam ;
	private String subject ;
	private Integer totalMarks ;
	private Integer studentMarks ;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user ;
}
