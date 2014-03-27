package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.RemoteRobot;

public class LeftExecutor implements Executable {
	
	@Override
	public void execute(RemoteRobot robot) {
		robot.getWheel().turnLeft();
	}

}
