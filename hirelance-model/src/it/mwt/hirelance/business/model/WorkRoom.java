package it.mwt.hirelance.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.*;



import static javax.persistence.TemporalType.TIMESTAMP;


/**
 * Entity implementation class for Entity: WorkRoom
 *
 */
@Entity
@Table(name = "WORKROOMS")
public class WorkRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626952737765316630L;
	private int workRoomID;
	private Project projectAssigned;
	private FreelanceProfile workingFreelance;
	//private ClientProfile clientEmployer;
	private Proposal proposal;
	//private Collection<Message> messages = new HashSet<Message>();
	private Collection<FileShare> fileShare = new HashSet<FileShare>();
	private String status; // Working o Complete
	//private BigDecimal hrsRate;
	//private int hrsWeek;
	private BigDecimal pay;
	private int duration;
	private Date startWork;
    //private Collection<FeedBack> evaluations = new HashSet<FeedBack>();
	private boolean newClientMessage;
	private boolean newFreelanceMessage;

	public WorkRoom() {
		super();
	}

	@Id
	@Column(name = "WORKROOM_ID")
	@GeneratedValue(generator = "WorkRoom_Gen")
	@SequenceGenerator(name = "WorkRoom_Gen", sequenceName = "WorkRoom_Seq", initialValue=1, allocationSize=1)
	public int getWorkRoomID() {
		return workRoomID;
	}

	public void setWorkRoomID(int workRoomID) {
		this.workRoomID = workRoomID;
	}

	@OneToOne
	@JoinColumn(name = "PROJECT_FK", referencedColumnName = "PROJECT_ID")
	public Project getProjectAssigned() {
		return projectAssigned;
	}

	public void setProjectAssigned(Project projectAssigned) {
		this.projectAssigned = projectAssigned;
	}

	@ManyToOne
	@JoinColumn(name = "FREELANCE_FK", referencedColumnName = "FREELANCE_ID")
	public FreelanceProfile getWorkingFreelance() {
		return workingFreelance;
	}

	public void setWorkingFreelance(FreelanceProfile workingFreelance) {
		this.workingFreelance = workingFreelance;
	}

/*	@ManyToOne
	@JoinColumn(name = "CLIENT_FK", referencedColumnName = "CLIENT_ID")
	public ClientProfile getClientEmployer() {
		return clientEmployer;
	}

	public void setClientEmployer(ClientProfile clientEmployer) {
		this.clientEmployer = clientEmployer;
	}*/

/*	@OneToMany(mappedBy = "messageWorkroom")
	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}*/

	@OneToMany(mappedBy = "workRoom")
	public Collection<FileShare> getFileShare() {
		return fileShare;
	}

	public void setFileShare(Collection<FileShare> fileShare) {
		this.fileShare = fileShare;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getPay() {
		return pay;
	}

	public void setPay(BigDecimal pay) {
		this.pay = pay;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Temporal(TIMESTAMP)
	public Date getStartWork() {
		return startWork;
	}

	public void setStartWork(Date startWork) {
		this.startWork = startWork;
	}



	public boolean isNewClientMessage() {
		return newClientMessage;
	}

	public void setNewClientMessage(boolean newClientMessage) {
		this.newClientMessage = newClientMessage;
	}

	public boolean isNewFreelanceMessage() {
		return newFreelanceMessage;
	}

	public void setNewFreelanceMessage(boolean newFreelanceMessage) {
		this.newFreelanceMessage = newFreelanceMessage;
	}

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "PROPOSAL_FK", referencedColumnName = "PROPOSAL_ID")
	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}
   
}
