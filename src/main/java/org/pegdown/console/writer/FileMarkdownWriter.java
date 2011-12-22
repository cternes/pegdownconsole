package org.pegdown.console.writer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.pegdown.console.util.ConsolePrinter;

public class FileMarkdownWriter implements MarkdownWriter {

	private File outputFile;
	
	public FileMarkdownWriter(String outputFile) {
		if(outputFile != null) {
			this.outputFile = new File(outputFile);
		}
	}
	
	public void writeHtml(String html) {
		if(outputFile != null) {
			try {
				FileUtils.write(outputFile, html);
			}
			catch (IOException e) {
				ConsolePrinter.printMessage("There was an error while writing to the "+outputFile+". " +
				"Do you have enough permissions to write to this file?");
				
				System.exit(-1);
			}
		}
	}

}
