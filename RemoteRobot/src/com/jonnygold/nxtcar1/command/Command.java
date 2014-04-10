package com.jonnygold.nxtcar1.command;

import com.jonnygold.nxtcar.RemoteRobot;

public enum Command {	
	DISCONNECT	(50, new DisconnectExecutor()),	
	LEFT		(10, new LeftExecutor()),
	RIGHT		(11, new RightExecutor()),
	DIRECT		(12, new DirectExecutor()),
	LEFT_MAX	(13, new LeftMaxExecutor()),
	RIGHT_MAX	(14, new RightMaxExecutor()),
	LEFT_MIDDLE	(15, new LeftMiddleExecurot()),
	RIGHT_MIDDLE(16, new RightMiddleExecurot()),
	BRAKE 		(30, new BrakeExecutor()),
	ACCELERATOR_PRESSED 	(20, new AccelerateExecutor()),
	ACCELERATOR_RELEASED 	(21, new DecelerateExecutor()),
	CHANGE_DIRECTION		(40, new RedirectExecutor()),
	FORWARD		(41, new ForwardExecutor()),
	BACKWARD	(42, new BackwardExecutor()),
	NOTHING		(255, new NothingExecutor());
	
	private int code;
	private Executable executor;
	
	private Command(int code, Executable executor){
		this.code = code;
		this.executor = executor;
	}
	
	public int getCode(){
		return code;
	}
	
	public void execute(RemoteRobot robot){
		executor.execute(robot);
	}
	
}
