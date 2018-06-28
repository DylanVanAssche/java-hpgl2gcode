package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Configuration;

public class ConfigurationView extends JPanel {
	private static final int NUMBER_OF_COLUMS = 2;
	public static final int ENGRAVING = 0;
	public static final int DRILLING = 1;
	public static final int MILLING = 2;
	private Controller controller;
	private JComponentLabel engravingSpindleSpeed;
	private JComponentLabel drillingSpindleSpeed;
	private JComponentLabel millingSpindleSpeed;
	private JComponentLabel engravingDepth;
	private JComponentLabel drillingDepth;
	private JComponentLabel millingDepth;
	private JComponentLabel engravingFeedrate;
	private JComponentLabel drillingFeedrate;
	private JComponentLabel millingFeedrate;
	private JComponentLabel safetyHeight;
	private JComponentLabel spindleSpeedupTime;
	private JComponentLabel mergeJobs;
	
	public ConfigurationView(Controller controller) {
		this.setController(controller);
		this.setEngravingSpindleSpeed(new JComponentLabel("Engraving spindle speed (RPM)", new JTextField()));
		this.setDrillingSpindleSpeed(new JComponentLabel("Drilling spindle speed (RPM)", new JTextField()));
		this.setMillingSpindleSpeed(new JComponentLabel("Milling spindle speed (RPM)", new JTextField()));
		this.setEngravingDepth(new JComponentLabel("Engraving depth (mm)", new JTextField()));
		this.setDrillingDepth(new JComponentLabel("Drilling depth (mm)", new JTextField()));
		this.setMillingDepth(new JComponentLabel("Milling depth (mm)", new JTextField()));
		this.setEngravingFeedrate(new JComponentLabel("Engraving feedrate (mm/s)", new JTextField()));
		this.setDrillingFeedrate(new JComponentLabel("Drilling feedrate (mm/s)", new JTextField()));
		this.setMillingFeedrate(new JComponentLabel("Milling feedrate (mm/s)", new JTextField()));
		this.setSafetyHeight(new JComponentLabel("Safety height (mm)", new JTextField()));
		this.setSpindleSpeedupTime(new JComponentLabel("Spindle speedup time (s)", new JTextField()));
		this.setMergeJobs(new JComponentLabel("Merge jobs", new JCheckBox()));
		
		JPanel engravingPanel = new JBorderPanel("Engraving");
		engravingPanel.add(this.getEngravingSpindleSpeed());
		engravingPanel.add(this.getEngravingDepth());
		engravingPanel.add(this.getEngravingFeedrate());
		
		JPanel drillingPanel = new JBorderPanel("Drilling");
		drillingPanel.add(this.getDrillingSpindleSpeed());
		drillingPanel.add(this.getDrillingDepth());
		drillingPanel.add(this.getDrillingFeedrate());
		
		JPanel millingPanel = new JBorderPanel("Milling");
		millingPanel.add(this.getMillingSpindleSpeed());
		millingPanel.add(this.getMillingDepth());
		millingPanel.add(this.getMillingFeedrate());
		
		JPanel generalPanel = new JBorderPanel("General");
		generalPanel.add(this.getSafetyHeight());
		generalPanel.add(this.getSpindleSpeedupTime());
		generalPanel.add(this.getMergeJobs());
		
		this.add(engravingPanel);
		this.add(drillingPanel);
		this.add(millingPanel);
		this.add(generalPanel);
		this.setLayout(new GridLayout(0, NUMBER_OF_COLUMS));
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JComponentLabel getEngravingSpindleSpeed() {
		return engravingSpindleSpeed;
	}

	public void setEngravingSpindleSpeed(JComponentLabel engravingSpindleSpeed) {
		this.engravingSpindleSpeed = engravingSpindleSpeed;
	}

	public JComponentLabel getDrillingSpindleSpeed() {
		return drillingSpindleSpeed;
	}

	public void setDrillingSpindleSpeed(JComponentLabel drillingSpindleSpeed) {
		this.drillingSpindleSpeed = drillingSpindleSpeed;
	}

	public JComponentLabel getMillingSpindleSpeed() {
		return millingSpindleSpeed;
	}

	public void setMillingSpindleSpeed(JComponentLabel millingSpindleSpeed) {
		this.millingSpindleSpeed = millingSpindleSpeed;
	}

	public JComponentLabel getEngravingDepth() {
		return engravingDepth;
	}

	public void setEngravingDepth(JComponentLabel engravingDepth) {
		this.engravingDepth = engravingDepth;
	}

	public JComponentLabel getDrillingDepth() {
		return drillingDepth;
	}

	public void setDrillingDepth(JComponentLabel drillingDepth) {
		this.drillingDepth = drillingDepth;
	}

	public JComponentLabel getMillingDepth() {
		return millingDepth;
	}

	public void setMillingDepth(JComponentLabel millingDepth) {
		this.millingDepth = millingDepth;
	}

	public JComponentLabel getEngravingFeedrate() {
		return engravingFeedrate;
	}

	public void setEngravingFeedrate(JComponentLabel engravingFeedrate) {
		this.engravingFeedrate = engravingFeedrate;
	}

	public JComponentLabel getDrillingFeedrate() {
		return drillingFeedrate;
	}

	public void setDrillingFeedrate(JComponentLabel drillingFeedrate) {
		this.drillingFeedrate = drillingFeedrate;
	}

	public JComponentLabel getMillingFeedrate() {
		return millingFeedrate;
	}

	public void setMillingFeedrate(JComponentLabel millingFeedrate) {
		this.millingFeedrate = millingFeedrate;
	}

	public JComponentLabel getSafetyHeight() {
		return safetyHeight;
	}

	public void setSafetyHeight(JComponentLabel safetyHeight) {
		this.safetyHeight = safetyHeight;
	}

	public JComponentLabel getSpindleSpeedupTime() {
		return spindleSpeedupTime;
	}

	public void setSpindleSpeedupTime(JComponentLabel spindleSpeedupTime) {
		this.spindleSpeedupTime = spindleSpeedupTime;
	}

	public JComponentLabel getMergeJobs() {
		return mergeJobs;
	}

	public void setMergeJobs(JComponentLabel mergeJobs) {
		this.mergeJobs = mergeJobs;
	}

	public Configuration generate(int type) {
		switch(type) {
		case ENGRAVING:
			break;
		case DRILLING:
			break;
		case MILLING:
			break;
		default:
			System.err.println("Unknown configuration type");
		}
		// read stuff
		return new Configuration(20000, 10.0, -0.165, 500, 300, 40.0, 3.0);
	}
}
