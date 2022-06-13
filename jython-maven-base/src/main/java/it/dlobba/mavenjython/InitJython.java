package it.dlobba.mavenjython;

import javax.script.ScriptException;

public class InitJython extends AbstractJythonInit {

	// Pointer to main jython script.
	// Maven points "/" to "src/main/resources"
	final static String JYTHON_MAIN = "/__run__.py";

	public InitJython(String[] args) {
		super(args);
	}

	public void run() throws ScriptException {
		System.out.print(args.length + " Arguments: ");
		for (String s : args) {
			System.out.print(s);
			System.out.print(", ");
		}
		System.out.println();

		if (args.length == 0) {
			console.interact();
			return;
		}

		if (args[0].equals("run")) {
			console.execfile(InitJython.class.getResourceAsStream(JYTHON_MAIN), JYTHON_MAIN);
			return;
		}

		if (args[0].equals("eval") && (args.length > 1)) {
			console.exec(args[1]);
			return;
		}
	}

	public static void main(String[] args) throws ScriptException {
		System.out.println("Java started");
		new InitJython(args).run();
		System.out.println("Java exiting");
	}
}
