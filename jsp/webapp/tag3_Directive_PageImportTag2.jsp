<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>

    
<%
	// 날짜, 시간 관련 클래스
	// 3. Calendar 클래스
	Calendar c = Calendar.getInstance();

	// 연도
	int y = c.get(Calendar.YEAR);
	// 월(0~11)
	int m = c.get(Calendar.MONTH)+1;
	// 일
	int d = c.get(Calendar.DATE);
	
	
	// 12시간제 시간
	int h1 = c.get(Calendar.HOUR);
	// 24시간제 시간
	int h2 = c.get(Calendar.HOUR_OF_DAY);
	// AM_PM: 0 (오전) & AM_PM:1 (오후)
	String h = "";
	if(c.get(Calendar.AM_PM) == 0) {
		h = "오전";
	} else {
		h = "오후";
	}
	
	// 분
	int mm = c.get(Calendar.MINUTE);
	// 초
	int s = c.get(Calendar.SECOND);
	
	
	// 요일(1~7)
	int week = c.get(Calendar.DAY_OF_WEEK);
	// console창에 출력
	System.out.println("week"+week);
	
	// 숫자를 문자로 변환하기 위한 String형 배열
	// 일(1), 월(2), 화(3), 수(4), 목(5), 금(6), 토(7) => weekend[week-1]
	String[] weekend = {"일", "월", "화", "수", "목", "금", "토"};
%>

<!-- 12시간제 시간-->
<%=y %>-<%=m %>-<%=d %> <%=h %><%=h1 %>:<%=mm %>:<%=s %>
<%=weekend[week-1] %>요일
<br><br>

<!-- 24시간제 시간-->
<%=y %>-<%=m %>-<%=d %> <%=h2 %>:<%=mm %>:<%=s %>
<%=weekend[week-1] %>요일

