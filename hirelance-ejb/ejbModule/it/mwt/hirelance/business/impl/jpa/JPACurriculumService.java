package it.mwt.hirelance.business.impl.jpa;

import java.util.Iterator;

import it.mwt.hirelance.business.CurriculumServiceRemote;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.Curriculum;
import it.mwt.hirelance.business.model.Education;
import it.mwt.hirelance.business.model.Employment;
import it.mwt.hirelance.business.model.Language;
import it.mwt.hirelance.business.model.Skill;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class JPACurriculumService
 */
@Stateless
@Remote(CurriculumServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class JPACurriculumService implements CurriculumServiceRemote {

	@PersistenceContext(unitName="HL")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public JPACurriculumService() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createCurriculum(Curriculum curriculum) throws BusinessException{
		em.persist(curriculum);
	}
	
	@Override
	public Curriculum findCurriculumById(int curriculumID) throws BusinessException{
		return em.find(Curriculum.class, curriculumID);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void updateCurriculum(Curriculum curriculum) throws BusinessException {
		em.merge(curriculum);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEducation(Education education) throws BusinessException {
		em.persist(education);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEmployment(Employment employment) throws BusinessException {
		em.persist(employment);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createLanguage(Language language) throws BusinessException {
		em.persist(language);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeSkill(Curriculum c, int skillID) throws BusinessException {
			for (Iterator<Skill> i=c.getCvSkills().iterator();i.hasNext();) {
				if(i.next().getSkillID()==skillID)i.remove();
			}
			this.updateCurriculum(c);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addSkill(Curriculum c, Skill s) throws BusinessException {
		c.addCvSkill(s);
		this.updateCurriculum(c);
	}

	@Override
	public Education findEducationById(int educationID)
			throws BusinessException {
		return em.find(Education.class, educationID);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void updateEducation(Education education) throws BusinessException {
		em.merge(education);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void deleteEducation(Education education)
			throws BusinessException {
		em.remove(em.merge(education));
		em.getEntityManagerFactory().getCache().evictAll();
	}
	
	@Override
	public Employment findEmploymentById(int employmentID)
			throws BusinessException {
		return em.find(Employment.class, employmentID);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void updateEmployments(Employment employment)
			throws BusinessException {
		em.merge(employment);		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void deleteEmployment(Employment employment)
			throws BusinessException {
		em.remove(em.merge(employment));
		em.getEntityManagerFactory().getCache().evictAll();
	}
	
	@Override
	public Language findLanguageById(int langID) throws BusinessException {
		return em.find(Language.class, langID);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void updateLanguage(Language language) throws BusinessException {
		em.merge(language);		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void deleteLanguage(Language language) throws BusinessException {
		em.remove(em.merge(language));
		em.getEntityManagerFactory().getCache().evictAll();
	}

}
