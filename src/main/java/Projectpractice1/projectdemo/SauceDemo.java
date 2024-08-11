package Projectpractice1.projectdemo;

public class SauceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FolderCreate.folderCreate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			ExcelSheetCode.excelSheetCode();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
