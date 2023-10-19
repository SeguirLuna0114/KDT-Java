package send;

//  간단한 서블릿을 정의하고 "/HelloWorld" URL에 매핑
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorld
 * - HttpServlet 클래스를 확장하여 서블릿을 만듦
 * - 서블릿의 생명주기 메서드와 요청 처리 메서드가 여기에서 오버라이드됨
 */
/* @WebServlet 어노테이션 : 서블릿을 정의하고 매핑
 * - description 속성: 서블릿에 대한 설명
 * - urlPatterns 속성: 서블릿이 어떤 URL에 매핑되는지를 지정
 */
@WebServlet(description = "처음 작성하는 자바서블릿", urlPatterns = { "/HelloWorld" })
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 세션 객체 호출 -> 세션 공유
		HttpSession session = request.getSession();
		
		
		// 한글 인코딩
		response.setContentType("text/html; charset=utf-8");
		
		// 출력 스트림 객체 생성
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World~!!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World</h1>");
		out.println("<h1>안녕 하세요.</h1>");
		out.println("</body>");
		out.println("</html>");
		
		// 출력 스트림 객체 닫음
		out.close();
	}

	/** doPost 메서드: HTTP POST 요청을 처리하는 데 사용됨
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet 메서드를 호출하여 처리를 위임
		doGet(request, response);
	}

}
