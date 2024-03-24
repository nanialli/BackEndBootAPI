package in.bindings;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Scope("prototype")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

	private Boolean status ;
	
}
