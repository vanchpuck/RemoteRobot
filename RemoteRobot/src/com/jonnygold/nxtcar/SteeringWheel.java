package com.jonnygold.nxtcar;

import lejos.nxt.Motor;

public class SteeringWheel {

	private static final int LEFT_DEGREE = -25;
	private static final int RIGHT_DEGREE = 25;
	private static final int DIRECT_DEGREE = 0;
	
	public void turnLeft(){
		Motor.B.rotateTo(LEFT_DEGREE, true);
	}
	
	public void turnRight(){
		Motor.B.rotateTo(RIGHT_DEGREE, true);
	}
	
	public void goStraight(){
		Motor.B.rotateTo(DIRECT_DEGREE, true);
	}
}
