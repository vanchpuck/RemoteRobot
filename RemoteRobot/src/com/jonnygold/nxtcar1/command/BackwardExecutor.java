package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.Engine;
import com.jonnygold.nxtcar.RemoteRobot;

public class BackwardExecutor implements Executable {

	@Override
	public void execute(RemoteRobot robot) {
		robot.getEngine().setDirection(Engine.Direction.BACKWARD);
	}

}
