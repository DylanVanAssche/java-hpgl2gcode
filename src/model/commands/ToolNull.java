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

package model.commands;

public class ToolNull extends Command {
	private static ToolNull toolNull;
	
	private ToolNull() {
		super("");
	}
	
	// Singleton pattern, only 1 instance may exist! Use .newInstance() to retrieve a ToolNull instance
	public static ToolNull newInstance() {
		if(toolNull == null) {
			toolNull = new ToolNull();
		}
		return toolNull;
	}

	@Override
	public String getGCodeString() {
		// http://linuxcnc.org/docs/html/gcode/overview.html#gcode:messages
		String gcode = "(MSG, Unsupported or invalid command)";
		return gcode;
	}

	@Override
	public String toString() {
		return "ToolNull(" + this.getId() + ")";
	}
	
}
