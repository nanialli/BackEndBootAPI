package in.bindings;

import lombok.Data;

@Data
public class UserAddressDto {

	private String userName ;
	private String userEmail ;
	private String userRole ;
	
	private String village ;
	private String country ;
	private String state ;
	private String district ;
	private Integer pincode ;
	private String street ;
	private String landmark ;
	private Long phnoneNo ;
	private Long phnoeNo2 ;
}
