package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.RemoteRobot;

public class RightMaxExecutor implements Executable {

	@Override
	public void execute(RemoteRobot robot) {
		robot.getWheel().turnRightMax();
	}

}
