package send;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// request객체로 공유 설정
		request.setAttribute("request", "requestValue");  
		
		// redirect 방식으로 포워딩
//		response.sendRedirect("servlet/ex6/redirect.jsp");
		response.sendRedirect("/jspproject2/servlet/ex6/redirect.jsp");
	}

}
