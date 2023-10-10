<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 세션으로 공유된 id값을 가져옴 & Object타입으로 반환되기에 다운캐스팅 필요
	String id = (String)session.getAttribute("id");

	// DB연동을 위해 DAO객체 호출
	MemberDAO dao = MemberDAO.getInstance();
	// id값에 해당하는 한 사람의 상세정보를 구해오는 메소드 호출
	MemberDTO db = dao.getMember(id);
	
	/* checkbox - 가입시 선택했던 취미가 선택되게 설정
	   hobby = 공부-게임-등산- 으로 저장됨
	   => split으로 잘라서 배열에 저장한 후, loop문을 활용하여 선택되게 설정*/
	String[] hobbyList = db.getHobby().split("-");
%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 수정 폼</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		function openDaumPostcode() {
			new daum.Postcode({
				oncomplete: function (data) {
					document.getElementById('post').value = data.zonecode;
					document.getElementById('address').value = data.address;
				}
			}).open();
		}
	</script>

	<!-- 외부 자바스크립트 파일 불러오기 -->
	<script src="member.js"></script>
	
	<script>
		$(document).ready(function() {
			/* 가입시 선택했던 핸드폰 앞자리를 선택되게 설정
			   핸드폰 앞자리(id="phone1")의 후손태그(option)의 값이 선택된 상태로 설정됨*/
			$("#phone1 option[value='<%=db.getPhone1()%>']").attr("selected", true);
			
			/* radio - 가입시 선택했던 성별이 선택되게 설정 */
			$("input:radio[name='gender'][value='<%=db.getGender()%>']").attr("checked", true);
			
			/* checkbox - 가입시 선택했던 취미가 선택되게 설정
			   hobby = 공부-게임-등산- 으로 저장됨
			   => split으로 잘라서 배열에 저장한 후, loop문을 활용하여 선택되게 설정*/
			<% for(String h : hobbyList) {%>
				$("input:checkbox[name='hobby'][value='<%=h%>']").attr("checked", true);
			<% } %>
		})
	
	</script>
</head>

<body>
	<form method="post" action="update.jsp">
	<!-- DTO property의 이름과 같게 name속성 설정 -->
	<input type="hidden" name="id" value="<%=db.getId()%>">
		<table border=1 width=450 align="center">
			<caption>회원 수정 폼</caption>
			<tr>
				<td>ID</td>
				<td><%=db.getId()%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type=password id="passwd" name="passwd">
				</td>
			</tr>
			<tr>
				<td>성명</td>
				<td>
					<input type=text id="name" name="name" 
						   value="<%=db.getName()%>">
				</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>
					<input type=text size=6 maxlength=6 id="jumin1"
							name="jumin1" value="<%=db.getJumin1()%>">-
					<input type=text size=7 maxlength=7 id="jumin2" 
							name="jumin2" value="<%=db.getJumin2()%>">
				</td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td>
					<input type=text size=10 id="mailid"
							name="mailid" value="<%=db.getMailid()%>">@
					<input type=text size=10 id="domain"
							name="domain" value="<%=db.getDomain()%>">
					<select id="email">
						<option value="">직접입력</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="nate.com">네이트</option>
						<option value="gmail.com">gmail</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<input type=text size=4 maxlength=4 id="tel1"
							name="tel1" value="<%=db.getTel1()%>">-
					<input type=text size=4 maxlength=4 id="tel2"
							name="tel2" value="<%=db.getTel2()%>">-
					<input type=text size=4 maxlength=4 id="tel3" 
							name="tel3" value="<%=db.getTel3()%>">
				</td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td>
					<select id="phone1" name="phone1">
						<option value="">번호선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select>-
					<input type=text size=4 maxlength=4 id="phone2"
							name="phone2" value="<%=db.getPhone2()%>">-
					<input type=text size=4 maxlength=4 id="phone3"
							name="phone3" value="<%=db.getPhone3()%>">
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<input type=text size=5 maxlength=5 id="post"
							name="post" value="<%=db.getPost()%>">
					<input type=button value="우편검색" onClick="openDaumPostcode()">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type=text size=45 id="address"
							name="address" value="<%=db.getAddress()%>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type=radio id="male" name="gender" value="남자">남자
					<input type=radio id="female" name="gender" value="여자">여자
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type=checkbox id="h1" name="hobby" value="공부">공부
					<input type=checkbox id="h2" name="hobby" value="게임">게임
					<input type=checkbox id="h3" name="hobby" value="등산">등산
					<input type=checkbox id="h4" name="hobby" value="낚시">낚시
					<input type=checkbox id="h5" name="hobby" value="쇼핑">쇼핑
				</td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td>
					<%-- textarea태그는 value속성X => 태그 사이에 값을 입력 --%>
					<textarea rows=5 cols=50 id="intro" name="intro"
								placeholder="자기소개를 100자 이내로 입력하세요"><%=db.getIntro()%></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan=2 align=center>
					<input type=submit value="회원수정">
					<input type=reset value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>