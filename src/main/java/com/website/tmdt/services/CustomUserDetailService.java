//package com.website.tmdt.services;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.website.tmdt.model.User;
//import com.website.tmdt.model.UserRole;
//import com.website.tmdt.model.entity.CustomUserDetails;
//import com.website.tmdt.services.UserServices;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//	@Autowired
//	private UserServices userServices;
//	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userServices.findByUserName(username) ;
//		if(user == null) {
//			throw new UsernameNotFoundException("Sai");
//		}
//		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
//		Set<UserRole> roles = user.getUserRoles();
//		for (UserRole userRole : roles ) {
//			grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
//		}
//		return new CustomUserDetails(user, grantedAuthoritySet);
//	}
//
//
//}