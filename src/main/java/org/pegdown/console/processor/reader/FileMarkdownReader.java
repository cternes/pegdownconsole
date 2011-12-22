package org.pegdown.console.processor.reader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.pegdown.console.util.ConsolePrinter;

public class FileMarkdownReader implements MarkdownReader {

	private File inputFile;
	
	public FileMarkdownReader(String inputFile) {
		if(inputFile != null) {
			this.inputFile = new File(inputFile);
		}
	}

	public String readMarkdown() {
		if(inputFile != null) {
			try {
				return FileUtils.readFileToString(inputFile);
			}
			catch (IOException e) {
				ConsolePrinter.printMessage("There was an error while reading the file "+inputFile+". " +
						"Are you sure it exists? Is it open by another application?");
				
				System.exit(-1);
			}
		}

		return null;
	}

}
