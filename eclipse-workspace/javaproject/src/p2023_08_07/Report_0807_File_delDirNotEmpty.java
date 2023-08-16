package p2023_08_07;

import java.io.File;

/*
	File클래스를 이용하여 비어있지 않은 디렉토리 삭제
	
	C드라이브의 test폴더에 파일들이 들어있는 경우에, test폴더를 삭제하는 프로그램 작성
 */
public class Report_0807_File_delDirNotEmpty {
	
	// 재귀함수 - 비어있지 않더라도 디렉토리와 그 안에있는 파일 및 하위 디렉토리를 삭제
	static void deleteDirNotEmpty(File file) {
		// 디렉토리인 경우
		// File[] listFiles(): 디렉토리에 포함된 파일과 디렉토리의 File 객체 배열을 반환
		//  					전체 경로를 포함하는 File 객체 배열을 반환
		File[] files = file.listFiles();
		if(files != null) {
			for (File filepath : files) {
				// 디렉토리 내의 파일과 하위 디렉토리를 모두 삭제
				// 디렉토리인 경우
				if (filepath.isDirectory()) {
					deleteDirNotEmpty(filepath);
				} else {
					// 파일인 경우
					filepath.delete();
				}
			}
		}
		// 비어있는 디렉토리가 된 경우
		file.delete();
		System.out.println(file.getName()+" file delected~!");
	}
	
	// 주어진 디렉토리 내의 모든 파일을 삭제
	static void UseListFilesNDel(File file) {
		// Test디렉토리 안에 있는 모든 파일 구해오기(디렉토리 내의 파일과 디렉토리를 배열로 가져옴)
		File[] fileObj = file.listFiles();
		for (int i=0; i < fileObj.length; i++) {
			// Test디렉토리 안에 있는 모든 파일 삭제
			fileObj[i].delete();
			System.out.println(fileObj[i].getName()+" file deleted~!");
		}
		// 비어있는 디렉토리가 되었기에, 삭제
		file.delete();
		System.out.println(file.getName()+" file deleted~!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// 파일/디렉토리 경로를 이용하여 File클래스 객체 생성
			// 현재 작업 디렉토리에서 newTest라는 이름의 파일을 나타내는 File객체 생성
			File file = new File("c:/Test");
			File file2 = new File("c:/Test", "testDir");
			
			// boolean mkdir(): 새로운 디렉토리를 생성
			//   디렉토리가 이미 존재하는 경우, 생성하지 않고 false를 반환
			System.out.println("create directory state : "+file.mkdir());
			System.out.println("create directory state : "+file2.mkdirs());
			
			// 비어있지 않은 디렉토리 삭제
			deleteDirNotEmpty(file);
			
		}catch(Exception err) {
			err.printStackTrace();
		}

	}

}
