package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUserEmail(String email) ;
	
	public User findByUserEmailAndUserPassword(String email , String password ) ;
}
