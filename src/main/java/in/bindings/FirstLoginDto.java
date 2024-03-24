package in.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstLoginDto {

	private Integer userId ;
	private String password ;
	private String rePassword  ;
}
