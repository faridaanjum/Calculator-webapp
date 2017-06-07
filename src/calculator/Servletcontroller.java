package calculator;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


@WebServlet("/ServletController")



	public class Servletcontroller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 double c;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		BasicCalc det=new BasicCalc();
		double a=Double.valueOf(req.getParameter("a"));
		double b=Double.valueOf(req.getParameter("b"));
		det.setA(a);
		det.setB(b);
		String operation=req.getParameter("operation");
		//PrintWriter pw=resp.getWriter();
		
	switch (operation)		
	
		{
	case "Add":
		c=det.Add();
	    // pw.println(c);
		break;
	case "Subtract":
		c=det.Subtract();
		//pw.println(c);
		break;
	case "Multiply":
		c=det.Multiply();
		//pw.println(c);;
		break;
	case "Division":
		c=det.Divide();
		//pw.println(c);
		break;
		default:System.out.println("wrong choice");
		//pw.close();
		}
	
	req.setAttribute("answer",c);
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
		} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	doGet(req, resp);
	//req.setAttribute("answer",c);
	}
}
	



	