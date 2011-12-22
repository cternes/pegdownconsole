package org.pegdown.console.processor;

import org.pegdown.PegDownProcessor;
import org.pegdown.console.processor.reader.MarkdownReader;
import org.pegdown.console.util.ConsolePrinter;
import org.pegdown.console.writer.MarkdownWriter;


public class DefaultMarkdownProcessor implements MarkdownProcessor {

	private PegDownProcessor processor = new PegDownProcessor();
	
	public String readInputMarkdown(MarkdownReader reader) {
		if(reader == null) {
			ConsolePrinter.printError("MarkdownReader is null. Please provide a proper MarkdownReader Implementation.");
		}
		return reader.readMarkdown();
	}

	public String parseMarkdown(String markdown) {
		if(markdown != null && !markdown.isEmpty()) {
			return processor.markdownToHtml(markdown);
		}
		return "";
	}

	public void writeOutput(MarkdownWriter writer, String html) {
		if(writer == null) {
			ConsolePrinter.printError("MarkdownWriter is null. Please provide a proper MarkdownWriter Implementation.");
		}
		writer.writeHtml(html);
	}


}
