package model;

import java.util.Random;

public abstract class Command {
	private int id;
	private String HPGLCode;
	
	public int getId() {
		return id;
	}
	
	protected void generateId() {
		Random generator = new Random();
		this.id = generator.nextInt();
	}
	
	public String getHPGLCode() {
		return this.HPGLCode;
	}
	
	protected void setHPGLCode(String HPGLCode) {
		this.HPGLCode = HPGLCode;
	}
	
	public abstract String getGCodeString();
}
