package com.kkucode.demo;
//sr
//no i am duke and I want to test fetch
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerUserdayDetailsService implements UserDetailsService {

	@Autowired
	private User_dailyRepository userdayRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User_daily userday = (User_daily) userdayRepo.findByUsername(username);
		if(userday == null) {
			throw new UsernameNotFoundException("User not Found");
		}
		
		return new CustomerUserdailyDetails(userday);
	}

}
