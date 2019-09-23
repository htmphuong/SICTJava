package AllFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class CopyFileContent {

	//tao file
	public void CreateFile(String path, String name) {
		try {
			File f = new File(path+"\\"+name);
			if(f.createNewFile()==true) JOptionPane.showConfirmDialog(null, "File created");
			else JOptionPane.showConfirmDialog(null, "Errors");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		FileOutputStream fos=null;
		String path="D:\\Minh Phuong";
		String name = "baitap.txt";
		
		try {
			//doc file
			fis = new FileInputStream("D:\\Minh Phuong\\hello.txt");
			fos = new FileOutputStream(path+"\\"+name);
			int data;
			data = fis.read();
			while(data!=-1)
			{
				System.out.print((char)data);
				data =fis.read();
				fos.write(data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally {
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Loi doc file");
			}
		}
	}

}
