import java.util.*;

public class StackTest01 {
  public static void main(String[] args) {
    Stack myStack = new Stack();
    myStack.push("1-자바"); 
    myStack.push("2-C++"); 
    myStack.push("3-API"); 
    myStack.push("4-MFC"); 

    while(!myStack.isEmpty()) {
      System.out.println( myStack.pop());
    }
  }    
}                                                     
