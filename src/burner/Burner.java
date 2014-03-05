package burner;


import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.Manifest;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.*;
import org.powerbot.script.methods.*;

import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

import burner.gui.Gui;
import tasks.*;

@Manifest(name = "Mikel", description = "Burns logs")
public class Burner extends PollingScript implements MessageListener {
	//class holders
	public List<Task> taskList = new ArrayList<>();
	private String treeId;
	private int logsLit = 0;
	
	//methods
	
	@Override
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Gui(Burner.this, ctx).frame1.setVisible(true);
			}
		});
	}
	
	@Override
	public int poll() {
		for (Task task : taskList) {
			if (task.activate()) { //we're able to execute
				task.execute();
			}
		}
		return 100;
	}
	
	@Override
	public void messaged(MessageEvent e) {
		String message = e.getMessage();
		if (message.contains("fire catches"))
			logsLit++;
	}
}
