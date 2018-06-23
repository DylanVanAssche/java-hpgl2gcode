package model;

import java.util.ArrayList;

import model.commands.Command;

public class Job {
	private ArrayList<Command> commands = new ArrayList<Command>();
	private Configuration configuration;
	
	public Job(Configuration configuration) {
		this.setConfiguration(configuration);
	}
	
	public ArrayList<Command> getCommands() {
		return commands;
	}
	
	public void setCommands(ArrayList<Command> commands) {
		this.commands = commands;
	}
	
	public Configuration getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}	
}
