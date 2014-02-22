package it.mwt.hirelance.business.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: SubCategory
 *
 */
@Entity
@Table(name = "SUB_CATEGORIES")
public class SubCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1810412211985020007L;
	private int subID;
	private String name;
	private MainCategory parentCategory;
	private Collection<Project> projects = new HashSet<Project>();

	public SubCategory() {
		super();
	}

	public SubCategory(String name, MainCategory parentCategory) {
		super();
		this.name = name;
		this.parentCategory = parentCategory;
	}

	@Id
	@Column(name = "SUBCATEGORY_ID")
	@GeneratedValue(generator = "SubCategory_Gen")
	@SequenceGenerator(name = "SubCategory_Gen", sequenceName = "SubCategory_Seq", initialValue=1, allocationSize=1)
	public int getSubID() {
		return subID;
	}

	public void setSubID(int subID) {
		this.subID = subID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENTCATEGORY_FK")
	public MainCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(MainCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	@OneToMany(mappedBy = "projectSubCategory")
	@JsonIgnore
	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}
   
}
