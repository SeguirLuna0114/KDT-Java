<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 해당 JSP 페이지의 속성을 설정
    (캐릭터 셋이 UTF-8로 설정되면 페이지의 모든 출력이 UTF-8로 인코딩) -->
    
<% 
	// 요청(request) 객체의 문자 인코딩을 UTF-8로 설정
	request.setCharacterEncoding("UTF-8");

	/* getParameter(String name)메소드를 사용해 
	   지정된 이름(name)에 해당하는 매개변수(parameter) 값을 반환
	*/
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String jumin1 = request.getParameter("jumin1");
	String jumin2 = request.getParameter("jumin2");
	String mailid = request.getParameter("mailid");
	String domain = request.getParameter("domain");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String post = request.getParameter("post");
	String address = request.getParameter("address");
	String gender = request.getParameter("gender");
	
	/* getParameterValues(String name)메소드를 사용해
	   request 객체에서 지정된 이름(name)에 해당하는
	   HTTP 요청 매개변수(parameter)의 값을 문자열 배열로 반환
	   - 하나의 이름으로 여러 값을 가진 매개변수를 처리할 때 유용
	*/
	String[] hobby = request.getParameterValues("hobby");
	// h변수에 누적되는 값(취미1-취미2-취미3-)으로 누적되게
	String h = "";
	for(String hy : hobby) {
		h += hy + "- ";
	}
	
	String intro = request.getParameter("intro");
	// 개행문자를 줄바꿈 태그로 변환
	String introduce = request.getParameter("intro").replace("\n", "<br>");
%>   

ID : <%=id %> <br>
비밀번호 : <%=passwd %> <br>
성명 : <%=name %> <br>
주민번호 : <%=jumin1 %>-<%=jumin2 %> <br>
E-Mail : <%=mailid %>@<%=domain %> <br>
전화번호 : <%=tel1 %>-<%=tel2 %>-<%=tel3 %> <br>
핸드폰 : <%=phone1 %>-<%=phone2 %>-<%=phone3 %> <br>
우편번호 : <%=post %> <br>
주소 : <%=address %> <br>
성별 : <%=gender %> <br>

취미1 :	<%
			if(hobby != null) {
				for(String hobby_val : hobby) {
		%>
					<%=hobby_val %>-
		<%			
				}
			}  else {
				out.print("취미 없음");
			}
		%>
		<br>
		
취미2 :	<%=h %> <br>

자기소개1 : <pre><%=intro %></pre> <br>
자기소개2 : <br><%=introduce %> <br>
 


