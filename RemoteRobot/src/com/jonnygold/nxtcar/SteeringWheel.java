package com.jonnygold.nxtcar;

import lejos.nxt.Motor;

public class SteeringWheel {

	private static final int LEFT_DEGREE = -10;
	private static final int RIGHT_DEGREE = 10;
	private static final int LEFT_MIDDLE_DEGREE = -17;
	private static final int RIGHT_MIDDLE_DEGREE = 17;
	private static final int LEFT_MAX_DEGREE = -25;
	private static final int RIGHT_MAX_DEGREE = 25;
	private static final int DIRECT_DEGREE = 0;
	
	public void turnLeft(){
		Motor.B.rotateTo(LEFT_DEGREE, true);
	}
	
	public void turnLeftMiddle(){
		Motor.B.rotateTo(LEFT_MIDDLE_DEGREE, true);
	}
	
	public void turnLeftMax(){
		Motor.B.rotateTo(LEFT_MAX_DEGREE, true);
	}
	
	public void turnRight(){
		Motor.B.rotateTo(RIGHT_DEGREE, true);
	}
	
	public void turnRightMiddle(){
		Motor.B.rotateTo(RIGHT_MIDDLE_DEGREE, true);
	}
	
	public void turnRightMax(){
		Motor.B.rotateTo(RIGHT_MAX_DEGREE, true);
	}
	
	public void goStraight(){
		Motor.B.rotateTo(DIRECT_DEGREE, true);
	}
}
