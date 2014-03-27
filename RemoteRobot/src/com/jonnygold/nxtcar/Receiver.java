package com.jonnygold.nxtcar;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import lejos.nxt.Sound;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;


public class Receiver {

	private NXTConnection connection;
	
	protected DataInputStream inStream;
	
	private boolean isConnected;
	
	/**
	 * Waits for a connection establishing with a controller.
	 * It doesn't return until receiver is not connected with a controller.
	 */
	protected void connect(){
		System.out.println("Listening...");
		connection = Bluetooth.waitForConnection(90000, 0, null);
		connection.setIOMode(NXTConnection.RAW);
//		inStream = new BufferedInputStream(connection.openDataInputStream(), 1);
		inStream = connection.openDataInputStream();
		isConnected = true;
		Sound.beep();
		System.out.println("Connected.");
	}
	
	protected void disconnect(){
		if(isConnected){
			System.out.println("Disconnecting...");
			try{inStream.close();}catch(Exception exc){}
			connection.close();
			isConnected = false;
			System.out.println("Connection closed.");
		}
	}
	
	protected boolean isConnected(){
		return isConnected;
	}
	
	protected int getData(){
		int code;
		try {
//			System.out.println("Available: "+inStream.available());
//			code = inStream.read();
			code = inStream.read();
			
//			System.out.println("Read!!!!!!!!");
		} catch (IOException e) {
			System.out.println("Reading exception!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			code = -1;
		}
		return code;
	}
	
//	protected int getData(){
//		int code;
//		byte[] b = new byte[1];
//		try {
////			System.out.println("Available: "+inStream.available());
////			code = inStream.read();
//			
//			inStream.read(b);
//			code = b[0];
//			
////			System.out.println("Read!!!!!!!!");
//		} catch (IOException e) {
//			System.out.println("Reading exception!");
//			code = -1;
//		}
//		return code;
//	}

}
