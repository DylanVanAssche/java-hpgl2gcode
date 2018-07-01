package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import controller.Controller;
import model.Configuration;
import model.GCodeWriter;
import model.HPGLReader;
import model.Job;
import view.SelectFileList;

public class Processor {
	
	public static void convert(Controller controller) throws IOException, InterruptedException {
		ArrayList<Job> jobs = new ArrayList<Job>();
		SelectFileList pickers = controller.getView().getPickers();
		
		// Start reading all files for each job
		System.out.println("Querrying " + pickers.getFilePaths().size() +  " files for reading");
		ArrayList<HPGLReader> readerList = new ArrayList<HPGLReader>();
		for(int i=0; i<pickers.getFilePaths().size(); i++) {
			System.out.println("Reading file:" + pickers.getFilePaths().get(i));
			int configurationIndex = controller.getView().getPickers().getFilePaths().get(i).getFileType().getSelectedIndex();
			Configuration configuration = controller.getView().getConfiguration().generate(configurationIndex);
			jobs.add(i, new Job(configuration));
			FileReader fileIn = new FileReader(pickers.getFilePaths().get(i).getAbsoluteFilePath());
			HPGLReader reader = new HPGLReader(fileIn, jobs.get(i));
			reader.start();
			readerList.add(reader);
		}
		
		// Join all readers
		for(int i=0; i<readerList.size(); i++) {
			HPGLReader reader = readerList.get(i);
			reader.join();
		}
		System.out.println("All files reads! Processing now...");
				
		// Write all jobs to GCode files
		for(int i=0; i<pickers.getFilePaths().size(); i++) {
			int configurationIndex = controller.getView().getPickers().getFilePaths().get(i).getFileType().getSelectedIndex();
			Configuration configuration = controller.getView().getConfiguration().generate(configurationIndex);
			jobs.add(i, new Job(configuration));
			FileWriter fileOut = new FileWriter(pickers.getFilePaths().get(i).getAbsoluteFilePath() + ".gcode");
			GCodeWriter writer = new GCodeWriter(fileOut, jobs.get(i));
			writer.start();
		}
		System.out.println("Converting HPGL files to GCode files completed!");
	}
}
