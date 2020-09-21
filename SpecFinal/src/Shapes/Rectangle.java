package Shapes;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape{
	final int width = 100;
	final int height = (int) (width * 1.5);
	public Rectangle(){
		
	}
	public Rectangle(Point p){
		super(p);
	}
	public boolean isInShape(Point t) {
		if(t.x<= initialpoint.x + width && t.x >= initialpoint.x	&& t.y >= initialpoint.y && t.y <= initialpoint.y + height) {
			return true;
		}else {
			return false;
		}
	}
	public void changePoints(Point dragpoint) {
		initialpoint.x = initialpoint.x + dragpoint.x - lastdrag.x;
		initialpoint.y = initialpoint.y + dragpoint.y - lastdrag.y;
		changeConnectpoint();
		lastdrag = new Point(dragpoint);
	}
	void changeConnectpoint() {
		this.connectpoint[0] = new Point(width + initialpoint.x, (height/2) + initialpoint.y);	//東
		this.connectpoint[1] = new Point((width/2) + initialpoint.x, height + initialpoint.y);	//南
		this.connectpoint[2] = new Point(initialpoint.x, (height/2) + initialpoint.y);			//西
		this.connectpoint[3] = new Point((width/2) + initialpoint.x, initialpoint.y);				//北
	}
	public void paint(Graphics g) {
		Point secondPoint = new Point(initialpoint.x, (int) (initialpoint.y + (width * 0.5)));
		Point thirdPoint = new Point(initialpoint.x, (int) (initialpoint.y + (width * 1)));
        g.drawRect(initialpoint.x, initialpoint.y, width, height);
        g.drawLine(secondPoint.x, secondPoint.y, secondPoint.x + width, secondPoint.y);
        g.drawLine(thirdPoint.x, thirdPoint.y, thirdPoint.x + width, thirdPoint.y);
        g.drawString(title, initialpoint.x + (width/10), initialpoint.y + (height/10));
    }
}
