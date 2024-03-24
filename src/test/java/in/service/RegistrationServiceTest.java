package in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import in.bindings.LogInDto;
import in.bindings.LogInOPDto;
import in.bindings.UserAddressDto;
import in.entity.User;
import in.repository.UserRepo;
import in.utils.Utils;

@SpringBootTest
public class RegistrationServiceTest {

	@InjectMocks
	private RegistrationService rservice ;
	@Mock
	private UserRepo urepo ;
	@Mock
	private Utils util ;
	@Mock
	private TimeTable ttservice ;
	@Test
	public void testCheckEmail_sucess () {
		User userMock = mock(User.class);
		when(urepo.findByUserEmail(anyString())).thenReturn(userMock);
		assertFalse(rservice.checkEmail("nani@gmail.com"));
	}
	
	@Test
	public void testSignIn () {
		UserAddressDto addressMock = mock(UserAddressDto.class);
		User user= new User() ;
		user.setUserRole("teacher");
		when (urepo.save(argThat(u -> u.getChangePassword().equals("Y")))).thenReturn(user);
		assertTrue(rservice.signIn(addressMock));
	}
	@Test
	public void testLogIn () {
		LogInDto loginMock = mock(LogInDto.class) ;
		User userMock = mock(User.class) ;
		when ( urepo.findByUserEmailAndUserPassword(anyString(), anyString())).thenReturn(userMock);
		LogInOPDto login = rservice.login(loginMock);
		assertEquals(any(LogInOPDto.class), login);
		
	}
}
