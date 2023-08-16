package Input_Output;

public class Cat_Escape_StringBuilder_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// StringBuilder
		StringBuilder sb2 = new StringBuilder();
		sb2.append("\\    /\\\n");
		sb2.append(" )  ( ')\n");
		sb2.append("(   / )\n");
		sb2.append(" \\(__)|\n");
		// StringBuilder는 개행해주는 메소드X => "\n"으로 개행 필요

		System.out.println(sb2);
		
		// StringBuffer
		StringBuffer sb = new StringBuffer();
		sb.append("\\    /\\\n");
		sb.append(" )  ( ')\n");
		sb.append("(   / )\n");
		sb.append(" \\(__)|\n");
		// StringBuffer는 개행해주는 메소드X => "\n"으로 개행 필요
		
		System.out.println(sb);
		
	}

}
