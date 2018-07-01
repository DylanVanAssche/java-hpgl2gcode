package view;

import java.awt.GridLayout;
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
	private JComponentLabel engravingFeedrateXY;
	private JComponentLabel drillingFeedrateXY;
	private JComponentLabel millingFeedrateXY;
	private JComponentLabel engravingFeedrateZ;
	private JComponentLabel drillingFeedrateZ;
	private JComponentLabel millingFeedrateZ;
	private JComponentLabel safetyHeight;
	private JComponentLabel spindleSpeedupTime;
	private JComponentLabel unitsPerMillimetre;
	
	public ConfigurationView(Controller controller) {
		this.setController(controller);
		this.setEngravingSpindleSpeed(new JComponentLabel("Engraving spindle speed (RPM)", new JTextField("23000")));
		this.setDrillingSpindleSpeed(new JComponentLabel("Drilling spindle speed (RPM)", new JTextField("23000")));
		this.setMillingSpindleSpeed(new JComponentLabel("Milling spindle speed (RPM)", new JTextField("15000")));
		this.setEngravingDepth(new JComponentLabel("Engraving depth (mm)", new JTextField("-0.165")));
		this.setDrillingDepth(new JComponentLabel("Drilling depth (mm)", new JTextField("-1.6")));
		this.setMillingDepth(new JComponentLabel("Milling depth (mm)", new JTextField("-1.6")));
		this.setEngravingFeedrateXY(new JComponentLabel("Engraving feedrate XY(mm/s)", new JTextField("500")));
		this.setDrillingFeedrateXY(new JComponentLabel("Drilling feedrate XY (mm/s)", new JTextField("500")));
		this.setMillingFeedrateXY(new JComponentLabel("Milling feedrate XY (mm/s)", new JTextField("100")));
		this.setEngravingFeedrateZ(new JComponentLabel("Engraving feedrate Z(mm/s)", new JTextField("300")));
		this.setDrillingFeedrateZ(new JComponentLabel("Drilling feedrate Z (mm/s)", new JTextField("300")));
		this.setMillingFeedrateZ(new JComponentLabel("Milling feedrate Z (mm/s)", new JTextField("100")));
		this.setSafetyHeight(new JComponentLabel("Safety height (mm)", new JTextField("3.0")));
		this.setSpindleSpeedupTime(new JComponentLabel("Spindle speedup time (s)", new JTextField("10.0")));
		this.setUnitsPerMillimetre(new JComponentLabel("HPGL Units Per Millimetre (units/mm)", new JTextField("40.3")));
		
		JPanel engravingPanel = new JBorderPanel("Engraving");
		engravingPanel.add(this.getEngravingSpindleSpeed());
		engravingPanel.add(this.getEngravingDepth());
		engravingPanel.add(this.getEngravingFeedrateXY());
		
		JPanel drillingPanel = new JBorderPanel("Drilling");
		drillingPanel.add(this.getDrillingSpindleSpeed());
		drillingPanel.add(this.getDrillingDepth());
		drillingPanel.add(this.getDrillingFeedrateXY());
		
		JPanel millingPanel = new JBorderPanel("Milling");
		millingPanel.add(this.getMillingSpindleSpeed());
		millingPanel.add(this.getMillingDepth());
		millingPanel.add(this.getMillingFeedrateXY());
		
		JPanel generalPanel = new JBorderPanel("General");
		generalPanel.add(this.getSafetyHeight());
		generalPanel.add(this.getSpindleSpeedupTime());
		generalPanel.add(this.getUnitsPerMillimetre());
		
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

	public JComponentLabel getUnitsPerMillimetre() {
		return unitsPerMillimetre;
	}

	public void setUnitsPerMillimetre(JComponentLabel unitsPerMillimetre) {
		this.unitsPerMillimetre = unitsPerMillimetre;
	}

	public JComponentLabel getEngravingFeedrateXY() {
		return engravingFeedrateXY;
	}

	public void setEngravingFeedrateXY(JComponentLabel engravingFeedrateXY) {
		this.engravingFeedrateXY = engravingFeedrateXY;
	}

	public JComponentLabel getDrillingFeedrateXY() {
		return drillingFeedrateXY;
	}

	public void setDrillingFeedrateXY(JComponentLabel drillingFeedrateXY) {
		this.drillingFeedrateXY = drillingFeedrateXY;
	}

	public JComponentLabel getMillingFeedrateXY() {
		return millingFeedrateXY;
	}

	public void setMillingFeedrateXY(JComponentLabel millingFeedrateXY) {
		this.millingFeedrateXY = millingFeedrateXY;
	}

	public JComponentLabel getEngravingFeedrateZ() {
		return engravingFeedrateZ;
	}

	public void setEngravingFeedrateZ(JComponentLabel engravingFeedrateZ) {
		this.engravingFeedrateZ = engravingFeedrateZ;
	}

	public JComponentLabel getDrillingFeedrateZ() {
		return drillingFeedrateZ;
	}

	public void setDrillingFeedrateZ(JComponentLabel drillingFeedrateZ) {
		this.drillingFeedrateZ = drillingFeedrateZ;
	}

	public JComponentLabel getMillingFeedrateZ() {
		return millingFeedrateZ;
	}

	public void setMillingFeedrateZ(JComponentLabel millingFeedrateZ) {
		this.millingFeedrateZ = millingFeedrateZ;
	}

	public Configuration generate(int type) {		
		double safetyHeight = Float.parseFloat(this.getSafetyHeight().getValue());
		double spindleSpeedUpTime = Float.parseFloat(this.getSpindleSpeedupTime().getValue());
		double unitsPerMillimetre = Float.parseFloat(this.getUnitsPerMillimetre().getValue());

		switch(type) {
		case ENGRAVING:
			int engravingSpindleSpeed = Integer.parseInt(this.getEngravingSpindleSpeed().getValue());
			double engravinDepth = Float.parseFloat(this.getEngravingDepth().getValue());
			int engravingFeedrateXY = Integer.parseInt(this.getEngravingFeedrateXY().getValue());
			int engravingFeedrateZ = Integer.parseInt(this.getEngravingFeedrateZ().getValue());
			return new Configuration(engravingSpindleSpeed, spindleSpeedUpTime, engravinDepth, engravingFeedrateXY, engravingFeedrateZ, unitsPerMillimetre, safetyHeight);
			
		case DRILLING:
			int drillingSpindleSpeed = Integer.parseInt(this.getDrillingSpindleSpeed().getValue());
			double drillingDepth = Float.parseFloat(this.getDrillingDepth().getValue());
			int drillingFeedrateXY = Integer.parseInt(this.getDrillingFeedrateXY().getValue());
			int drillingFeedrateZ = Integer.parseInt(this.getDrillingFeedrateZ().getValue());
			return new Configuration(drillingSpindleSpeed, spindleSpeedUpTime, drillingDepth, drillingFeedrateXY, drillingFeedrateZ, unitsPerMillimetre, safetyHeight);
			
		case MILLING:
			int millingSpindleSpeed = Integer.parseInt(this.getMillingSpindleSpeed().getValue());
			double millingDepth = Float.parseFloat(this.getMillingDepth().getValue());
			int millingFeedrateXY = Integer.parseInt(this.getMillingFeedrateXY().getValue());
			int millingFeedrateZ = Integer.parseInt(this.getMillingFeedrateZ().getValue());
			return new Configuration(millingSpindleSpeed, spindleSpeedUpTime, millingDepth, millingFeedrateXY, millingFeedrateZ, unitsPerMillimetre, safetyHeight);
			
		default:
			throw new IllegalArgumentException("Unknown configuration type");
		}
	}
}
