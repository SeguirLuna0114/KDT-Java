<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>add.jsp</title>
</head>
<body>
<%	
	// 요청 파라미터의 인코딩을 UTF-8로 설정 => 한글값 깨지지X
	request.setCharacterEncoding("utf-8");

	// 사용자가 선택한 상품을 요청 파라미터로부터 읽어옴
	String productname = request.getParameter("product");

	/* ArrayList을 사용해 선택 상품 저장 */
	// 세션 스코프에서 "productlist" 속성 읽어옴
	ArrayList list = (ArrayList)session.getAttribute("productlist");

	// 만일 null 인 경우 처음 데이터를 추가한 것이므로 새로운 ArrayList 생성
	if(list == null) {
		list = new ArrayList();
	}

	// 선택한 상품을 ArrayList에 추가 & "productlist" 속성으로 세션 스코프에 저장
	list.add(productname);
	session.setAttribute("productlist",list);
%>

	<!-- 자바스크립트를 이용해 간단한 메시지 출력  -->
	<script>
		alert("<%=productname %> 이(가)추가 되었습니다.!!");
		
		// 브라우저의 이전 페이지로 이동 => 상품을 추가하거나 계산 수행
		history.go(-1);
	</script>
</body>
</html>