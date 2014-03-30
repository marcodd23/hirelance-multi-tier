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

	private UserServiceRemote userService = null;
	private WorkRoomServiceRemote workRoomService = null;
	private SecurityServiceRemote securityService = null;
	private ProjectServiceRemote projectService = null;
	private ProfileServiceRemote profileService = null;
	private PortfolioServiceRemote portfolioService = null;
	private InitServiceRemote initService = null;
	private InboxServiceRemote inboxService = null;
	private ImageServiceRemote imageService = null;
	private CurriculumServiceRemote curriculumService = null;
	private CategoryServiceRemote categoryService = null;

	private static FactoryEjb factoryEjb = null;

	final String glassfishJndiPropertiesPath = "/glassfish-jndi.properties";
	private Properties properties = new Properties();

	public FactoryEjb() {
		super();
		/*
		 * this.properties.setProperty("java.naming.factory.initial",
		 * "com.sun.enterprise.naming.SerialInitContextFactory");
		 * this.properties.setProperty("java.naming.factory.url.pkgs",
		 * "com.sun.enterprise.naming");
		 * this.properties.setProperty("java.naming.factory.state",
		 * "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		 * this.properties .setProperty("org.omg.CORBA.ORBInitialHost",
		 * "localhost");
		 * this.properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		 */

		System.out.println("Going to got glassfish-jndi.properties ...... ");
		try {
			this.properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(glassfishJndiPropertiesPath));
		} catch (IOException e) {
			System.out.println("Failed to load " + glassfishJndiPropertiesPath);
			e.printStackTrace();
		}
		System.out.println("Got glassfish-jndi.properties: "
				+ glassfishJndiPropertiesPath);

	}

	public UserServiceRemote getUserServiceRemote() {
		if (userService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAUserService!it.mwt.hirelance.business.UserServiceRemote";
				userService = (UserServiceRemote) context.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return userService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return userService;

	}

	public WorkRoomServiceRemote getWorkRoomServiceRemote() {
		if (workRoomService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAWorkRoomService!it.mwt.hirelance.business.WorkRoomServiceRemote";
				workRoomService = (WorkRoomServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return workRoomService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return workRoomService;
	}

	public SecurityServiceRemote getSecurityServiceRemote() {
		if (securityService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPASecurityService!it.mwt.hirelance.business.SecurityServiceRemote";
				securityService = (SecurityServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return securityService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return securityService;
	}

	public ProjectServiceRemote getProjectServiceRemote() {
		if (projectService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAProjectService!it.mwt.hirelance.business.ProjectServiceRemote";
				projectService = (ProjectServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return projectService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return projectService;
	}

	public ProfileServiceRemote getProfileServiceRemote() {
		if (profileService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAProfileService!it.mwt.hirelance.business.ProfileServiceRemote";
				profileService = (ProfileServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return profileService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return profileService;
	}

	public PortfolioServiceRemote getPortfolioServiceRemote() {
		if (portfolioService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAPortfolioService!it.mwt.hirelance.business.PortfolioServiceRemote";
				portfolioService = (PortfolioServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return portfolioService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return portfolioService;
	}

	public InitServiceRemote getInitServiceRemote() {
		if (initService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAInitService!it.mwt.hirelance.business.InitServiceRemote";
				initService = (InitServiceRemote) context.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return initService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return initService;
	}

	public InboxServiceRemote getInboxServiceRemote() {
		if (inboxService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPAInboxService!it.mwt.hirelance.business.InboxServiceRemote";
				inboxService = (InboxServiceRemote) context.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return inboxService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return inboxService;
	}

	public ImageServiceRemote getImageServiceRemote() {
		if (imageService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/DISKImageService!it.mwt.hirelance.business.ImageServiceRemote";
				imageService = (ImageServiceRemote) context.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return imageService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return imageService;
	}

	public CurriculumServiceRemote getCurriculumServiceRemote() {
		if (curriculumService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPACurriculumService!it.mwt.hirelance.business.CurriculumServiceRemote";
				curriculumService = (CurriculumServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return curriculumService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return curriculumService;
	}

	public CategoryServiceRemote getCategoryServiceRemote() {
		if (categoryService == null) {
			InitialContext context;
			try {
				context = new InitialContext(this.properties);
				System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
				String jndiName = "java:global/hirelance-ear/hirelance-ejb/JPACategoryService!it.mwt.hirelance.business.CategoryServiceRemote";
				categoryService = (CategoryServiceRemote) context
						.lookup(jndiName);
				System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
				return categoryService;
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return categoryService;
	}

	public static FactoryEjb getIstance() {

		if (factoryEjb == null) {
			factoryEjb = new FactoryEjb();
		}
		return factoryEjb;
	}

}