package org.pegdown.console;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

public class DefaultConsoleArguments implements ConsoleArguments {

	private final Options options = new Options();
	protected static final String INPUTFILE = "inputFile";
	protected static final String OUTPUTFILE = "outputFile";
	
	public DefaultConsoleArguments() {
		Option inputFileParam = OptionBuilder.withArgName(INPUTFILE)
		.hasArg()
		.withDescription("the markdown file")
		.withLongOpt("inputFile")
		.isRequired()
		.create("i");
		
		Option outputFileParam = OptionBuilder.withArgName("outputFile")
		.hasArg()
		.withDescription("the generated html output file")
		.withLongOpt("outputFile")
		.create("o");
		
		options.addOption(inputFileParam);
		options.addOption(outputFileParam);
	}
	
	public Options getConsoleOptions() {
		return options;
	}

	public String getConsoleHelp() {
		return "pegdownconsole -i MARKDOWNFILE [-o HTMLFILE]";
	}
	
}
