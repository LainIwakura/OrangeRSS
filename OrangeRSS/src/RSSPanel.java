import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class RSSPanel extends JPanel
{
	MainPanel main;
	JTabbedPane tabbedPane = new JTabbedPane();
	private ExecutorService threadExecutor;
	
	public RSSPanel(MainPanel parent)
	{
		main = parent;
		add(tabbedPane);
		this.setSize(640, 480);
		threadExecutor = Executors.newCachedThreadPool();
	}
	
	public void newTab(String URL,String name)
	{
		RSSDisplay newTab = new RSSDisplay(URL);
		tabbedPane.addTab("<html><body><table width='600'>"+name+"</table></body></html>" ,null, newTab,"First Panel");
		threadExecutor.execute(newTab);
	}
	
}
