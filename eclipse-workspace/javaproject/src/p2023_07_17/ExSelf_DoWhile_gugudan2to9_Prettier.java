package p2023_07_17;

public class ExSelf_DoWhile_gugudan2to9_Prettier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Dan, i, dan;
		do {
			for (Dan=2; Dan<10; Dan++) {
				System.out.print("["+Dan+"단]\t");
			}
			System.out.println();
			
			for (i=1; i<10; i++) {
				for (dan=2; dan<10; dan++) {
					System.out.print(dan+"*"+i+"= "+(dan*i)+"\t");
				}
				System.out.println();
			}
		} while (Dan<10 && i<10);
		
		
	}

}
