// ID중복 검사
function idcheck() {
	// 입력 필드에 입력된 값을 가져옴
	var id = document.getElementById("id");

	// 입력된 값이 비어 있는지 확인
	if (id.value == "") {
		alert("ID를 입력 하세요.");
		id.focus();
		return false;
	} else {
		var ref = "idcheck.jsp?id=" + id.value;
		// open("팝업창에 실행될 문서명","윈도우이름","옵션");
		window.open(ref, "idcheck", "width=300, height=200");
	}
}

// 주민번호 뒷자리로 포커스 이동
function move() {
	//  "jumin1" 및 "jumin2" ID를 가진 요소에서 값을 가져와 할당
	var jumin1 = document.getElementById("jumin1");
	var jumin2 = document.getElementById("jumin2");

	// 주민번호 앞자리 6자리를 입력 했으면
	if (jumin1.value.length == 6) {
		// jumin2 입력 요소로 포커스가 이동
		jumin2.focus();
	}
}

// 도메인 선택
function sel() {
	var domain = document.getElementById("domain");
	var email = document.getElementById("email");

	if (email.value == "") {		// 직접입력을 선택한 경우	
		// 도메인 입력란을 수정 가능하도록 읽기 전용기능 해제
		domain.readOnly = false;
		domain.value = "";
		domain.focus();
	} else {						// 도메인명을 선택한 경우
		domain.value = email.value;
		// 도메인명을 읽기전용으로 처리
		domain.readOnly = true;
	}
}

// 유효성 검사
function check() {
	var id = document.getElementById("id");
	var passwd = document.getElementById("passwd");
	var name = document.getElementById("name");
	var jumin1 = document.getElementById("jumin1");
	var jumin2 = document.getElementById("jumin2");
	var mailid = document.getElementById("mailid");
	var domain = document.getElementById("domain");
	var tel1 = document.getElementById("tel1");
	var tel2 = document.getElementById("tel2");
	var tel3 = document.getElementById("tel3");
	var phone1 = document.getElementById("phone1");
	var phone2 = document.getElementById("phone2");
	var phone3 = document.getElementById("phone3");
	var post = document.getElementById("post");
	var address = document.getElementById("address");
	var male = document.getElementById("male");
	var female = document.getElementById("female");
	var h1 = document.getElementById("h1");
	var h2 = document.getElementById("h2");
	var h3 = document.getElementById("h3");
	var h4 = document.getElementById("h4");
	var h5 = document.getElementById("h5");
	var intro = document.getElementById("intro");

	if (id.value == "") {
		alert("ID를 입력 하세요.");
		id.focus();
		return false;
	}
	if (passwd.value == "") {
		alert("비밀번호를 입력 하세요.");
		passwd.focus();
		return false;
	}
	if (name.value == "") {
		alert("이름을 입력 하세요.");
		name.focus();
		return false;
	}
	if (jumin1.value == "") {
		alert("주민번호 앞자리를 입력 하세요.");
		jumin1.focus();
		return false;
	}
	if (jumin1.value.length != 6) {
		alert("주민번호 앞자리 6자리를 입력 하세요.");
		jumin1.value = "";
		jumin1.focus();
		return false;
	}
	// isNaN() : 문자가 포함되면 true를 리턴
	if (isNaN(jumin1.value)) {
		alert("숫자만 입력 하세요.");
		jumin1.value = "";
		jumin1.focus();
		return false;
	}
	if (jumin2.value == "") {
		alert("주민번호 뒷자리를 입력 하세요.");
		jumin2.focus();
		return false;
	}
	if (jumin2.value.length != 7) {
		alert("주민번호 뒷자리 7자리를 입력 하세요.");
		jumin2.value = "";
		jumin2.focus();
		return false;
	}
	// isNaN() : 문자가 포함되면 true를 리턴
	if (isNaN(jumin2.value)) {
		alert("숫자만 입력 하세요.");
		jumin2.value = "";
		jumin2.focus();
		return false;
	}
	if (mailid.value == "") {
		alert("Email주소를 입력 하세요.");
		mailid.focus();
		return false;
	}
	if (domain.value == "") {
		alert("도메인명을 입력 하세요.");
		domain.focus();
		return false;
	}
	if (tel1.value == "") {
		alert("전화번호 앞자리를 입력 하세요.");
		tel1.focus();
		return false;
	}
	if (isNaN(tel1.value)) {
		alert("숫자만 입력 하세요.");
		tel1.value = "";
		tel1.focus();
		return false;
	}
	if (tel2.value == "") {
		alert("전화번호 중간자리를 입력 하세요.");
		tel2.focus();
		return false;
	}
	if (isNaN(tel2.value)) {
		alert("숫자만 입력 하세요.");
		tel2.value = "";
		tel2.focus();
		return false;
	}
	if (tel3.value == "") {
		alert("전화번호 끝자리를 입력 하세요.");
		tel3.focus();
		return false;
	}
	if (isNaN(tel3.value)) {
		alert("숫자만 입력 하세요.");
		tel3.value = "";
		tel3.focus();
		return false;
	}
	if (phone1.value == "") {
		alert("핸드폰 번호 앞자리를 선택 하세요.");
		phone1.focus();
		return false;
	}
	if (phone2.value == "") {
		alert("핸드폰 번호 중간자리를 입력 하세요.");
		phone2.focus();
		return false;
	}
	if (isNaN(phone2.value)) {
		alert("숫자만 입력 하세요.");
		phone2.value = "";
		phone2.focus();
		return false;
	}
	if (phone3.value == "") {
		alert("핸드폰 번호 끝자리를 입력 하세요.");
		phone3.focus();
		return false;
	}
	if (isNaN(phone3.value)) {
		alert("숫자만 입력 하세요.");
		phone3.value = "";
		phone3.focus();
		return false;
	}
	if (post.value == "") {
		alert("우편번호를 입력 하세요.");
		post.focus();
		return false;
	}
	if (address.value == "") {
		alert("주소를 입력 하세요.");
		address.focus();
		return false;
	}
	if (male.checked == false && female.checked == false) {
		alert("성별을 선택 하세요.");
		return false;
	}

	// 취미를 2개 이상 입력해야 하게 설정
	var cnt = 0;
	if (h1.checked) {
		cnt++;
	}
	if (h2.checked) {
		cnt++;
	}
	if (h3.checked) {
		cnt++;
	}
	if (h4.checked) {
		cnt++;
	}
	if (h5.checked) {
		cnt++;
	}

	if (cnt < 2) {
		alert("취미를 2개 이상 선택하세요.");
		// false를 반환하여 폼 제출을 중단
		return false;
	}

	// 자기소개 란은 100자 이내로 입력해야 함
	if (intro.value == "") {
		alert("자기소개를 입력 하세요.");
		intro.focus();
		return false;
	}
	if (intro.value.length > 100) {
		alert("자기소개를 100자 이내로 입력 하세요.");
		// 값을 지우지는 않고, 포커스만 들어가게 함
		intro.focus();
		return false;
	}
}