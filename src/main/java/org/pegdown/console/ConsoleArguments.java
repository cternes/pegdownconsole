package org.pegdown.console;

import org.apache.commons.cli.Options;

public interface ConsoleArguments {

	public Options getConsoleOptions();
	public String getConsoleHelp();
}
