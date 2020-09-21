package Shapes;
import java.awt.Graphics;
import java.awt.Point;

public class Shape {
	public boolean isSelected = false;
	public final int width = 100;
	public final int height = (int) (width * 1.5);
	public int depth = -1;
	String title = "ObjectName";
	public Point[] connectpoint = new Point[4];
	public Point initialpoint;
	Point lastdrag = new Point();
	Shape() {
		
	}
	Shape(Point p){
		this.initialpoint = new Point(p);
		this.connectpoint[0] = new Point(p.x + width, p.y + (height/2));	//東
		this.connectpoint[1] = new Point(p.x + (width/2), p.y + height);	//南
		this.connectpoint[2] = new Point(p.x, p.y + (height/2));			//西
		this.connectpoint[3] = new Point(p.x + (width/2), p.y);				//北
	}
	public void getPoint(Point p) {
		this.initialpoint = new Point(p);
		this.connectpoint[0] = new Point(p.x + width, p.y + (height/2));	//東
		this.connectpoint[1] = new Point(p.x + (width/2), p.y + height);	//南
		this.connectpoint[2] = new Point(p.x, p.y + (height/2));			//西
		this.connectpoint[3] = new Point(p.x + (width/2), p.y);				//北
	}
	public boolean isInShape(Point t) {
		if(t.x<= initialpoint.x + width && t.x >= initialpoint.x	&& t.y >= initialpoint.y && t.y <= initialpoint.y + height) {
			System.out.println("shape R");
			return true;
		}else {
			return false;
		}
	}
	public void setTitle(String s) {
		this.title = new String(s);
	}
	public void changeDepth(int depthnumber) {
		this.depth = new Integer(depthnumber);
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
	}
	void changeConnectpoint() {
	}
	public void paint(Graphics g) {
    }
	public void addShape(Shape s) {
	}
	public void addConnectline(ConnectionLine l) {
	}
	public void clearShape() {
	}
	public void clearConnectionLine() {
	}
	public Shape elementAtGroupShapes(int index) {
		return null;
	}
	public ConnectionLine elementAtGroupConnectlines(int index) {
		return null;
	}
	public int SizeGroupShapes() {
		return 0;
	}
	public int SizeGroupConnectlines() {
		return 0;
	}
	public void getPoint(Point p1, Point p2,Shape firstConnect, Shape secondConnect) {
	}
	public void clearlastdrag() {
		lastdrag = new Point();
	}
}
