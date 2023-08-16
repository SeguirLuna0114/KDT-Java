import javax.swing.*;

public class JTreeTest extends JFrame{

   //트리의 노드가 될 데이터를 Object 형 배열로 선언
   Object[] parent={"색상", "스포츠", "음식"};

   public JTreeTest(){

	   //Object 형 배열로 트리를 생성함
      JTree tree = new JTree(parent);

	  //노드의 숫자가 많아지면 자동으로 스크롤바가 생성 되도록 하는 역할
      add(new JScrollPane(tree),"Center");

	  setSize(200, 150);
      setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
  
   }//생성자 end


  public static void main(String[] args) {
	  JTreeTest jt = new JTreeTest();
  }

}