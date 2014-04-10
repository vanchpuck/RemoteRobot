package com.jonnygold.nxtcar;

import lejos.nxt.Motor;

public class Engine {

	public static enum Direction{
		FORWARD {public void move(){Motor.A.backward();}},
		BACKWARD {public void move(){Motor.A.forward();}};
		
		public abstract void move();
	}
	
	private static class Accelerator extends Thread{
		
		private final static int MAX_SPEED = 800;
		
		@Override
		public void run() {
			Motor.A.backward();
			while(!isInterrupted()){
				
				int speed = Motor.A.getSpeed();
				if(speed <= MAX_SPEED){
					System.out.println("accelerate: "+speed);
					Motor.A.setSpeed(300);
				}
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					return;
//				}
			}
		}
	}
	
	private static class Decelerator extends Thread{
		
		private final static int MIN_SPEED = 0;
		
		@Override
		public void run() {
			while(!isInterrupted()){
				
				int speed = Motor.A.getSpeed()-10;
				if(speed < MIN_SPEED){
					speed = MIN_SPEED;
				}
				System.out.println("decelerate: "+speed);
				Motor.A.setSpeed(speed);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	
	
//	private Thread action;
	
	private Direction direction;
	
	public Engine(){
		direction = Direction.FORWARD;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void setDirection(Direction direction){
		this.direction = direction;
	}
	
	public void accelerate(){
		System.out.println("accelerate: "+Motor.A.getMaxSpeed());
		Motor.A.setAcceleration(200);
		Motor.A.setSpeed(800);
		getDirection().move();
//		Motor.A.setSpeed(600);
//		if(action != null)
//			action.interrupt();
//		
//		action = new Accelerator();
//		action.start();
	}
	
	public void decelerate(){
		Motor.A.setAcceleration(100);
		Motor.A.flt(true);
		System.out.println("decelerate: ");
		
//		Motor.A.setSpeed(200);
//		if(action != null)
//			action.interrupt();
//		
//		action = new Decelerator();
//		action.start();
	}
	
	public void stop(){
		Motor.A.setAcceleration(800);
		Motor.A.flt(true);
		System.out.println("stop: ");
	}
	
}
