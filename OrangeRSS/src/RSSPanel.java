import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class RSSPanel extends JPanel
{
   MainPanel main;                                                                                                                                                                                                                                                                                                        
   JTabbedPane tabbedPane = new JTabbedPane();                                                                                                                                                                                                                                                                            
	                                                                                                                                                                                                                                                                                                                               
	        public RSSPanel(MainPanel parent)                                                                                                                                                                                                                                                                                      
	        {                                                                                                                                                                                                                                                                                                                      
	                main = parent;                                                                                                                                                                                                                                                                                                 
	                add(tabbedPane);                                                                                                                                                                                                                                                                                               
	        }                                                                                                                                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                                                                                               
	        public void newTab(String URL,String name)                                                                                                                                                                                                                                                                             
	        {                                                                                                                                                                                                                                                                                                                      
	                tabbedPane.addTab(name ,null, new RSSDisplay(URL),"First Panel");                                                                                                                                                                                                                                                  
	        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
}