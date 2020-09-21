package Shapes;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Shape{
	final int width = 150;
	final int height = 100;
	Point centerpoint;
	public Oval(){
		
	}
	public Oval(Point p){
		this.initialpoint = new Point(p);
		this.connectpoint[0] = new Point(p.x + width, p.y + (height/2));		//東
		this.connectpoint[1] = new Point(p.x + (width/2), p.y + height);		//南
		this.connectpoint[2] = new Point(p.x,p.y + (height/2));				//西
		this.connectpoint[3] = new Point(p.x + (width/2), p.y);				//北
		this.centerpoint = new Point(p.x + (width/2), p.y + (height/2));
	}
	public void getPoint(Point p) {
		this.initialpoint = new Point(p);
		this.connectpoint[0] = new Point(p.x + width, p.y + (height/2));		//東
		this.connectpoint[1] = new Point(p.x + (width/2), p.y + height);		//南
		this.connectpoint[2] = new Point(p.x,p.y + (height/2));				//西
		this.connectpoint[3] = new Point(p.x + (width/2), p.y);				//北
		this.centerpoint = new Point(p.x + (width/2), p.y + (height/2));
	}
	public boolean isInShape(Point t) {
		Point translationpoint = new Point(t.x - centerpoint.x, t.y - centerpoint.y);
		int a = width/2;
		int b = height/2;
		if(translationpoint.x*translationpoint.x/a/a + translationpoint.y*translationpoint.y/b/b < 1) {
			return true;
		}else {
			return false;
		}
	}
	public Point nearestconnect(Point t) {
		double tmpdistance = 20000;
		Point nearestpoint = null;
		for(int i = 0; i < 4; i++) {
			if(tmpdistance > 
			Math.sqrt(Math.abs((t.x - connectpoint[i].x)*(t.x - connectpoint[i].x) + (t.y - connectpoint[i].y)*(t.y - connectpoint[i].y)))){
				tmpdistance = Math.sqrt(Math.abs((t.x - connectpoint[i].x)*(t.x - connectpoint[i].x) + (t.y - connectpoint[i].y)*(t.y - connectpoint[i].y)));
				nearestpoint = new Point(connectpoint[i].x, connectpoint[i].y);
			}
			
		}
		return nearestpoint;
	}
	public void changePoints(Point dragpoint) {
		initialpoint.x = initialpoint.x + dragpoint.x - lastdrag.x;
		initialpoint.y = initialpoint.y + dragpoint.y - lastdrag.y;
		centerpoint = new Point((width/2) + initialpoint.x, (height/2) + initialpoint.y);
		changeConnectpoint();
		lastdrag = new Point(dragpoint);
	}
	void changeConnectpoint() {
		this.connectpoint[0] = new Point(width + initialpoint.x, (height/2) + initialpoint.y);		//東
		this.connectpoint[1] = new Point((width/2) + initialpoint.x, height + initialpoint.y);		//南
		this.connectpoint[2] = new Point(initialpoint.x, (height/2) + initialpoint.y);				//西
		this.connectpoint[3] = new Point((width/2) + initialpoint.x, initialpoint.y);					//北
	}
	public void paint(Graphics g) {
		g.drawOval(initialpoint.x, initialpoint.y, width, height);
		g.drawString(title, initialpoint.x + (width/4), initialpoint.y + (height/2));
	}
}
