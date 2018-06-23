package model.commands;

import model.Configuration;

public class ToolMove extends Command {
	private Configuration configuration;

	public ToolMove(String HPGLCode) {
		super(HPGLCode);
	}
	
	public ToolMove(String HPGLCode, Configuration configuration) {
		super(HPGLCode);
		this.setConfiguration(configuration);
	}

	@Override
	public String getGCodeString() throws IllegalStateException, IllegalArgumentException {
		if(this.getConfiguration().getMovementXYSpeed() > 0 && this.getConfiguration().getMovementZSpeed() > 0) {
			String command = Command.parseCommand(this.getHPGLCode());
			String[] parameters = Command.parseParameters(this.getHPGLCode());
			String gcode;
			double movementX;
			double movementY;
			double movementZ;
			
			switch(command) {
			case "PA":
				if(parameters.length == 2 && this.getConfiguration().getUnitsPerMillimetre() > 0.0) {
					movementX = Integer.parseInt(parameters[0]) / this.getConfiguration().getUnitsPerMillimetre(); // HPGL units per millimetre config
					movementY = Integer.parseInt(parameters[1]) / this.getConfiguration().getUnitsPerMillimetre();
					gcode = "G1 X" + movementX + " Y" + movementY + " F" + this.getConfiguration().getMovementXYSpeed();
					return gcode;
				}
				else {
					throw new IllegalArgumentException("Invalid movement 'PAx,y;' command, X and Y coordinates must be given and HPGL Units Per Milimetre must be > 0");
				}
			case "PU":
				movementZ = this.getConfiguration().getSafetyHeight();
				gcode = "G1 Z" + movementZ +  " F" + this.getConfiguration().getMovementZSpeed();
				return gcode;
			case "PD":
				movementZ = this.getConfiguration().getCuttingHeight();
				gcode = "G1 Z" + movementZ +  " F" + this.getConfiguration().getMovementZSpeed();
				return gcode;
			default:
				throw new IllegalArgumentException("Invalid or unknown movement command");
			}
		}
		else {
			throw new IllegalStateException("Movement speed XY and Z must be > 0");
		}
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	public String toString() {
		return "ToolMove(" + this.getId() + ")";
	}
}
