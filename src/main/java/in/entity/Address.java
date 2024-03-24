package in.entity;

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
public class Address {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String country ;
	private String state ;
	private String district ;
	private String village ;
	private String street ;
	private String landMark ;
	private Integer pincode ;
	private Long phoneNo ;
	private Long phnoeNo2 ;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user ;
}
