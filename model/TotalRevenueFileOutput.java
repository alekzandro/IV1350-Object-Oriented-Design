package se.kth.iv1350.PointOfSale.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * Class <code>TotalRevenueFileOutput</code>
 *
 */

public class TotalRevenueFileOutput implements Observer {
	private static final String REVENUE_LOG_FILE_NAME = "point_of_sale_revenue-log.txt";
	private PrintWriter revenueLogFile;
	
	/**
	 * Creates a new instance of class <code>TotalRevenueFileOutput</code>
	 * @throws IOException If the creation of output file fails.
	 */
	public TotalRevenueFileOutput() throws IOException{
		revenueLogFile = new PrintWriter(new FileWriter(REVENUE_LOG_FILE_NAME), true);
	}
	

	/**
	 * Updates the total revenue.
	 * @param totalRevenue The total revenue.
	 */
		
	public void update(double totalRevenue) {
		logRevenue(totalRevenue);
	}
	
	private void logRevenue(double totalRevenue) {
		StringBuilder logMessageBuilder = new StringBuilder();
		logMessageBuilder.append(createTime());
		logMessageBuilder.append(", total revenue: ");
		logMessageBuilder.append(totalRevenue);
		logMessageBuilder.append(" kr.");
		revenueLogFile.println(logMessageBuilder);
		
	}

	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}

}
