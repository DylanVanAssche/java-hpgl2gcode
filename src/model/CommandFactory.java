/*
*   This file is part of java-hpgl2gcode.
*
*   java-hpgl2gcode is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   java-hpgl2gcode is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with java-hpgl2gcode.  If not, see <http://www.gnu.org/licenses/>.
*/

package model;

import model.commands.*;

public class CommandFactory {
	private static CommandFactory factory;
	private static final String COMMAND_REGEX = "[A-Z][A-Z]";
	
	private CommandFactory() {
		System.out.println("CommandFactory created");
	}
	
	public static CommandFactory newInstance() {
		if(factory == null) {
			factory = new CommandFactory();
		}
		return factory;
	}
	
	public Command parseHPGLCode(String code, Configuration configuration) {
		// Enforce uppercase
		code = code.toUpperCase();
		
		// Check if command properly ends	
		if(code.endsWith(";")) {
			String command = Command.parseCommand(code); // HPGL is based on 2 char commands strings
			// Generate a command object based on the HPGL command characters
			switch(command) {
			case "SP": // Select Pen
				return new ToolSelect(code);
			case "IN": // Init phase
				return new ToolInit(code, configuration);
			case "PA": // Movement is only supported in Position Absolute mode
				return new ToolMove(code, configuration);
			case "PU": // Pen Up
				return new ToolMove(code, configuration);
			case "PD": // Pen Down
				return new ToolMove(code, configuration);
			case "PT": // Pen Thickness
				return new ToolSize(code);
			default: // Unknown command
				System.err.println("HPGL command not supported yet: " + code);
				return ToolNull.newInstance();
			}
		}
		else {
			System.err.println("';' expected at the end of a HPGL command");
			return ToolNull.newInstance();
		}
	}
	
}
