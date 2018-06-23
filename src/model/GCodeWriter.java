package model;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GCodeWriter extends Thread {
	private PrintWriter output;
	private Job job;

	public GCodeWriter(FileWriter output, Job job) {
		super();
		this.setOutput(new PrintWriter(output));
		this.setJob(job);
	}
	
	public PrintWriter getOutput() {
		return output;
	}

	public void setOutput(PrintWriter output) {
		this.output = output;
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void run() {
		synchronized(this.getJob()) {
			for(int i=0; i < this.getJob().getCommands().size(); i++) {
				String gcode = this.getJob().getCommands().get(i).getGCodeString();
				this.getOutput().println(gcode);
			}
			this.getOutput().flush();
			this.getOutput().close();
			this.getJob().notify();
		}
		System.out.println("File written");
	}
	
}
