package it.mwt.hirelance.business;

import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.User;

import javax.ejb.Remote;

@Remote
public interface SecurityServiceRemote {

	User authenticate(String username) throws BusinessException;
}
