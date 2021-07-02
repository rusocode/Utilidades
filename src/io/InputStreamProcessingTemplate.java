package io;

import java.io.*;

// http://tutorials.jenkov.com/java-exception-handling/exception-handling-templates.html
public class InputStreamProcessingTemplate {

	public static void process(String fileName, InputStreamProcessor processor) throws MyException {

		IOException processException = null;
		InputStream input = null;

		try {
			input = new FileInputStream(fileName);
			processor.process(input);
		} catch (IOException e) {
			processException = e;
		} finally {

			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					if (processException != null) throw new MyException(processException, e, "Error message..." + fileName);
					else throw new MyException(e, "Error closing InputStream for file " + fileName);
				}
			}

			if (processException != null) throw new MyException(processException, "Error processing InputStream for file " + fileName);

		}
	}

}
