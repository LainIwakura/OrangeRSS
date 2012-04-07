import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;


public class rss_tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Scanner input = new Scanner(System.in);
		System.out.println("Enter a feed url: ");
		String feed = input.next();
		RSSParser parser = null;
		try {
			parser = new RSSParser(feed);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		parser.parseDocument();
		parser.printFeedItems();
		*/
		System.out.println(RSSParser.isValid("http://www.google.com"));
	}

}
