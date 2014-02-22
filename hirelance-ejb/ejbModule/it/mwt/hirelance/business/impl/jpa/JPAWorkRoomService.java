package it.mwt.hirelance.business.impl.jpa;

import java.util.Date;
import java.util.List;

import it.mwt.hirelance.business.WorkRoomServiceRemote;
import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.exceptions.BusinessException.ExceptionCause;
import it.mwt.hirelance.business.model.Message.SystemMessageSubject;
import it.mwt.hirelance.business.model.Project;
import it.mwt.hirelance.business.model.Project.ProjectStatus;
import it.mwt.hirelance.business.model.Proposal;
import it.mwt.hirelance.business.model.Proposal.ProposalStatus;
import it.mwt.hirelance.business.model.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class JPAWorkRoomService
 */
@Stateless
@Remote(WorkRoomServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class JPAWorkRoomService implements WorkRoomServiceRemote {

	@PersistenceContext(unitName="HL")
	private EntityManager em;
	
	@EJB
	private JPAUserService userService;
	
	@EJB
	private JPAInboxService inboxService;
	
    /**
     * Default constructor. 
     */
    public JPAWorkRoomService() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int createWorkRoom(int proposalID) throws BusinessException {

		Proposal proposal = em.find(Proposal.class, proposalID);
		// WorkRoom workroom = new WorkRoom();
		// workroom.setProposal(proposal);
		proposal.setStatus(ProposalStatus.WORKING);
		proposal.setJobStartDate(new Date());
		Project p = proposal.getRefProject();
		p.setStatus(ProjectStatus.HIRING_CLOSED);

		em.merge(p);
		em.merge(proposal);
		
		inboxService.sendSystemMessage(SystemMessageSubject.HIRED_FOR_JOB, proposal);

		return proposal.getRefProject().getProjectID();
	}

	@Override
	public FilterDataResponse<Proposal> findActiveWorkRoom(int projectID,
			User userLogged) throws BusinessException {
		// return em.find(WorkRoom.class, projectID);
		String queryString = "SELECT p FROM Proposal p WHERE p.refProject.projectID = '"
				+ projectID + "' AND p.status = :status";
		// Query query = em.createQuery(queryString);
		// query.setParameter("status", ProposalStatus.WORKING);
		TypedQuery<Proposal> query = em
				.createQuery(queryString, Proposal.class);
		query.setParameter("status", ProposalStatus.WORKING);
		List<Proposal> proposal = query.getResultList();
		if (!proposal.isEmpty()) {
			if (proposal.get(0).getAspirantFreelance().getUser().getUserID() == userLogged.getUserID()
					| proposal.get(0).getRefProject().getClientOwner().getUser().getUserID() == userLogged.getUserID()) {
                  
				FilterDataResponse<Proposal> result = new FilterDataResponse<Proposal>();
				result.setItems(proposal);
				return result;
			}else{
				throw new BusinessException(ExceptionCause.NOT_AUTHORIZED);
			}

		} else {
			throw new BusinessException(ExceptionCause.NOT_FOUND);
			// throw new
			// BusinessException("There are not active WorkRoom for this project");
		}
	}
}
