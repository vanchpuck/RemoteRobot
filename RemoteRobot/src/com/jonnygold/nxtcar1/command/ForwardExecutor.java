package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.Engine;
import com.jonnygold.nxtcar.RemoteRobot;

public class ForwardExecutor implements Executable {

	@Override
	public void execute(RemoteRobot robot) {
		robot.getEngine().setDirection(Engine.Direction.FORWARD);
	}

}
