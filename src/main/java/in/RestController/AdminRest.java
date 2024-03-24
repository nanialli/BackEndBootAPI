package in.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bindings.ClassNameDto;
import in.bindings.StatusDto;
import in.service.AdminService;

@RestController
public class AdminRest {
	@Autowired
	private AdminService adminService ;
	
	private StatusDto statusDto ;
	
	@PostMapping ( "/createclass")
	public StatusDto createClass ( @RequestBody ClassNameDto dto) {
		statusDto .setStatus (adminService.createClass(dto.getClassName()) );
		return statusDto ;
	}
}
