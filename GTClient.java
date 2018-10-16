package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class GTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// tao ra socetket noi giao UDP can tao cong khc
			DatagramSocket skClient = new DatagramSocket();
			System.out.println("Sender...");
			//dong goi packet
			String n;
			Scanner key = new Scanner(System.in);
			System.out.println("Nhap 1 so=");
			n = key.nextLine();
			
			byte[] so = n.getBytes();
			int len = so.length;
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket packetGui = new DatagramPacket(so, len, address, 7000);
			skClient.send(packetGui);
			
			//tao khuon nhan du mlieu
			byte[] tich = new byte[1024];
			int dai =tich.length;
			DatagramPacket packetNhan = new DatagramPacket(tich, dai);
			skClient.receive(packetNhan);
			byte[] gt =packetNhan.getData();
			String kq = new String(gt,gt.length);
			System.out.println("Giai thua la "+kq);
			skClient.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
