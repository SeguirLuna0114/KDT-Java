package p2023_08_16;

/*
 *  String 클래스를 이용하여 ‘your’ 가 출력되도록 ①을 채우시오? 
 *  (str의 문자열은 공백 한 칸씩으로 나뉘어 있다.)
 *  
 *  public class Test {
    	public static void main(String[] args){
        	String str = "Do your best";
        	System.out.println(      ①        );
    	}
	}
 */
public class test3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Do your best";
		System.out.println(str.split(" ")[1]);
	}
}
