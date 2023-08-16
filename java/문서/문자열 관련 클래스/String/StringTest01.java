class StringTest01 {

  public static void main(String[] args) {
    String str1 = "Java Programming";
	str1.toUpperCase();              //메서드 호출 후에도 
    System.out.println(str1);      //str1의 내용은 수정되지 않는다. 
	System.out.println(str1.toUpperCase());

    String str2=str1.toUpperCase();  //메소드의 처리 결과를 str2에 저장
    System.out.println(str2);          
  }    
}  