package it.mwt.hirelance.business;

import java.util.List;

import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.dto.RequestGrid;
import it.mwt.hirelance.business.dto.ResponseGrid;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.Category;
import it.mwt.hirelance.business.model.Skill;

import javax.ejb.Remote;

@Remote
public interface CategoryServiceRemote {

	void create(Category mainCategory) throws BusinessException;
	//void create(SubCategory subCategory) throws BusinessException;
	void create(Skill skill) throws BusinessException;
	List<Category> findAllMainCategories() throws BusinessException;
	ResponseGrid<Category> findAllMainCategoriesPaginated(RequestGrid requestGrid) throws BusinessException;
	ResponseGrid<Category> findAllSubCategoriesPaginated(RequestGrid requestGrid, String main_id) throws BusinessException;
	ResponseGrid<Skill> findAllSkillsPaginated(RequestGrid requestGrid,	String main_id) throws BusinessException;
	Category findMainById(int main_id) throws BusinessException;
	Category findSubById(int sub_id) throws BusinessException;
	Skill findSkillById(int skill_id) throws BusinessException;
	List<Skill> findAllSkills() throws BusinessException;
	void delete(Category category) throws BusinessException;
	//void delete(Category subCategory) throws BusinessException;
	void delete(Skill skill) throws BusinessException;
	Skill findSkillByName(String name) throws BusinessException;
	FilterDataResponse<Skill> findAllSubCatAndSkillsByMainID(String mainID,String projectID)throws BusinessException;
}
