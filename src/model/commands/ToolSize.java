package model.commands;

import model.Configuration;

public class ToolSize extends Command {
	private Configuration configuration;

	public ToolSize(String HPGLCode) {
		super(HPGLCode);
	}

	@Override
	public String getGCodeString() {
		String gcode = ""; // ABACOM generates a pen thickness (PT) command but it's unused
		return gcode;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}
