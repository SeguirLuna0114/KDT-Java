import javax.swing.*;
import javax.swing.tree.*; //javax.swing.tree.DefaultMutableTreeNode;
import java.util.*; //java.util.Vector;

public class DefaultMutableTreeNodeTest extends JFrame{

  public DefaultMutableTreeNodeTest(){

    //1. 루트 노드 생성
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("좋아하는 것");

    //2. 생성한 root를 루트 노드로 하는 트리 객체를 생성하여 
    JTree tree = new JTree(root);
    add(new JScrollPane(tree),"Center");     //프레임에 붙임

    //3. 부모 노드를 만들어서 
    DefaultMutableTreeNode par01 = new DefaultMutableTreeNode("색상");
    root.add(par01);                //루트 노드에 추가

    //4. 세 개의 노드(빨강, 초록, 파랑)를 생성하여 
    DefaultMutableTreeNode col01 = new DefaultMutableTreeNode("빨강");
    DefaultMutableTreeNode col02 = new DefaultMutableTreeNode("초록");
    DefaultMutableTreeNode col03 = new DefaultMutableTreeNode("파랑");

	//5. 색상 노드에 붙인다.
    par01.add(col01);  
    par01.add(col02);
    par01.add(col03);

	DefaultMutableTreeNode col01_01 = new DefaultMutableTreeNode("찐한빨강");
	DefaultMutableTreeNode col01_02 = new DefaultMutableTreeNode("연한빨강");

	col01.add(col01_01);
	col01.add(col01_02);

    //루트 노드에 붙일 또 다른 부모 노드를 생성
    DefaultMutableTreeNode par02 = new DefaultMutableTreeNode("스포츠");
    root.add(par02);

    //부모 노드에 자식 노드를 추가하는 작업을 일괄처리하기 위해서 벡터 객체 생성
	// Vector<String> vec = new Vector<String>(); String형의 데이터만 저장
    Vector<DefaultMutableTreeNode> vec = new Vector<DefaultMutableTreeNode>();	

    //자식 노드에 붙일 데이터를 배열로 선언
    String[] data02 = {"야구", "축구", "농구", "골프", "수영"};
    
	//자식 노드에 붙일 데이터의 개수만큼 반복 수행하면서
    for(int i=0; i<data02.length; i++){ 

      //벡터의 요소를 추가하기 위해서 노드 객체 생성
      vec.add(new DefaultMutableTreeNode(data02[i]));

      //생성된 노드를 스포츠 노드에 붙임
      par02.add(vec.get(i));

    }//for end

    //루트의 붙은 첫 번째 노드를 확장한다. 
//    tree.expandPath(new TreePath(par01.getPath()));

    setSize(200,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
  }//생성자 end


  public static void main(String[] args) {
    DefaultMutableTreeNodeTest dmt = new DefaultMutableTreeNodeTest();
  }

}