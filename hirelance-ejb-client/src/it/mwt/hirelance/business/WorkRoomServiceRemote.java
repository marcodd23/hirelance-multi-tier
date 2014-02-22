package it.mwt.hirelance.business;

import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.Proposal;
import it.mwt.hirelance.business.model.User;

import javax.ejb.Remote;

@Remote
public interface WorkRoomServiceRemote {

	int createWorkRoom(int proposalID) throws BusinessException;
	FilterDataResponse<Proposal> findActiveWorkRoom(int projectID, User userLogged)throws BusinessException;
}
