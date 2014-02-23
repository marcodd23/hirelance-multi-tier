package it.mwt.hirelance.business.impl.common;

//import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class FilePathConfiguration
 */
@Singleton
@LocalBean
public class FilePathLoader {

	//@Resource(name = "basePath")
	private String basePath = "/home/marco/WORKSPACE ECLIPSE/HIRELANCE WORKSPACE/files_hirelance/";
	
	//@Resource(name = "clientFolder")
	private String clientFolder = "/client/";
	
	//@Resource(name = "clientImagePath")
	private String clientImagePath = "/client/images/";
	
	//@Resource(name = "freelancerFolder")
	private String freelancerFolder = "/freelancer/";
	
	//@Resource(name = "freelancerImagePath")
	private String freelancerImagePath = "/freelancer/images/";
	
	//@Resource(name = "portfolioItemImagePath")
	private String portfolioItemImagePath = "/freelancer/images/portfolio/";
	
    /**
     * Default constructor. 
     */
    public FilePathLoader() {
        
    }


	public String getBasePath() {
		return basePath;
	}


	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}


	public String getClientFolder() {
		return clientFolder;
	}


	public void setClientFolder(String clientFolder) {
		this.clientFolder = clientFolder;
	}


	public String getClientImagePath() {
		return clientImagePath;
	}


	public void setClientImagePath(String clientImagePath) {
		this.clientImagePath = clientImagePath;
	}


	public String getFreelancerFolder() {
		return freelancerFolder;
	}


	public void setFreelancerFolder(String freelancerFolder) {
		this.freelancerFolder = freelancerFolder;
	}


	public String getFreelancerImagePath() {
		return freelancerImagePath;
	}


	public void setFreelancerImagePath(String freelancerImagePath) {
		this.freelancerImagePath = freelancerImagePath;
	}


	public String getPortfolioItemImagePath() {
		return portfolioItemImagePath;
	}


	public void setPortfolioItemImagePath(String portfolioItemImagePath) {
		this.portfolioItemImagePath = portfolioItemImagePath;
	}  

}
