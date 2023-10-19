package send;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class multiPara
 */
@WebServlet("/multiPara")
public class multiPara extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 한글 인코딩 설정
		// 전송되는 컨텐츠의 타입과 문자열 인코딩 설정
		response.setContentType("text/html; charset=utf-8");
		// 한글값이 post방식으로 전달될 경우(한글 데이터를 받을 때)
		request.setCharacterEncoding("utf-8");
		
		
		// 출력 스트림 객체 생성
		PrintWriter out = response.getWriter();
		
		// 전달된 item변수값을 받음
		String[] item = request.getParameterValues("item");
		
		out.println("선택된 항목: <br>");
		for(int i=0; i<item.length; i++) {
			out.println(item[i] + " ");
		}
		
	}

}
