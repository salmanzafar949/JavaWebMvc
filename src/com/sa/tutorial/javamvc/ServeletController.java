package com.sa.tutorial.javamvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServeletController")
public class ServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServeletController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PersonBeanModel person = new PersonBeanModel();
		String name = request.getParameter("name");
		person.setName(name);
		String email = request.getParameter("email");
		person.setEmail(email);
		person.doSomething();
		request.setAttribute("person", person);
		if(name!=null && email!=null)
		{
		// forwarding the request to view
		getServletContext().getRequestDispatcher("/jspView.jsp").forward(request,response);
		}
		else
		{
			getServletContext().getRequestDispatcher("/jspViewInitial.jsp").forward(request,response);
		}
	}

}
