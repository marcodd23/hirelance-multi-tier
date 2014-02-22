package it.mwt.hirelance.business;

import it.mwt.hirelance.business.dto.FilterDataRequest;
import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.Message;
import it.mwt.hirelance.business.model.Message.SystemMessageSubject;
import it.mwt.hirelance.business.model.Proposal;

import javax.ejb.Remote;

@Remote
public interface InboxServiceRemote {

	FilterDataResponse<Proposal> findAllConversations(FilterDataRequest filterDataRequest) throws BusinessException;
	FilterDataResponse<Message> findAllInboxMessages(FilterDataRequest filterDataRequest) throws BusinessException;
	void sendMessage(String messageText, int senderID, int proposalID) throws BusinessException;
	void resetNewMessageCounter(Proposal proposal, int userLoggedID) throws BusinessException;
	void incrementNewMessageCounter(Proposal proposal, int userLoggedID) throws BusinessException;
	int findTotalNewMessages(int userID) throws BusinessException;
	void sendSystemMessage(SystemMessageSubject systemMessageSubject,Proposal proposal);
	boolean decrementSystemNewMessage(int messageID);
}
