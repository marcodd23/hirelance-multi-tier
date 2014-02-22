package it.mwt.hirelance.business.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: MainCategory
 *
 */
@Entity
@Table(name = "MAIN_CATEGORIES")
public class MainCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2533334823313199961L;
	private int mainID;
	private String name;
	private Collection<Skill> skills = new HashSet<Skill>();
	private Collection<SubCategory> subCategory = new ArrayList<SubCategory>();

	public MainCategory() {
		super();
	}

	public MainCategory(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(generator = "MainCategory_Gen")
	@SequenceGenerator(name = "MainCategory_Gen", sequenceName = "MainCategory_Seq", initialValue=1, allocationSize=1)
	@Column(name = "MAINCATEGORY_ID")
	public int getMainID() {
		return mainID;
	}

	public void setMainID(int mainID) {
		this.mainID = mainID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinTable(name = "MAINCATEGORIES_SKILLS")*/
	@OneToMany(mappedBy="mainCategory", orphanRemoval = true)
	@JsonIgnore
	public Collection<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Collection<Skill> skills) {
		this.skills = skills;
	}

/*	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinTable(name = "MAINCATEGORIES_SUBCATEGORIES")*/
	@OneToMany(mappedBy="parentCategory", orphanRemoval = true)
	@JsonIgnore
	public Collection<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Collection<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	
   
}
