package it.mwt.hirelance.business.impl.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.mwt.hirelance.business.CategoryServiceRemote;
import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.dto.RequestGrid;
import it.mwt.hirelance.business.dto.ResponseGrid;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.MainCategory;
import it.mwt.hirelance.business.model.Project;
import it.mwt.hirelance.business.model.Skill;
import it.mwt.hirelance.business.model.SubCategory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class JPACategoryService
 */
@Stateless
@Remote(CategoryServiceRemote.class)
public class JPACategoryService implements CategoryServiceRemote {

	@PersistenceContext(unitName="HL")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public JPACategoryService() {
        // TODO Auto-generated constructor stub
    }
    
    
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(MainCategory mainCategory) throws BusinessException {
		em.persist(mainCategory);		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(SubCategory subCategory) throws BusinessException {
		em.persist(subCategory);
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(Skill skill) throws BusinessException {
		em.persist(skill);		
	}

	@Override
	public List<MainCategory> findAllMainCategories() throws BusinessException {
		TypedQuery<MainCategory> q = em.createQuery("SELECT mc FROM MainCategory mc",MainCategory.class);
		return q.getResultList();
	}

	@Override
	public ResponseGrid<MainCategory> findAllMainCategoriesPaginated(
			RequestGrid requestGrid) throws BusinessException {
		//creo la query di selezione e ricerca
		String baseSearch = "SELECT mc FROM MainCategory mc";
		if((!"".equals(requestGrid.getsSearch()))){
			baseSearch += " WHERE mc.name LIKE '" + requestGrid.getsSearch() + "%' ";	
		}
		
		//creo la query completa
		String search = baseSearch + " ORDER BY mc." + requestGrid.getSortCol() + " " + requestGrid.getSortDir();;
		
		//trovo il numero di entità (record) restituiti
		long iTotalRecords = em.createQuery(search).getResultList().size();
		  
		TypedQuery<MainCategory> query = em.createQuery(search, MainCategory.class).setFirstResult(requestGrid.getiDisplayStart()).setMaxResults(requestGrid.getiDisplayLength());
        List<MainCategory> mainCategories = query.getResultList();

		return new ResponseGrid<MainCategory>(requestGrid.getsEcho(), iTotalRecords, iTotalRecords, mainCategories);
	}
	
	@Override
	public ResponseGrid<SubCategory> findAllSubCategoriesPaginated(
			RequestGrid requestGrid, String main_id) throws BusinessException {
		
		String baseSearch = "SELECT sc FROM SubCategory sc";
		if(!requestGrid.getsSearch().equals("") && !main_id.equals("")){
			baseSearch += " WHERE sc.parentCategory.mainID= "+main_id+" AND sc.name LIKE '"+requestGrid.getsSearch()+"%'";
		}else{
			if(!requestGrid.getsSearch().equals("") && main_id.equals("")){
				baseSearch += " WHERE sc.name LIKE '"+requestGrid.getsSearch()+"%'";
			}else{
				if(requestGrid.getsSearch().equals("") && !main_id.equals("")){
					baseSearch += " WHERE sc.parentCategory.mainID = "+main_id;
				}
			}
		}
		
		//creo la query completa
		String search = baseSearch + " ORDER BY sc." + requestGrid.getSortCol() + " " + requestGrid.getSortDir();
		
		//trovo il numero di entità (record) restituiti
		long iTotalRecords = em.createQuery(search).getResultList().size();
		
		TypedQuery<SubCategory> query = em.createQuery(search, SubCategory.class).setFirstResult(requestGrid.getiDisplayStart()).setMaxResults(requestGrid.getiDisplayLength());
        List<SubCategory> subCategories = query.getResultList();
        
        return new ResponseGrid<SubCategory>(requestGrid.getsEcho(), iTotalRecords, iTotalRecords, subCategories);
	}

	@Override
	public ResponseGrid<Skill> findAllSkillsPaginated(RequestGrid requestGrid,
			String main_id) throws BusinessException {
		
		String baseSearch = "SELECT sk FROM Skill sk ";
		if(!requestGrid.getsSearch().equals("") && !main_id.equals("")){
			baseSearch += " WHERE sk.mainCategory.mainID= "+main_id+" AND sk.name LIKE '"+requestGrid.getsSearch()+"%'";
		}else{
			if(!requestGrid.getsSearch().equals("") && main_id.equals("")){
				baseSearch += " WHERE sk.name LIKE '"+requestGrid.getsSearch()+"%'";
			}else{
				if(requestGrid.getsSearch().equals("") && !main_id.equals("")){
					baseSearch += " WHERE sk.mainCategory.mainID = "+main_id;
				}
			}
		}
		
		//creo la query completa
		String search = baseSearch + " ORDER BY sk." + requestGrid.getSortCol() + " " + requestGrid.getSortDir();
		
		//trovo il numero di entità (record) restituiti
		long iTotalRecords = em.createQuery(search).getResultList().size();
		
		TypedQuery<Skill> query = em.createQuery(search, Skill.class).setFirstResult(requestGrid.getiDisplayStart()).setMaxResults(requestGrid.getiDisplayLength());
        List<Skill> skills = query.getResultList();
        
        return new ResponseGrid<Skill>(requestGrid.getsEcho(), iTotalRecords, iTotalRecords, skills);
		
	}

	
	
	@Override
	public MainCategory findMainById(int main_id) throws BusinessException {

	       MainCategory mainCategory = em.find(MainCategory.class, main_id);
	       return mainCategory;
		
	}

	@Override
	public SubCategory findSubById(int sub_id) throws BusinessException {
		SubCategory subCategory = em.find(SubCategory.class, sub_id);
	    return subCategory;
	}

	@Override
	public Skill findSkillById(int skill_id) throws BusinessException {
		Skill skill = em.find(Skill.class, skill_id);
	    return skill;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(MainCategory mainCategory) throws BusinessException {
		
		em.remove(em.merge(mainCategory));
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)

	public void delete(SubCategory subCategory) throws BusinessException {
		em.remove(em.merge(subCategory));
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Skill skill) throws BusinessException {
		em.remove(em.merge(skill));
		
	}

	@Override
	public List<Skill> findAllSkills() throws BusinessException {
		TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s",Skill.class);
		return query.getResultList();
	}

	@Override
	public Skill findSkillByName(String name) throws BusinessException {
		TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s WHERE s.name LIKE '"+name+"'",Skill.class);
		return query.getSingleResult();
	}

	@Override
	public FilterDataResponse<Skill> findAllSubCatAndSkillsByMainID(String mainID, String projectID) {
		Collection<Skill> preSelectedSkills = new ArrayList<Skill>();
		String subCatQueryString ="SELECT sc FROM SubCategory sc WHERE sc.parentCategory.mainID= "+mainID;
		String skillQueryString ="SELECT sk FROM Skill sk WHERE sk.mainCategory.mainID= "+mainID;		
		TypedQuery<SubCategory> querySubCat= em.createQuery(subCatQueryString,SubCategory.class);
		TypedQuery<Skill> querySkill= em.createQuery(skillQueryString,Skill.class);		
		List<SubCategory> subCategories = querySubCat.getResultList();
		List<Skill> skills = querySkill.getResultList();
		if(!projectID.equals("") && projectID!= null){
			preSelectedSkills = em.find(Project.class, Integer.parseInt(projectID)).getSkills();
		}
		FilterDataResponse<Skill> result = new FilterDataResponse<Skill>(subCategories, skills, preSelectedSkills);
		
		return result;
	}


}
