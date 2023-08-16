import java.util.*;

class LinkedListTest {
  public static void main(String[] args) {

    LinkedList myQue = new LinkedList();  
    myQue.offer("1-자바");              
    myQue.offer("2-C++");
    myQue.offer("3-API");
    myQue.offer("4-MFC");
        
    while(myQue.peek() != null)        //큐가 비어있지 않다면
      System.out.println(myQue.poll()); //큐에서 데이터를 꺼내온다.
  }  
 }    