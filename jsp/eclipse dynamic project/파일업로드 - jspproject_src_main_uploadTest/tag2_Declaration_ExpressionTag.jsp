<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 선언 태그(Declaration Tag) -->
<!-- JSP에서 메소드는 반드시 선언태그 안에서 생성해야 한다. -->

<%!
	// 선언태그 안에서 변수는 사용 가능하다.
	int a = 30;

	public int add(int a, int b) {
		int c = a + b;
		return c;
	}
	public int subtract(int a, int b) {
		int c = a - b;
		return c;
	}
	public int multiply(int a, int b) {
		int c = a * b;
		return c;
	}
%>
<%
	// add메소드 호출
	int result1 = add(3, 9);
	// subtract메소드 호출
	int result2 = subtract(3, 9);
	// multiply메소드 호출
	int result3 = multiply(10, 25);
%>

3 + 9 = <%=result1 %><br>
3 - 9 = <%=result2 %><br>
10 * 25 = <%=result3 %><br>
10 * 25 = <%=multiply(10,25) %><br>
