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

public class ToolSelect extends Command {
	
	public ToolSelect(String HPGLCode) {
		super(HPGLCode);
	}

	@Override
	public String getGCodeString() throws IllegalStateException {
		// http://linuxcnc.org/docs/html/gcode/m-code.html#mcode:m6
		String[] parameters = Command.parseParameters(this.getHPGLCode());
		if(Integer.parseInt(parameters[0]) > 0) {
			String gcode = "M6 T" + parameters[0];
			return gcode;
		}
		else {
			throw new IllegalStateException("Tool number must be > 0");
		}
	}
	
	@Override
	public String toString() {
		return "ToolSelect(" + this.getId() + ")";
	}

}
