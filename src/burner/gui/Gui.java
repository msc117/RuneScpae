package burner.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import org.powerbot.script.methods.MethodContext;

import burner.Burner;
import tasks.*;

public class Gui extends JPanel {
	
	private Burner burner;
	private MethodContext ctx;
	
	//constructor
	public Gui(Burner burner, MethodContext ctx) {
		getThingsReady();
		this.burner = burner;
		this.ctx = ctx;
	}
	//[9]USE 50/50 CHANCE OF MISS CLICKING THE TREE BY 1 TILE THEN CLICKING THE OBJECT
	private void startActions(ActionEvent e) {
		int treeId = 0;
		switch(wood.getSelectedItem().toString()) {
			case "Tree": 
				treeId = 1276;
				break;
			case "Oak Tree":
				treeId = 1281;
		}
		burner.taskList.add(new Burn(ctx, treeId));
		frame1.setVisible(false);
		frame1.dispose();
	}
	
	private void getThingsReady() {
		frame1 = new JFrame();
		wood = new JComboBox<>();
		label1 = new JLabel();
		start = new JButton();
		label2 = new JLabel();

		//======== frame1 ========
		{
			frame1.setTitle("Cooker");
			Container frame1ContentPane = frame1.getContentPane();

			//---- fish ----
			wood.setModel(new DefaultComboBoxModel<>(new String[] {
				"Tree",
				"Oak Tree"
			}));
			wood.setFont(wood.getFont().deriveFont(wood.getFont().getSize() + 7f));

			//---- label1 ----
			label1.setText("Wood:");
			label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 7f));

			//---- start ----
			start.setText("Start");
			start.setFont(start.getFont().deriveFont(start.getFont().getSize() + 10f));
			start.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					startActions(e);
				}
			});

			//---- label2 ----
			label2.setText("Be sure you are in the Flash Powder Factory");

			GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
			frame1ContentPane.setLayout(frame1ContentPaneLayout);
			frame1ContentPaneLayout.setHorizontalGroup(
				frame1ContentPaneLayout.createParallelGroup()
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addGap(143, 143, 143)
						.addComponent(start)
						.addContainerGap(144, Short.MAX_VALUE))
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addGap(72, 72, 72)
						.addGroup(frame1ContentPaneLayout.createParallelGroup()
							.addGroup(frame1ContentPaneLayout.createSequentialGroup()
								.addComponent(label2)
								.addContainerGap(79, Short.MAX_VALUE))
							.addGroup(frame1ContentPaneLayout.createSequentialGroup()
								.addComponent(label1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
								.addComponent(wood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(65, 65, 65))))
			);
			frame1ContentPaneLayout.setVerticalGroup(
				frame1ContentPaneLayout.createParallelGroup()
					.addGroup(frame1ContentPaneLayout.createSequentialGroup()
						.addGap(23, 23, 23)
						.addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(label1)
							.addComponent(wood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(frame1ContentPaneLayout.createParallelGroup()
							.addGroup(frame1ContentPaneLayout.createSequentialGroup()
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
								.addComponent(start))
							.addGroup(frame1ContentPaneLayout.createSequentialGroup()
								.addGap(26, 26, 26)
								.addComponent(label2)
								.addGap(0, 42, Short.MAX_VALUE)))
						.addContainerGap())
			);
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
		}
	}
	public JFrame frame1;
	private JComboBox<String> wood;
	private JLabel label1;
	private JButton start;
	private JLabel label2;
	
	
}
