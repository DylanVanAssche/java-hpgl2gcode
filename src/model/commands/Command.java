package model.commands;

import java.util.Random;

public abstract class Command {
	private int id;
	private String HPGLCode;
	
	protected Command(String HPGLCode) {
		this.generateId();
		this.setHPGLCode(HPGLCode);
	}
	
	public int getId() {
		return id;
	}
	
	protected void generateId() {
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis()); // seed on the current time for a better randomisation
		this.id = generator.nextInt(Integer.SIZE - 1); // only positive numbers
	}
	
	public String getHPGLCode() {
		return this.HPGLCode;
	}
	
	protected void setHPGLCode(String HPGLCode) {
		this.HPGLCode = HPGLCode;
	}
	
	public static String parseCommand(String code) {
		return code.substring(0, 2); // Retrieve the command as String
	}
	
	public static String[] parseParameters(String code) {
		return code.substring(2, code.length()-1).split(","); // Retrieve the parameters as String[]
	}
	
	public abstract String getGCodeString();
}
