package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.RemoteRobot;

class DisconnectExecutor implements Executable {

	@Override
	public void execute(RemoteRobot robot) {
		robot.disconnect();
	}
	
}
