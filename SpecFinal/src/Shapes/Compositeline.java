package Shapes;

import java.awt.Graphics;
import java.awt.Point;

public class Compositeline extends ConnectionLine{
	public Compositeline(){
		
	}
	public Compositeline(Point firstpoint, Point secondpoint, Shape firstConnectshape, Shape secondConnectshape){
		super(firstpoint, secondpoint, firstConnectshape, secondConnectshape);
	}
	public void paint(Graphics g) {
		Point[] rtPoint = new Point[2];
		rtPoint = drawarrowline();
		Point Endpoint = new Point(rtPoint[0].x + rtPoint[1].x - p[1].x, rtPoint[0].y + rtPoint[1].y - p[1].y);
		g.drawLine(p[0].x, p[0].y, Endpoint.x, Endpoint.y);
	    g.drawLine(p[1].x, p[1].y, rtPoint[0].x, rtPoint[0].y);
	    g.drawLine(p[1].x, p[1].y, rtPoint[1].x, rtPoint[1].y);
	    g.drawLine(Endpoint.x, Endpoint.y, rtPoint[0].x, rtPoint[0].y);
	    g.drawLine(Endpoint.x, Endpoint.y, rtPoint[1].x, rtPoint[1].y);
	}
}
