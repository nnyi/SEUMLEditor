import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import javax.swing.JPanel;

import Shapes.ConnectionLine;
import Shapes.Shape;

public class DrawPanel extends JPanel {
	Vector<Shape> Shapes = new Vector<Shape>();
	Vector<ConnectionLine> Connectlines = new Vector<ConnectionLine>();
	
	DrawPanel(){
		this.setBackground(Color.white);
	}
	public void paintshapeconnectpoint(Graphics g, Shape s) {
		for(int i = 0; i < s.connectpoint.length;i++) {
			g.fillOval(s.connectpoint[i].x - 5, s.connectpoint[i].y - 5, 10, 10);
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintShape(g);
		paintConnectlines(g);
	}
	void paintShape(Graphics g) {
		for(int i = 0; i < Shapes.size(); i++) {
			if(Shapes.elementAt(i).isSelected) {
				paintshapeconnectpoint(g, Shapes.elementAt(i));
			}
			Shapes.elementAt(i).paint(g);
    	}
	}
	void paintConnectlines(Graphics g) {
		for(int i = 0; i < Connectlines.size(); i++) {
			Connectlines.elementAt(i).paint(g);
    	}
	}
}

