package com.jonnygold.nxtcar;

import com.jonnygold.nxtcar1.command.Command;
import com.jonnygold.nxtcar1.command.CommandManager;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;


public class RemoteRobot {

	private Receiver receiver;
	
	private CommandManager commandManager;
	
	private SteeringWheel wheel;
	
	private Engine engine;
	
	private Transmission transmission;
	
	public RemoteRobot(){
		receiver = new Receiver();
		
		commandManager = CommandManager.getInstance();
		
		wheel = new SteeringWheel();
		engine = new Engine();
		transmission = new Transmission();
//		transmission.forward();
				
		Button.ESCAPE.addButtonListener(new ButtonListener() {			
			@Override
			public void buttonReleased(Button b) {
				receiver.disconnect();
				System.exit(0);
			}			
			@Override
			public void buttonPressed(Button b) {}
		});
	}
	
	/**
	 * Waits for establishing of the connection  with a controller.
	 * It doesn't return until robot is not connected.
	 */
	public void connect(){
		receiver.connect();
	}
	
	public void disconnect(){
		receiver.disconnect();
	}
	
	protected void performCommands(){
		Command command = null;
		while(receiver.isConnected()){
			int code = receiver.getData();
			
			command = commandManager.getCommand(code);
			command.execute(this);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public SteeringWheel getWheel(){
		return wheel;
	}
	
	public Engine getEngine(){
		return engine;
	}
	
	public Transmission getTransmission(){
		return transmission;
	}
		
	public static void main(String[] args) {
		RemoteRobot remoteRobot = new RemoteRobot();
		remoteRobot.connect();
		remoteRobot.performCommands();
	}

}
