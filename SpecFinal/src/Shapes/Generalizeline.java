package Shapes;

import java.awt.Graphics;
import java.awt.Point;

public class Generalizeline extends ConnectionLine{
	public Generalizeline(){
		
	}
	public Generalizeline(Point firstpoint, Point secondpoint, Shape firstConnectshape, Shape secondConnectshape){
		super(firstpoint, secondpoint, firstConnectshape, secondConnectshape);
	}
	public void paint(Graphics g) {
		Point[] rtPoint = new Point[2];
		rtPoint = drawarrowline();
		Point midpoint = new Point((rtPoint[0].x + rtPoint[1].x) / 2, (rtPoint[0].y + rtPoint[1].y) / 2);
	    g.drawLine(p[0].x, p[0].y, midpoint.x, midpoint.y);
	    g.drawLine(p[1].x, p[1].y, rtPoint[0].x, rtPoint[0].y);
	    g.drawLine(p[1].x, p[1].y, rtPoint[1].x, rtPoint[1].y);
	    g.drawLine(rtPoint[0].x, rtPoint[0].y, rtPoint[1].x, rtPoint[1].y);
	}
}
