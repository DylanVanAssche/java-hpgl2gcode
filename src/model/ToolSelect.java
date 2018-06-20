package model;

public class ToolSelect extends Command {
	
	public ToolSelect(String HPGLCode) {
		this.generateId();
		this.setHPGLCode(HPGLCode);
	}

	@Override
	public String getGCodeString() {
		return "GCODE, ID=" + this.getId();
	}

}
