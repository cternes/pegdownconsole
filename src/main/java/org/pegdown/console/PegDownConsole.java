package org.pegdown.console;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FilenameUtils;
import org.pegdown.console.processor.DefaultMarkdownProcessor;
import org.pegdown.console.processor.MarkdownProcessor;
import org.pegdown.console.processor.reader.FileMarkdownReader;
import org.pegdown.console.util.ConsolePrinter;
import org.pegdown.console.writer.FileMarkdownWriter;

public class PegDownConsole {

	private static final String NAME = "PegDownConsole";
	private static final String VERSION = "0.0.1";
	
	private CommandLine cmd;
	private ConsoleArguments consoleArguments = new DefaultConsoleArguments();
	private MarkdownProcessor markdownProcessor = new DefaultMarkdownProcessor();
	
	public static void main(String[] args) {
		PegDownConsole console = new PegDownConsole();
		console.init(args);
	}
	
	public void init(String[] args) {
		printHeader();
		
		new DefaultConsoleArguments();
		if(args == null || args.length == 0) {
			printUsage();
		}
		else {
			parseArguments(args);
		}
	}

	private void printHeader() {
		ConsolePrinter.printMessage("");
		ConsolePrinter.printMessage("------------------------------");
		ConsolePrinter.printMessage("Running "+ NAME + " V"+VERSION);
		ConsolePrinter.printMessage("------------------------------");
	}

	private void printUsage() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(consoleArguments.getConsoleHelp(), consoleArguments.getConsoleOptions());
	}
	
	private void parseArguments(String[] args) {
		CommandLineParser parser = new GnuParser();
	    try {
	    	cmd = parser.parse(consoleArguments.getConsoleOptions(), args);
	    	evaluateArguments();
	    }
	    catch( final ParseException e) {
	    	ConsolePrinter.printError("Parsing of arguments failed. ", e);
	        printUsage();
	        System.exit(-1);
	    }
	}

	private void evaluateArguments() {
		String inputFile = null;
		if(cmd.hasOption(DefaultConsoleArguments.INPUTFILE)) {
			inputFile = cmd.getOptionValue(DefaultConsoleArguments.INPUTFILE);
		}
		
		String outputFile = null;
		if(cmd.hasOption(DefaultConsoleArguments.OUTPUTFILE)) {
			inputFile = cmd.getOptionValue(DefaultConsoleArguments.OUTPUTFILE);
		}

		outputFile = generateOutputFileIfNull(inputFile, outputFile);
		
		processMarkdown(inputFile, outputFile);
	}

	private String generateOutputFileIfNull(String inputFile, String outputFile) {
		String result = outputFile;
		if(outputFile == null) {
			String name = FilenameUtils.getBaseName(inputFile);
			String path = FilenameUtils.getFullPath(inputFile);
			String extension = ".html";
			result = path + name + extension;
		}
		return result;
	}

	private void processMarkdown(String inputFile, String outputFile) {
		ConsolePrinter.printMessage("Reading input...");
		String markdown = markdownProcessor.readInputMarkdown(new FileMarkdownReader(inputFile));
		
		ConsolePrinter.printMessage("Processing markdown...");
		String html = markdownProcessor.parseMarkdown(markdown);
		
		ConsolePrinter.printMessage("Writing html...");
		markdownProcessor.writeOutput(new FileMarkdownWriter(outputFile), html);
		
		ConsolePrinter.printMessage("Processing finished. Html was written to "+outputFile);
		System.exit(0);
	}
	
}
