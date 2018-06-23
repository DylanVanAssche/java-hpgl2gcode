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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.commands.Command;

public class HPGLReader extends Thread {
	private BufferedReader input;
	private Job job;
	
	public HPGLReader(FileReader input, Job job) {
		super();
		this.setInput(new BufferedReader(input));
		this.setJob(job);
	}
	
	public BufferedReader getInput() {
		return input;
	}

	public void setInput(BufferedReader input) {
		this.input = input;
	}
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void run() {
		while(true) {
			try {
				synchronized(this.getJob()) {
					String line = this.getInput().readLine();
					if(line != null) {
						
							Command command = CommandFactory.newInstance().parseHPGLCode(line, this.getJob().getConfiguration());
							this.getJob().getCommands().add(command);
							this.getJob().notify();
					}
					else {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		
		System.out.println(this.getJob().getCommands());
	}

}
