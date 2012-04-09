/*
 * Written by : Miki Ljuljdurovic
 * 03-60-280 final project
 * OrangeRss
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JFrame {                                                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                                                                                               
        //1280 x 720      
		FeedPanel feedPanel = null;
		RSSPanel rssPanel = new RSSPanel(this);                                                                                                                                                                                                                                                                                                                          
                                                                                                                                                                                                                                                                                                                               
        public MainPanel()                                                                                                                                                                                                                                                                                                     
        {        
        	setLayout(new BorderLayout());
        	try
    		{
    			feedPanel = new FeedPanel(this);   
    		} catch (IOException io) {
    			io.printStackTrace();
    		} 
                this.setSize(1280,720);                                                                                                                                                                                                                                                                                        
                this.add(feedPanel, BorderLayout.WEST);
                this.add(rssPanel, BorderLayout.EAST);
                this.setVisible(true);                                                                                                                                                                                                                                                                                         
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);                                                                                                                                                                                                                                                                  
        }                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                                                                               
        public void openFeed(String URL, String Name)                                                                                                                                                                                                                                                                          
        {                                                                                                                                                                                                                                                                                                                      
                rssPanel.newTab(URL,Name);                                                                                                                                                                                                                                                                                     
        }                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                               
}
