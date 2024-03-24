package in.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EventInfoDto {

	private LocalDate eventStartDate ;
	private LocalDate eventEndDate ;
	private String eventContent ;
}
