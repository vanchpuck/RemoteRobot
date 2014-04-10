package com.jonnygold.nxtcar;

import lejos.nxt.Motor;

public class Transmission {

	public void forward(){
		Motor.A.backward();
	}
	
	public void bacward(){
		Motor.A.forward();
	}
	
}
