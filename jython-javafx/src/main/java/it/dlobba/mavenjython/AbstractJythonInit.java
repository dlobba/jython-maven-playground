package it.dlobba.mavenjython;

import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyFile;
import org.python.core.PySystemState;
import org.python.util.InteractiveConsole;

public abstract class AbstractJythonInit {

	protected String[] args;
	protected InteractiveConsole console;

	public AbstractJythonInit(String[] args) {
		this.args = args;

		PySystemState.initialize(PySystemState.getBaseProperties(), new Properties(), args);

		console = createInterpreter(checkIsInteractive());
	}

	protected boolean checkIsInteractive() {
		PySystemState systemState = Py.getSystemState();
		boolean interactive = ((PyFile) Py.defaultSystemState.stdin).isatty();
		if (!interactive) {
			systemState.ps1 = systemState.ps2 = Py.EmptyString;
		}
		return interactive;
	}

	protected InteractiveConsole createInterpreter(boolean interactive) {
		InteractiveConsole console = newInterpreter(interactive);
		Py.getSystemState().__setattr__("_jy_interpreter", Py.java2py(console));
		return console;
	}

	private InteractiveConsole newInterpreter(boolean interactiveStdin) {
		if (!interactiveStdin) {
			return new InteractiveConsole();
		}

		String interpClass = PySystemState.registry.getProperty("python.console", "");
		if (interpClass.length() > 0) {
			try {
				return (InteractiveConsole) Class.forName(interpClass).getDeclaredConstructor().newInstance();
			} catch (Throwable t) {
				// fall through
			}
		}
		return new InteractiveConsole();
	}

}
