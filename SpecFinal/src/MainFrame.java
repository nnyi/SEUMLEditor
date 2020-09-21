import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mode.PaintTube;

public class MainFrame extends JFrame implements ActionListener,  MouseListener, MouseMotionListener {
	JPanel buttonPanel = new ButtonPanel();
	JPanel drawPanel = new DrawPanel();
	Point mousepoint;
	PaintTube tube = new PaintTube();
	MainFrame(){
		super("Spec of UML editor");
		init();
	}
	MainFrame(String title){
		super(title);
		init();
	}
	void init(){
		buttonPanel.setPreferredSize(new Dimension(100, 100));
		drawPanel.setPreferredSize(new Dimension(100, 100));
		drawPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		JPanel tmpPanel = new JPanel();
		tmpPanel.setBackground(Color.RED);
		tmpPanel.setPreferredSize(new Dimension(50, 5));
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenuItem GroupMenuItem = new JMenuItem("Group");
		GroupMenuItem.setActionCommand("Group");
		JMenuItem UnGroupMenuItem = new JMenuItem("UnGroup");
		UnGroupMenuItem.setActionCommand("UnGroup");
		JMenuItem printMenuItem = new JMenuItem("change object name");
		printMenuItem.setActionCommand("print");
		editMenu.add(GroupMenuItem);
		editMenu.add(UnGroupMenuItem);
		editMenu.add(printMenuItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		GroupMenuItem.addActionListener(this);
		UnGroupMenuItem.addActionListener(this);
		printMenuItem.addActionListener(this);
				
		drawPanel.addMouseListener(this);
		drawPanel.addMouseMotionListener(this);
		
		((DrawPanel) drawPanel).Shapes = tube.getShapes();
		((DrawPanel) drawPanel).Connectlines = tube.getConnectlines();
		
		this.setJMenuBar(menuBar);
		this.setLayout(new BorderLayout(10,10));
		this.add(buttonPanel, BorderLayout.WEST);
		this.add(drawPanel, BorderLayout.CENTER);
		this.add(tmpPanel, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		sizeWindowOnScreen(this, 0.6, 0.6);
		this.setVisible(true);
	}
	private void sizeWindowOnScreen(MainFrame mainframe, double widthRate,double heightRate){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 
		mainframe.setSize(new Dimension((int) (screenSize.width * widthRate),
				(int) (screenSize.height * heightRate)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame spec = new MainFrame();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mousepoint = new Point(arg0.getX(), arg0.getY());
		if(((ButtonPanel) buttonPanel).mode!= null) {
			((ButtonPanel) buttonPanel).mode.onDragged(mousepoint, tube);
		}
		drawPanel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mousepoint = new Point(e.getX(), e.getY());
		if(((ButtonPanel) buttonPanel).mode != null) {
			((ButtonPanel) buttonPanel).mode.onClick(mousepoint, tube);
		}
		drawPanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mousepoint = new Point(e.getX(), e.getY());
		if(((ButtonPanel) buttonPanel).mode != null) {
			((ButtonPanel) buttonPanel).mode.onPressed(mousepoint, tube);
		}
		drawPanel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mousepoint = new Point(e.getX(), e.getY());
		if(((ButtonPanel) buttonPanel).mode != null) {
			((ButtonPanel) buttonPanel).mode.onReleased(mousepoint, tube);
		}
		drawPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
	    if (cmd == "Group") {
	    	//((ButtonPanel) buttonPanel).PModel.Group();
	    	tube.Group();
	    }
	    if (cmd == "UnGroup") {
	    	//((ButtonPanel) buttonPanel).PModel.unGroup();
	    	tube.unGroup();
	    } 
	    if (cmd == "print") {
	    	JFrame f =new JFrame("JOptionPane Test");
	        f.setSize(400,300);
	    	String input = JOptionPane.showInputDialog("§ó§ïObject Name");
	    	if(input != null) {
	    		tube.settitle(input);
	    	}
	    }
	    drawPanel.repaint();
	}

}
