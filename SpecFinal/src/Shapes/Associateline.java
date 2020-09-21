package Shapes;

import java.awt.Graphics;
import java.awt.Point;

public class Associateline extends ConnectionLine{
	public Associateline() {
		// TODO Auto-generated constructor stub
	}
	public Associateline(Point firstpoint, Point secondpoint, Shape firstConnectshape, Shape secondConnectshape){
		super(firstpoint, secondpoint, firstConnectshape, secondConnectshape);
	}
	
	public void paint(Graphics g) {
		Point[] rtPoint = new Point[2];
		rtPoint = drawarrowline();
	    g.drawLine(p[0].x, p[0].y, p[1].x, p[1].y);
	    g.drawLine(p[1].x, p[1].y, rtPoint[0].x, rtPoint[0].y);
	    g.drawLine(p[1].x, p[1].y, rtPoint[1].x, rtPoint[1].y);
	}
}
