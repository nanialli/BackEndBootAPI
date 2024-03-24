package in.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId ;
	@CreatedDate
	private LocalDate createdDate ;
	private LocalDate startDate ;
	private LocalDate endDate ;
	private String eventContent ;
}
