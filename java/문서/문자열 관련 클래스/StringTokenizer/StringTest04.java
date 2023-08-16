import java.util.*;

class StringTest04 {

  public static void main(String[] args) {
    StringTokenizer str = 
		new StringTokenizer("이순신#을지문덕#강감찬#광개토대왕", "#");
    
	//파싱된 문자열이 모두 몇 개인지 되는지 알려줌
    int cnt = str.countTokens();  
    System.out.println("파싱할 문자열의 총갯수-> " + cnt);

	System.out.println(str.nextToken());
    while(str.hasMoreTokens()){ //토큰이 있으면
      System.out.print(str.nextToken());//차례대로 파싱된 문자열을 얻어온다.
	}

  }  // main() end 

}      