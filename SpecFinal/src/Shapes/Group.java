package Shapes;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

public class Group extends Shape{
	Vector<Shape> GroupShapes;
	Vector<ConnectionLine> GroupConnectlines;
	Point p = new Point();
	Point lastdrag = new Point();
	Group(){
		GroupShapes = new Vector<Shape>();
		GroupConnectlines = new Vector<ConnectionLine>();
	}
	public Group(Point initialpoint, Point p){
		this.initialpoint = new Point(initialpoint);
		this.p = new Point(p);
		this.connectpoint[0] = new Point(p.x, initialpoint.y + (p.y - initialpoint.y) / 2);		//東
		this.connectpoint[1] = new Point(initialpoint.x + (p.x - initialpoint.x) / 2, p.y);		//南
		this.connectpoint[2] = new Point(initialpoint.x, initialpoint.y + (p.y - initialpoint.y) / 2);		//西
		this.connectpoint[3] = new Point(initialpoint.x + (p.x - initialpoint.x) / 2, initialpoint.y);		//北
		this.GroupShapes = new Vector<Shape>();
		this.GroupConnectlines = new Vector<ConnectionLine>();
	}
	public void addShape(Shape s) {
		GroupShapes.add(s);
	}
	public void addConnectline(ConnectionLine l) {
		GroupConnectlines.add(l);
	}
	public Shape elementAtGroupShapes(int index) {
		return GroupShapes.elementAt(index);
	}
	public ConnectionLine elementAtGroupConnectlines(int index) {
		return GroupConnectlines.elementAt(index);
	}
	public void clearShape() {
		GroupShapes.clear();
	}
	public void clearConnectionLine() {
		GroupConnectlines.clear();
	}
	void paintBorder(Graphics g) {
		g.drawLine(initialpoint.x, initialpoint.y, p.x, initialpoint.y);
		g.drawLine(initialpoint.x, initialpoint.y, initialpoint.x, p.y);
		g.drawLine(p.x, p.y, initialpoint.x, p.y);
		g.drawLine(p.x, p.y, p.x, initialpoint.y);
	}
	public boolean isInShape(Point t) {
		if(t.x <= p.x && t.x >= initialpoint.x 
		&& t.y <= p.y && t.y >= initialpoint.y) {
			return true;
		}else {
			return false;
		}
	}
	public void changePoints(Point dragpoint) {
		initialpoint.x = initialpoint.x + dragpoint.x - lastdrag.x;
		initialpoint.y = initialpoint.y + dragpoint.y - lastdrag.y;
		p.x = p.x + dragpoint.x - lastdrag.x;
		p.y = p.y + dragpoint.y - lastdrag.y;
		for(int i = 0; i < GroupShapes.size(); i++) {
			GroupShapes.elementAt(i).changePoints(dragpoint);
		}
		for(int i = 0; i < GroupConnectlines.size(); i++) {
			GroupConnectlines.elementAt(i).changePoints(dragpoint);
		}
		changeConnectpoint();
		lastdrag = new Point(dragpoint);
	}
	void changeConnectpoint() {
		this.connectpoint[0] = new Point(p.x, initialpoint.y + (p.y - initialpoint.y) / 2);		//東
		this.connectpoint[1] = new Point(initialpoint.x + (p.x - initialpoint.x) / 2, p.y);		//南
		this.connectpoint[2] = new Point(initialpoint.x, initialpoint.y + (p.y - initialpoint.y) / 2);		//西
		this.connectpoint[3] = new Point(initialpoint.x + (p.x - initialpoint.x) / 2, initialpoint.y);		//北
	}
	public void paint(Graphics g) {
		paintBorder(g);
		paintShape(g);
		paintConnectlines(g);
	}
	void paintShape(Graphics g) {
		for(int i = 0; i < GroupShapes.size(); i++) {
			GroupShapes.elementAt(i).paint(g);
    	}
	}
	void paintConnectlines(Graphics g) {
		for(int i = 0; i < GroupConnectlines.size(); i++) {
			GroupConnectlines.elementAt(i).paint(g);
    	}
	}
	public int SizeGroupShapes() {
		return GroupShapes.size();
	}
	public int SizeGroupConnectlines() {
		return GroupConnectlines.size();
	}
	public void clearlastdrag() {
		lastdrag = new Point();
		for(int i = 0; i < GroupShapes.size(); i++) {
			GroupShapes.elementAt(i).clearlastdrag();
    	}
		for(int i = 0; i < GroupConnectlines.size(); i++) {
			GroupConnectlines.elementAt(i).clearlastdrag();
    	}
	}
}
