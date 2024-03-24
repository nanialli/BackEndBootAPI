package in.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bindings.FirstLoginDto;
import in.bindings.LogInDto;
import in.bindings.LogInOPDto;
import in.bindings.UserAddressDto;
import in.entity.Address;
import in.entity.User;
import in.repository.UserRepo;
import in.utils.Utils;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepo urepo ;
	@Autowired
	private Utils util ;
	@Autowired
	private TimeTable ttservice ;
	
	public boolean checkEmail ( String email) {
		User user = urepo.findByUserEmail(email) ;
		return user== null ? true :false ;
	}

	public boolean signIn ( UserAddressDto dto) {
		try {
			User user = new User();
			user.setUserName(dto.getUserName());
			user.setUserEmail(dto.getUserEmail());
			user.setUserPassword(util.createPassword());
			user.setUserRole(dto.getUserRole());
			user.setChangePassword("Y");
			user.setActive_status("Y");
			Address address = new Address();
			address.setCountry(dto.getCountry());
			address.setState(dto.getState());
			address.setDistrict(dto.getDistrict());
			address.setVillage(dto.getVillage());
			address.setPincode(dto.getPincode());
			address.setStreet(dto.getStreet());
			address.setLandMark(dto.getLandmark());
			address.setPhoneNo(dto.getPhnoneNo());
			address.setPhnoeNo2(dto.getPhnoeNo2());
			user.setAddress(Arrays.asList(address));
			address.setUser(user);
			User u = urepo.save(user);
			if (u != null && u.getUserRole().equalsIgnoreCase("teacher"))
				ttservice.createTeacherTimeTable(u) ;
				
		} catch (Exception e) {
			return false ;
		}
		try {
			//TODO : send email with password ;
		}catch(Exception e) {
			return false ;
		}
		return true ;
	}
	
	
	public LogInOPDto login ( LogInDto dto) {
		User user = urepo.findByUserEmailAndUserPassword(dto.getEmail(), dto.getPassword()) ;
		
		in.bindings.LogInOPDto opDto = new in.bindings.LogInOPDto("N","N");
		if (user == null)
			return opDto ;
		opDto.setFirstLogin(user.getChangePassword());
		opDto.setLoginStatus("Y");
		
		return opDto ;
	}
	
	public boolean changePassword (FirstLoginDto dto) {
		if (dto.getPassword().equals(dto.getRePassword())) {
			Optional<User> user = urepo.findById(dto.getUserId()) ;
			if (user.isPresent()) {
			     User u = user.get();
			     u.setUserPassword(dto.getRePassword());
			     u.setChangePassword("N");
			     urepo.save(u) ;
			     return true ;
			}
		}
		return false ;
	}
	
	public boolean forgotPassword ( String email ) {
		
		User user = urepo.findByUserEmail(email) ;
		if (user != null) {
			//TODO : send password to email
			
			return true ;
		}
		return false ;
	}
	
	public boolean deleteUser (Integer userId ) {
		Optional<User> user = urepo.findById(userId) ;
		if ( user.isPresent()) {
			User u = user.get();
			u.setActive_status("N");
			User userr = urepo.save(u) ;
			
			if ( userr.getUserRole().equalsIgnoreCase("teacher")) {
				ttservice.deleteTeacherTimeTable (userr) ;
			}
			return true ;
		}
		return false ;
	}
}
