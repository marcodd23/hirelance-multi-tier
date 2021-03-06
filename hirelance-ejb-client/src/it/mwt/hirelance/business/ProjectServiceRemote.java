package it.mwt.hirelance.business;

import java.util.List;

import it.mwt.hirelance.business.dto.FilterDataRequest;
import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.dto.RequestGrid;
import it.mwt.hirelance.business.dto.ResponseGrid;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.ClientProfile;
import it.mwt.hirelance.business.model.FeedBack;
import it.mwt.hirelance.business.model.Project;
import it.mwt.hirelance.business.model.Proposal;
import it.mwt.hirelance.business.model.User;

import javax.ejb.Remote;

@Remote
public interface ProjectServiceRemote {

	Project createProject(Project pr, ClientProfile cp, int daysToPost) throws BusinessException;
	Project findProjectByID(int projectID) throws BusinessException;
	void projectUpdate(Project pr, int daysToPost, ClientProfile cp) throws BusinessException;
	void checkProjectExpired() throws BusinessException;
	void createProposal(Proposal proposal, int projectID, int freelanceUserID) throws BusinessException;
	List<Proposal> FindAllProposalByProjectID(int projectID) throws BusinessException;
	FilterDataResponse<Proposal> findAllProposalsFiltered(FilterDataRequest filterDataRequest) throws BusinessException;
	boolean checkAlreadyPostProposal(User user,Project project) throws BusinessException;
	Proposal findProposalByID(int proposalID, User userLogged) throws BusinessException;
	FilterDataResponse<Project> findAllProjectsFiltered(FilterDataRequest filterDataRequest) throws BusinessException;
	FilterDataResponse<Project> findAllClientProjectsFiltered(
			FilterDataRequest filterDataRequest) throws BusinessException;
	FilterDataResponse<Project> findAllFreelanceProjectsFiltered(
			FilterDataRequest filterDataRequest) throws BusinessException;
	void addFeedback(FeedBack feedback, int projectID) throws BusinessException;
	ResponseGrid<Project> findAllProjectPaginated(RequestGrid requestGrid) throws BusinessException;
}
