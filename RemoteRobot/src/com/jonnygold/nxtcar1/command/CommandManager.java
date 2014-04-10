package com.jonnygold.nxtcar1.command;

import java.util.Hashtable;

public class CommandManager {
	
	private static CommandManager manager;
	
	private Hashtable<Integer, Command> commands;
	
	private CommandManager(){
		initCommands();
	}
	
	public static CommandManager getInstance(){
		if(manager == null){
			manager = new CommandManager();
		}
		return manager;
	}
		
	public Command getCommand(int code){
		return commands.get(code);
	}

	private void initCommands(){
		commands = new Hashtable<Integer, Command>();
		for(Command com : Command.values()){
			commands.put(com.getCode(), com);
		}
	}
	
}
