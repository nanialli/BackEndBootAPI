package in.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer userId ;
	private String userName ;
	private String userEmail ;
	private String userPassword ;
	private String userRole ;
	private String changePassword ;
	private String active_status ;
	

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Address> address ;
}
