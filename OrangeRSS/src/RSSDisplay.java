import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;

public class RSSDisplay extends JPanel implements Runnable                                                                                                                                                                                                                                                                     
{                                                                                                                                                                                                                                                                                                                              
	public JEditorPane rssPane;
	private URL url;
	
        public RSSDisplay(String url)                                                                                                                                                                                                                                                                                          
        {          
        	this.setSize(800, 700);
        	this.setVisible(true);
        	try {
				this.url = new URL(url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
        		RSSParser parser = null;
        		try {
        			parser = new RSSParser(this.url.toString());
        		} catch (ParserConfigurationException e) {
        			e.printStackTrace();
        		}
        		parser.parseDocument();
				rssPane = new JEditorPane();
				rssPane.setContentType("text/html");
				rssPane.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(rssPane);
				this.add(rssPane);
				this.add(scrollPane);
				String html = "";
				for (String i : parser.getFeedDescriptions())
				{
					html += i;
				}
				rssPane.setText(html);
				System.out.println(rssPane.getText());
        }                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                               
        public void run()                                                                                                                                                                                                                                                                                                      
        { 

        }                                                                                                                                                                                                                                                                                                                           
                                                                                                                                                                                                                                                                                                                               
}
