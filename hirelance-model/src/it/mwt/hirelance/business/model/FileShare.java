package it.mwt.hirelance.business.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SharedFile
 *
 */
@Entity

@Table(name = "FILES_SHARE")
public class FileShare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7687253969238838499L;
	private int fileShareID;
	private String title;
	private File sharedFile;
	private Date dateUpload;
	private WorkRoom workRoom;

	public FileShare() {
		super();
	}

	public FileShare(String title, File sharedFile, Date dateUpload,
			WorkRoom workRoom) {
		super();
		this.title = title;
		this.sharedFile = sharedFile;
		this.dateUpload = dateUpload;
		this.workRoom = workRoom;
	}

	@Id
	@Column(name = "FILESHARE_ID")
	@GeneratedValue(generator = "FileShare_Gen")
	@SequenceGenerator(name = "FileShare_Gen", sequenceName = "FileShare_Seq", initialValue=1, allocationSize=1)
	public int getFileShareID() {
		return fileShareID;
	}

	public void setFileShareID(int fileShareID) {
		this.fileShareID = fileShareID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getSharedFile() {
		return sharedFile;
	}

	public void setSharedFile(File sharedFile) {
		this.sharedFile = sharedFile;
	}

	@Temporal(TIMESTAMP)
	public Date getDateUpload() {
		return dateUpload;
	}

	public void setDateUpload(Date dateUpload) {
		this.dateUpload = dateUpload;
	}

	@ManyToOne
	@JoinColumn(name = "WORKROOM_FK", referencedColumnName = "WORKROOM_ID")
	public WorkRoom getWorkRoom() {
		return workRoom;
	}

	public void setWorkRoom(WorkRoom workRoom) {
		this.workRoom = workRoom;
	}
   
}
