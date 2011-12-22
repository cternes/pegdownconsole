package org.pegdown.console.processor;

import org.pegdown.console.processor.reader.MarkdownReader;
import org.pegdown.console.writer.MarkdownWriter;


public interface MarkdownProcessor {

	public String readInputMarkdown(MarkdownReader reader);
	public String parseMarkdown(String markdown);
	public void writeOutput(MarkdownWriter writer, String html);
}
