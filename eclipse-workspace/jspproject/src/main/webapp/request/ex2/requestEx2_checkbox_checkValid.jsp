<%@ page contentType="text/html;charset=utf-8"%>

<html>
<head>
    <title>좋은 사이트 선택</title>	
	<meta charset="utf-8">		
</head>
<body>

	<%	// 폼파일에서 한글값이 post방식으로 전송될 때, utf-8로 인코딩을 시켜주는 역할
		request.setCharacterEncoding("utf-8");

		String[] choice = request.getParameterValues("site");
		String result = "";

		for (int i = 0; i < choice.length; i++) {
			result = result + choice[i] + " ";
		}
	%>

	<center>
		당신은 <font color=blue><%=result%></font> 를 좋아하시는군요.
	</center>

</body>
</html>