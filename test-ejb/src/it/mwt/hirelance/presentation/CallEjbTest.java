package it.mwt.hirelance.presentation;

import it.mwt.hirelance.business.InitServiceRemote;
import it.mwt.hirelance.business.UserServiceRemote;
import it.mwt.hirelance.business.exceptions.BusinessException;
import it.mwt.hirelance.business.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CallEjbTest
 */
public class CallEjbTest extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
   
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	
	private Properties getGlassFishJndiProperties(String propFile){
		
		System.out.println("Going to got glassfish-jndi.properties ...... ");
		Properties props = new Properties();
		try {
		 props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propFile));
		} catch (IOException e) {
		 System.out.println("Failed to load " + propFile);
		}
		System.out.println("Got glassfish-jndi.properties: " + props);
		return props;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String glassfishJndiPropertiesPath = "/glassfish-jndi.properties";
		UserServiceRemote userService;
//		InitServiceRemote initService;
		List<User> users = new ArrayList<User>();
		Properties gfProperties = getGlassFishJndiProperties(glassfishJndiPropertiesPath);
		InitialContext ctx;
		try {
			ctx = new InitialContext(gfProperties);
			System.out.println("CALLED >>>>>>>>>>>>>>>> Initial context");
			userService = (UserServiceRemote)ctx.lookup(
					"java:global/hirelance-ear/hirelance-ejb/JPAUserService!it.mwt.hirelance.business.UserServiceRemote");
/*			initService = (InitServiceRemote)ctx.lookup(
					"java:global/hirelance-ear/hirelance-ejb/JPAInitService!it.mwt.hirelance.business.InitServiceRemote");
			initService.populate();*/
			System.out.println("OK JNDI LOOKUP >>>>>>>>>>>>>>>>");
			//Thread.sleep(500);
			users.add(userService.findUserById(2));
			users.add(userService.findUserById(3));
			users.add(userService.findUserById(1));
			request.setAttribute("users", users);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 		
	}

}
