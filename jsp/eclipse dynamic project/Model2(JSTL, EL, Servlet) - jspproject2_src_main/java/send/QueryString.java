package send;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryString
 */
@WebServlet(description = "값전달 연습", urlPatterns = { "/QueryString" })
public class QueryString extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 한글 인코딩 설정
		response.setContentType("text/html; charset=utf-8");
		
		// 출력스트림 객체 생성
		PrintWriter out = response.getWriter();
		
		// request객체로 전달되는 값을 받아서 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String vclass = request.getParameter("class");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		// 출력스트림 객체를 통해 변수값을 출력
		out.println("<html>");
		out.println("<body>");
		out.println("회원정보 : get방식으로 전달<br>");
		out.println("아이디 : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("이름 : " + name + "<br>");
		out.println("회원구분 : " + vclass + "<br>");
		out.println("전화번호 : " + phone1 + "-" + phone2 + "-" + phone3 + "<br>");
		// javascript를 사용해 이전페이지로 돌아가게 설정
		out.println("<a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body>");
		out.println("</html>");
		
		// 출력스트림 객체를 닫음
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 한글 인코딩 설정
		response.setContentType("text/html; charset=utf-8");
		
		// post방식으로 한글 데이터를 전달 받은 경우에 utf-8로 인코딩을 설정
		request.setCharacterEncoding("utf-8");
		
		
		
		// 출력스트림 객체 생성
		PrintWriter out = response.getWriter();
		
		// request객체로 전달되는 값을 받아서 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String vclass = request.getParameter("class");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		// 출력스트림 객체를 통해 변수값을 출력
		out.println("<html>");
		out.println("<body>");
		out.println("회원정보 : post방식으로 전달<br>");
		out.println("아이디 : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("이름 : " + name + "<br>");
		out.println("회원구분 : " + vclass + "<br>");
		out.println("전화번호 : " + phone1 + "-" + phone2 + "-" + phone3 + "<br>");
		// javascript를 사용해 이전페이지로 돌아가게 설정
		out.println("<a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body>");
		out.println("</html>");
		
		// 출력스트림 객체를 닫음
		out.close();
		
		
		
		// DTO객체 생성 -> 전달받은 값들을 DTO객체에 저장
		QueryDTO dto = new QueryDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setVclass(vclass);
		dto.setPhone(phone1 + "-" + phone2 + "-" + phone3);
		
		// DAO객체 호출
		QueryDAO dao = QueryDAO.getInstance();
		// DAO클래스의 insert()메소드 실행
		int result = dao.insert(dto);
		if(result == 1) {
			System.out.println("회원가입 완료");
		}
		
	}

}
