package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.RemoteRobot;

public class RedirectExecutor implements Executable{

	@Override
	public void execute(RemoteRobot robot) {
		System.out.println("Redirect");
	}
	
}
