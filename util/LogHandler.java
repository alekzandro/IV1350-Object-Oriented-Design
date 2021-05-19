package se.kth.iv1350.PointOfSale.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * Class <code>LogHandler</code> handling logging matters.
 *
 */
public class LogHandler {
	private static final String LOG_FILE_NAME = "point_of_sale_error-log.txt";
	private PrintWriter logFile;
	
	/**
	 * Creates new instance of <code>LogHandler</code>
	 * @throws IOException If the creation of the log file fails.
	 */
	public LogHandler() throws IOException{
		logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
	}
	
	/**
	 * Logs the exception to the log file.
	 * @param exception The exception to be logged.
	 */
	public void logException(Throwable exception) {
		StringBuilder logMessageBuilder = new StringBuilder();
		logMessageBuilder.append(createTime());
		logMessageBuilder.append(", exception was thrown: ");
		logMessageBuilder.append(exception.getMessage());
		logMessageBuilder.append(exception.getCause());
		logFile.println(logMessageBuilder);
		exception.printStackTrace(logFile);
	}

	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}
}
