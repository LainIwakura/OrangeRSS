/* Written by: Zach Easterbrook
 * For: 60-280 Final project
 * 
 */
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.apache.commons.validator.routines.UrlValidator;

public class RSSParser {
	private String feed_url;
	private ArrayList<FeedItem> items = new ArrayList<FeedItem>();
	private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private DocumentBuilder db = dbf.newDocumentBuilder();
	private Document doc = null;
	private String tags[] = {"author", "category", "channel", "copyright", "description", "generator",
		"guid", "item", "link", "pubDate", "title", "ttl"	
	};
	
	public RSSParser(String feed) throws ParserConfigurationException
	{
		this.feed_url = feed;
		try {
			doc = db.parse(new URL(this.feed_url).openStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parseDocument()
	{
		try
		{
			doc.getDocumentElement().normalize();
			// Get all of the "items", a top level xml element for separate rss messages
			NodeList listOfItems = doc.getElementsByTagName("item");
			for (int i = 0; i < listOfItems.getLength(); i++)
			{
				Node currentItem = listOfItems.item(i);
				if (Node.ELEMENT_NODE == currentItem.getNodeType())
				{
					Element itemAsElement = (Element)currentItem;
					FeedItem currentFeedItem = new FeedItem();
					currentFeedItem = getNodeInfo(itemAsElement);
					// Put it into our array list of feed items
					items.add(currentFeedItem);
				}
			}
		} catch (Throwable t) {
			t.printStackTrace ();
		}
	}
	
	private FeedItem getNodeInfo(Element itemAsElement) 
	{
		FeedItem temp = new FeedItem();
		
		
		/* This is a bit strange, but I can explain! We need cover all of our bases
		 * where valid rss tags are concerned, so we loop through an array of tags
		 * and look up a node with that tag..if we get one we have to set the appropriate
		 * string in feed item. It's a bit difficult to find out what exactly it is though..
		 * so we use this funny switch case to decide which function to call.
		 */
		for (String s : tags) {
			NodeList elementList = itemAsElement.getElementsByTagName(s);
			Element ele = (Element)elementList.item(0);
			if (ele != null)
			{
				switch (s.toCharArray()[0])
				{
				case 'a':
					temp.setAuthor(ele.getChildNodes().item(0).getNodeValue().trim());
					break;
				case 'c':
					switch (s.toCharArray()[1])
					{
					case 'a':
						temp.setCategory(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					case 'h':
						temp.setChannel(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					case 'o':
						temp.setCopyright(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					}
					break;
				case 'd':
					temp.setDescription(ele.getChildNodes().item(0).getNodeValue().trim());
					break;
				case 'g':
					switch (s.toCharArray()[1])
					{
					case 'e':
						temp.setGenerator(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					case 'u':
						temp.setGuid(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					}
					break;
				case 'i':
					temp.setItem(ele.getChildNodes().item(0).getNodeValue().trim());
					break;
				case 'l':
					temp.setLink(ele.getChildNodes().item(0).getNodeValue().trim());
					break;
				case 'p':
					temp.setPubDate(ele.getChildNodes().item(0).getNodeValue().trim());
					break;
				case 't':
					switch (s.toCharArray()[1])
					{
					case 'i':
						temp.setTitle(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					case 't':
						temp.setTtl(ele.getChildNodes().item(0).getNodeValue().trim());
						break;
					}
					break;
				}
			}
		}
		
		return temp;
	}
	
	public void printFeedItems()
	{
		for (FeedItem i : items)
		{
			System.out.println("Title: " + i.getTitle());
			System.out.println("Descrption: " + i.getDescription());
		}
	}

	public String getFeedName()
	{
		return this.feed_url;
	}
	
	public ArrayList<String> getFeedDescriptions()
	{
		ArrayList<String> descriptions = new ArrayList<String>();
		for (FeedItem i : items)
		{
			descriptions.add(i.getDescription());
		}
		
		return descriptions;
	}
	
	public ArrayList<String> getTitles()
	{
		ArrayList<String> titles = new ArrayList<String>();
		for (FeedItem i : items)
		{
			titles.add(i.getTitle());
		}
		
		return titles;
	}
	
	public static boolean isValid(String url)
	{
		UrlValidator urlValid = new UrlValidator();
		return urlValid.isValid(url);
	}
}
