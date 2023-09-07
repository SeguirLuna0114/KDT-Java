### 작성한 프로젝트 배포 방법

1. 생성한 web프로젝트를 war파일로 압축(Export)

2. 해당 파일을 Apache Tomcat이 설치된 경로로 이동
방법1) 	1) 압축을 풀고, 해당 파일을 Apache Tomcat이 저장된 dir로 이동
	C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\ROOT

	2) 해당 ROOT디렉토리 하위에 war파일 내부 dir를 붙여놓기

	3) [내 컴퓨터] -> [관리] 에서 ApacheTomcat을 구동시킴(실행)

	4) web에서 localhost로 접속하면 해당 프로젝트로 작성한 index.html로 접속 가능
	=> 이용 가능

방법2) 	1) 압축을 풀지 않은 채로, 해당 파일명을 "ROOT"로 설정

	2) ApacheTomcat이 설치된 dir에서 webapps파일에 옮겨둠
	(이때, webapps파일 내부에 ROOT디렉토리는 없어야 함)

	3) [내 컴퓨터] -> [관리] 에서 ApacheTomcat을 구동시킴(실행)
	
	4) 실행과 동시에, webapps파일 하위에는 ROOT라는 디렉토리가 압축이 풀리며 생성되고
	   web에서 localhost로 접속이 가능해짐
	=> 이용 가능한 상태가 됨