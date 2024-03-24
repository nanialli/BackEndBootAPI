package in.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bindings.FirstLoginDto;
import in.bindings.LogInDto;
import in.bindings.LogInOPDto;
import in.bindings.StatusDto;
import in.bindings.UserAddressDto;
import in.bindings.UserIdDto;
import in.service.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationRest {

	@Autowired
	private RegistrationService rservice;
	@Autowired
	private StatusDto status;

	@PostMapping("/login")
	public LogInOPDto logIn(LogInDto dto) {
		return rservice.login(dto);
	}

	@PostMapping("/signin")
	public StatusDto signIn(UserAddressDto dto) {

		status.setStatus(rservice.signIn(dto));
		return status;
	}
	
	@PostMapping("/changepassword")
	public StatusDto changePassword ( FirstLoginDto dto) {
		status.setStatus( rservice.changePassword(dto)) ;
		return status ;
	}
	@PostMapping ( "/forgotPassword")
	public StatusDto forgotPassword ( String email) {
		status.setStatus( rservice.forgotPassword(email) ) ;
		return status ;
	}
	
	@DeleteMapping( "/deleteuser")
	public StatusDto deleteUser (UserIdDto user) {
		status.setStatus( rservice.deleteUser(user.getUserId()) ) ;
		return status ;
	}
}
