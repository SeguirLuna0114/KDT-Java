package Input_Output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Cat_Escape_BufferWriter {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("\\    /\\");
		bw.newLine();		// 줄 구분자
		// bw.newLine()으로 개행을 해줌
		
		bw.write(" )  ( ')");
		bw.newLine();
		
		bw.write("(   / )");
		bw.newLine();
		
		bw.write(" \\(__)|");
		bw.newLine();
		
		// 사용하지 않고, \n을 해줘도 됨
		bw.write("\\    /\\\n"+
				" )  ( ')\n"+
				"(   / )\n"+
				" \\(__)|");

		bw.flush();		// bw.flush()로 스트림에 들어있는 데이터를 비움
		bw.close();		// bw.close()로 스트림 종료
		
	}

}
