package in.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public String createPassword () {
		Random r = new Random () ;
	    StringBuilder builder = new StringBuilder("P") ;
	    for ( int i = 0 ;i < 5 ;i++) {
	    	builder.append(r.nextInt(9)) ;
	    }
		return builder.toString();
	}
}
