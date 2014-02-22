package it.mwt.hirelance.business.impl.jpa;

import it.mwt.hirelance.business.SecurityServiceRemote;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class JPASecurityService
 */
@Stateless
@Remote(SecurityServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class JPASecurityService implements SecurityServiceRemote {

	@PersistenceContext(unitName="HL")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public JPASecurityService() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public User authenticate(String username) throws BusinessException {
		//System.out.println("Sono in JPASecurityService con username "+ username);
		String select = "SELECT u FROM User u WHERE u.username LIKE '"+username+"'";
		TypedQuery<User> query = em.createQuery(select, User.class);
		
		return query.getResultList().get(0);
		
	}

}
