package it.mwt.hirelance.presentation;


import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.ClientProfile;
import it.mwt.hirelance.business.model.FreelanceProfile;
import it.mwt.hirelance.business.model.User;
import it.mwt.hirelance.business.UserServiceRemote;
import it.mwt.hirelance.common.FactoryEjb;
import it.mwt.hirelance.common.spring.security.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	//@Autowired
	private FactoryEjb factoryEjb = FactoryEjb.getIstance();
	
	//@Autowired
	private UserServiceRemote service  = factoryEjb.getUserServiceRemote();

	@RequestMapping("/views")
	public String views(Model model) throws BusinessException{
		User u = service.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("fp", u.getFreelanceProfile());
		model.addAttribute("cp", u.getClientProfile());
		ClientProfile cp = u.getClientProfile();
		FreelanceProfile fp = u.getFreelanceProfile();
		return "account.views";
	}
	
	@RequestMapping("/delete")
	public String delete() throws BusinessException{
		UserDetailsImpl u= (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		service.delete(u.getUser());
		return "redirect:/j_spring_security_logout";
	}
}
