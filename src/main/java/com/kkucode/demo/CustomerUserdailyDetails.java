package com.kkucode.demo;
//duke come here
import java.util.Collection;

import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerUserdailyDetails implements UserDetails {
	
	private User_daily userday;
	
	public CustomerUserdailyDetails(User_daily userday) {
		this.userday = userday;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return userday.getPassword();
	}

	@Override
	public String getUsername() {
		return userday.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
