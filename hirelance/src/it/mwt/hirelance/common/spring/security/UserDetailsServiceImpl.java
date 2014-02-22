package it.mwt.hirelance.common.spring.security;

import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.User;
import it.mwt.hirelance.business.SecurityServiceRemote;
import it.mwt.hirelance.common.FactoryEjb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	private FactoryEjb factoryEjb = FactoryEjb.getIstance();
	
	//@Autowired
	private SecurityServiceRemote service = factoryEjb.getSecurityServiceRemote();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user;
		try {
			//System.out.println("Sono in UserDetailsServiceImpl con username "+username);
			user = service.authenticate(username);
		} catch (BusinessException e) {
			throw new UsernameNotFoundException("utente non trovato");
		}

		if (user==null) {
			throw new UsernameNotFoundException("utente non trovato");
		}
		//System.out.println("Torno in UserDetailsServiceImpl "+user.toString());
		return new UserDetailsImpl(user);
	}

}
