package it.mwt.hirelance.common;

import it.mwt.hirelance.business.CategoryServiceRemote;
import it.mwt.hirelance.business.CurriculumServiceRemote;
import it.mwt.hirelance.business.ImageServiceRemote;
import it.mwt.hirelance.business.InboxServiceRemote;
import it.mwt.hirelance.business.InitServiceRemote;
import it.mwt.hirelance.business.PortfolioServiceRemote;
import it.mwt.hirelance.business.ProfileServiceRemote;
import it.mwt.hirelance.business.ProjectServiceRemote;
import it.mwt.hirelance.business.SecurityServiceRemote;
import it.mwt.hirelance.business.UserServiceRemote;
import it.mwt.hirelance.business.WorkRoomServiceRemote;

import java.io.IOException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Component;

@Component
public class FactoryEjb {

	private static FactoryEjb  factoryEjb= null;
	
	final String glassfishJndiPropertiesPath = "/glassfish-jndi.properties";
	private Properties properties = new Properties();
	 
	public FactoryEjb() {
		super();
		this.properties.setProperty("java.naming.factory.initial",
				"com.sun.enterprise.naming.SerialInitContextFactory");
		this.properties.setProperty("java.naming.factory.url.pkgs",
				"com.sun.enterprise.naming");
		this.properties.setProperty("java.naming.factory.state",
				"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		this.properties
				.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		this.properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		
/*		System.out.println("Going to got glassfish-jndi.properties ...... ");
		try {
			this.properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(glassfishJndiPropertiesPath));
		} catch (IOException e) {
			System.out.println("Failed to load " + glassfishJndiPropertiesPath);
			e.printStackTrace();
		}
		System.out.println("Got glassfish-jndi.properties: " + glassfishJndiPropertiesPath);*/
		
	}
	
	
	public UserServiceRemote getUserServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAUserService!it.mwt.hirelance.business.UserServiceRemote";
			UserServiceRemote userService = (UserServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return userService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public WorkRoomServiceRemote getWorkRoomServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAWorkRoomService!it.mwt.hirelance.business.WorkRoomServiceRemote";
			WorkRoomServiceRemote workRoomService = (WorkRoomServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return workRoomService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public SecurityServiceRemote getSecurityServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPASecurityService!it.mwt.hirelance.business.SecurityServiceRemote";
			SecurityServiceRemote securityService = (SecurityServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return securityService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProjectServiceRemote getProjectServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAProjectService!it.mwt.hirelance.business.ProjectServiceRemote";
			ProjectServiceRemote projectService = (ProjectServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return projectService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProfileServiceRemote getProfileServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAProfileService!it.mwt.hirelance.business.ProfileServiceRemote";
			ProfileServiceRemote profileService = (ProfileServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return profileService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PortfolioServiceRemote getPortfolioServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAPortfolioService!it.mwt.hirelance.business.PortfolioServiceRemote";
			PortfolioServiceRemote portfolioService = (PortfolioServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return portfolioService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public InitServiceRemote getInitServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAInitService!it.mwt.hirelance.business.InitServiceRemote";
			InitServiceRemote initService = (InitServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return initService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public InboxServiceRemote getInboxServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAInboxService!it.mwt.hirelance.business.InboxServiceRemote";
			InboxServiceRemote inboxService = (InboxServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return inboxService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ImageServiceRemote getImageServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/DISKImageService!it.mwt.hirelance.business.ImageServiceRemote";
			ImageServiceRemote imageService = (ImageServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return imageService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CurriculumServiceRemote getCurriculumServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPACurriculumService!it.mwt.hirelance.business.CurriculumServiceRemote";
			CurriculumServiceRemote curriculumService = (CurriculumServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return curriculumService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CategoryServiceRemote getCategoryServiceRemote() {
		InitialContext context;
		try {
			context = new InitialContext(this.properties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPACategoryService!it.mwt.hirelance.business.CategoryServiceRemote";
			CategoryServiceRemote categoryService = (CategoryServiceRemote) context.lookup(jndiName);
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			return categoryService;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static FactoryEjb getIstance(){
		
		if(factoryEjb == null){
			factoryEjb = new FactoryEjb();
		}
		return factoryEjb;
	}
	
}
