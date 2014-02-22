package it.mwt.hirelance.business;

import java.util.List;

import it.mwt.hirelance.business.dto.FilterDataResponse;
import it.mwt.hirelance.business.dto.RequestGrid;
import it.mwt.hirelance.business.dto.ResponseGrid;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.MainCategory;
import it.mwt.hirelance.business.model.Skill;
import it.mwt.hirelance.business.model.SubCategory;

import javax.ejb.Remote;

@Remote
public interface CategoryServiceRemote {

	void create(MainCategory mainCategory) throws BusinessException;
	void create(SubCategory subCategory) throws BusinessException;
	void create(Skill skill) throws BusinessException;
	List<MainCategory> findAllMainCategories() throws BusinessException;
	ResponseGrid<MainCategory> findAllMainCategoriesPaginated(RequestGrid requestGrid) throws BusinessException;
	ResponseGrid<SubCategory> findAllSubCategoriesPaginated(RequestGrid requestGrid, String main_id) throws BusinessException;
	ResponseGrid<Skill> findAllSkillsPaginated(RequestGrid requestGrid,	String main_id) throws BusinessException;
	MainCategory findMainById(int main_id) throws BusinessException;
	SubCategory findSubById(int sub_id) throws BusinessException;
	Skill findSkillById(int skill_id) throws BusinessException;
	List<Skill> findAllSkills() throws BusinessException;
	void delete(MainCategory mainCategory) throws BusinessException;
	void delete(SubCategory subCategory) throws BusinessException;
	void delete(Skill skill) throws BusinessException;
	Skill findSkillByName(String name) throws BusinessException;
	FilterDataResponse<Skill> findAllSubCatAndSkillsByMainID(String mainID,String projectID)throws BusinessException;
}
