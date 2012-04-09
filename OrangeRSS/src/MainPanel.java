/*
 * Written by : Miki Ljuljdurovic
 * 03-60-280 final project
 * OrangeRss
 */
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JFrame {                                                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                                                                                               
        //1280 x 720      
		FeedPanel feedPanel = null;
		RSSPanel rssPanel = new RSSPanel(this);                                                                                                                                                                                                                                                                                                                          
                                                                                                                                                                                                                                                                                                                               
        public MainPanel()                                                                                                                                                                                                                                                                                                     
        {         
        	try
    		{
    			FeedPanel feedPanel = new FeedPanel(this);   
    		} catch (IOException io) {
    			io.printStackTrace();
    		} 
                this.setSize(1280,720);                                                                                                                                                                                                                                                                                        
                feedPanel.setBounds(0,0,320,720); //takes 1/4 of screen                                                                                                                                                                                                                                                        
                rssPanel.setBounds(320,0,960,720);//takes 3/4 of screen                                                                                                                                                                                                                                                        
                this.setVisible(true);                                                                                                                                                                                                                                                                                         
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);                                                                                                                                                                                                                                                                  
        }                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                                                                                               
        public void openFeed(String URL, String Name)                                                                                                                                                                                                                                                                          
        {                                                                                                                                                                                                                                                                                                                      
                rssPanel.newTab(URL,Name);                                                                                                                                                                                                                                                                                     
        }                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                               
}
