package it.mwt.hirelance.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.EAGER;

/**
 * Entity implementation class for Entity: FreelanceProfile
 *
 */
@Entity
@Table(name = "FREELANCES_PROFILES")
public class FreelanceProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4560721760721290985L;
	private int freelanceID;
	private String freelanceName;
	private User user;
	private UploadedFile image;
	private MainCategory category;
	private Curriculum curriculum;
	private float rating;
	private int totalProjects;
	private Collection<WorkRoom> workRooms = new HashSet<WorkRoom>();
	private Collection<ClientProfile> preferredClients = new HashSet<ClientProfile>();
	private Collection<Project> projectWatchList = new HashSet<Project>();
	private Collection<PortfolioItem> portfolio = new ArrayList<PortfolioItem>();

	public FreelanceProfile() {
		super();
	}

	public FreelanceProfile(String freelanceName) {
		super();
		this.freelanceName = freelanceName;
	}

	@Id
	@Column(name = "FREELANCE_ID")
	@GeneratedValue(generator = "Freelance_Gen")
	@SequenceGenerator(name = "Freelance_Gen", sequenceName = "Freelance_Seq", initialValue=1, allocationSize=1)
	public int getFreelanceID() {
		return freelanceID;
	}

	public void setFreelanceID(int freelanceID) {
		this.freelanceID = freelanceID;
	}

	public String getFreelanceName() {
		return freelanceName;
	}

	public void setFreelanceName(String freelanceName) {
		this.freelanceName = freelanceName;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "freelanceProfile")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "MAINCATEGORY_FK", referencedColumnName = "MAINCATEGORY_ID")
	public MainCategory getCategory() {
		return category;
	}

	public void setCategory(MainCategory category) {
		this.category = category;
	}

/*	@OneToMany(mappedBy = "aspirantFreelance", orphanRemoval = true)
	@JoinTable(name = "Freelance_Proposals", joinColumns = @JoinColumn(name = "FREELANCE_FK", referencedColumnName = "FREELANCE_ID"), inverseJoinColumns = @JoinColumn(name = "PROPOSAL_FK", referencedColumnName = "PROPOSAL_ID"))
	public Collection<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(Collection<Proposal> proposals) {
		this.proposals = proposals;
	}*/

	
	
	@OneToMany(mappedBy = "workingFreelance")
	@JoinTable(name = "FREELANCES_PROPOSALS")
	public Collection<WorkRoom> getWorkRooms() {
		return workRooms;
	}

	public void setWorkRooms(Collection<WorkRoom> workRoom) {
		this.workRooms = workRoom;
	}

	@OneToMany(fetch = EAGER)
	@JoinTable(name = "Preferred_Client", joinColumns = @JoinColumn(name = "FREELANCE_FK", referencedColumnName = "FREELANCE_ID"), inverseJoinColumns = @JoinColumn(name = "CLIENT_FK", referencedColumnName = "CLIENT_ID"))
	public Collection<ClientProfile> getPreferredClients() {
		return preferredClients;
	}

	public void setPreferredClients(Collection<ClientProfile> preferredClients) {
		this.preferredClients = preferredClients;
	}

	@OneToMany(cascade = { REMOVE, PERSIST, MERGE, REFRESH }, fetch = EAGER)
	@JoinTable(name = "WatchList", joinColumns = @JoinColumn(name = "FREELANCE_FK", referencedColumnName = "FREELANCE_ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_FK", referencedColumnName = "PROJECT_ID"))
	public Collection<Project> getProjectWatchList() {
		return projectWatchList;
	}

	public void setProjectWatchList(Collection<Project> projectWatchList) {
		this.projectWatchList = projectWatchList;
	}

	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade={PERSIST,MERGE,REFRESH})
	@JoinColumn(name = "CURRICULUM_FK", referencedColumnName = "CURRICULUM_ID")
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "FREELANCE_FK", referencedColumnName = "FREELANCE_ID")
	public Collection<PortfolioItem> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Collection<PortfolioItem> portfolio) {
		this.portfolio = portfolio;
	}
   
/*	public void addProposal(Proposal proposal){
		this.proposals.add(proposal);
	} */
	
	public void addWorkRoom(WorkRoom workRoom){
		this.workRooms.add(workRoom);
	}
	
	public void addPreferredClient(ClientProfile preferredClient){
		this.preferredClients.add(preferredClient);
	}
	
	public void addProjectWatchList(Project project){
		this.projectWatchList.add(project);
	}
	
	public void addPortfolioItem(PortfolioItem portfolioItem){
		this.portfolio.add(portfolioItem);
	}

	@OneToOne(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval=true)
	@JoinColumn(name="IMAGE_ID", nullable = true)
	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getTotalProjects() {
		return totalProjects;
	}

	public void setTotalProjects(int totalProjects) {
		this.totalProjects = totalProjects;
	}

}
