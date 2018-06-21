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

public class Configuration {
	private int spindleSpeed;
	private double spindlePowerUpTime;
	private int movementXYSpeed;
	private int movementZSpeed;
	private double unitsPerMillimetre;
	private double safetyHeight;
	private double cuttingHeight;
	
	public Configuration(int spindleSpeed, double spindlePowerUpTime, double cuttingHeight, int movementXYSpeed, int movementZSpeed, double unitsPerMillimetre, double safetyHeight) {
		this.setSpindleSpeed(spindleSpeed);
		this.setSpindlePowerUpTime(spindlePowerUpTime);
		this.setCuttingHeight(cuttingHeight);
		this.setMovementXYSpeed(movementXYSpeed);
		this.setMovementZSpeed(movementZSpeed);
		this.setUnitsPerMillimetre(unitsPerMillimetre);
		this.setSafetyHeight(safetyHeight);
	}
	
	public int getSpindleSpeed() {
		return spindleSpeed;
	}
	
	public void setSpindleSpeed(int spindleSpeed) {
		this.spindleSpeed = spindleSpeed;
	}
	
	public double getSpindlePowerUpTime() {
		return spindlePowerUpTime;
	}
	
	public void setSpindlePowerUpTime(double spindlePowerUpTime) {
		this.spindlePowerUpTime = spindlePowerUpTime;
	}

	public int getMovementXYSpeed() {
		return movementXYSpeed;
	}

	public void setMovementXYSpeed(int movementXYSpeed) {
		this.movementXYSpeed = movementXYSpeed;
	}

	public int getMovementZSpeed() {
		return movementZSpeed;
	}

	public void setMovementZSpeed(int movementZSpeed) {
		this.movementZSpeed = movementZSpeed;
	}

	public double getUnitsPerMillimetre() {
		return unitsPerMillimetre;
	}

	public void setUnitsPerMillimetre(double unitsPerMillimetre) {
		this.unitsPerMillimetre = unitsPerMillimetre;
	}

	public double getSafetyHeight() {
		return safetyHeight;
	}

	public void setSafetyHeight(double safetyHeight) {
		this.safetyHeight = safetyHeight;
	}

	public double getCuttingHeight() {
		return cuttingHeight;
	}

	public void setCuttingHeight(double cuttingHeight) {
		this.cuttingHeight = cuttingHeight;
	}
}
