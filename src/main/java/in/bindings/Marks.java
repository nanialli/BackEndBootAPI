package in.bindings;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Marks {

	private LocalDate ExamDate;
	private String typeOfExam;
	private String subject;
	private Integer totalMarks;
	private Integer studentMarks;
	private Integer userId;
}
