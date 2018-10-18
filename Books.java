package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Books {
	String maSach;
	String tenSach;
	int sl;
	String namXB;
	
	
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public String getNamXB() {
		return namXB;
	}
	public void setNamXB(String namXB) {
		this.namXB = namXB;
	}
	public Books() {
		
	}
	public Books(String maSach,String tenSach,int sl,String namXB) {
		this.maSach=maSach;
		this.tenSach=tenSach;
		this.sl=sl;
		this.namXB=namXB;
	}
	
		
}
