package it.mwt.hirelance.business;

import it.mwt.hirelance.business.exceptions.BusinessException;

import javax.ejb.Remote;

@Remote
public interface InitServiceRemote {

	void populate() throws BusinessException;
}
