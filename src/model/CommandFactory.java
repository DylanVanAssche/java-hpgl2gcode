package model;

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
	
	public void parseHPGLCode(String code) {
		// Check if command properly ends	
		if(code.endsWith(";")) {
			String[] parts = code.split("\\[A-Z]");
			String command = parts[0];
			String[] parameters;
			System.out.println(command);
		}
		else {
			System.out.println("';' expected at the end of the command!");
		}
		
	}
}
