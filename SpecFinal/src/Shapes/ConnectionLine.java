package Shapes;
import java.awt.Graphics;
import java.awt.Point;

public class ConnectionLine extends Shape{
	public boolean isSelected = false;
	public boolean isFirstConnectMoved = false;
	public boolean isSecondConnectMoved = false;
	public Point[] p = new Point[2];
	public Shape firstConnect;
	public Shape secondConnect;
	Point lastdrag = new Point();
	public ConnectionLine(){
		
	}
	ConnectionLine(ConnectionLine l){
		this.p[0] = new Point(l.p[0]);
		this.p[1] = new Point(l.p[1]);
		this.firstConnect = l.firstConnect;
		this.secondConnect = l.secondConnect;			
		this.isSelected = l.isSelected;
		this.isFirstConnectMoved = l.isFirstConnectMoved;
		this.isSecondConnectMoved = l.isSecondConnectMoved;
	}
	ConnectionLine(Point p1, Point p2,Shape firstConnect, Shape secondConnect){
		this.p[0] = new Point(p1);
		this.p[1] = new Point(p2);
		this.firstConnect = firstConnect;
		this.secondConnect = secondConnect;
	}
	public void getPoint(Point p1, Point p2,Shape firstConnect, Shape secondConnect) {
		this.p[0] = new Point(p1);
		this.p[1] = new Point(p2);
		this.firstConnect = firstConnect;
		this.secondConnect = secondConnect;
	}
	public void paint(Graphics g) {
		
	}
	public double[] rotateVec(int px, int py, double ang, double newlen) {
		double mathstr[] = new double[2];
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		double d = Math.sqrt(vx * vx + vy * vy);
		vx = vx / d * newlen;
		vy = vy / d * newlen;
		mathstr[0] = vx;
		mathstr[1] = vy;
		return  mathstr;
	}
	public Point[] drawarrowline() {
		double H = 10;
	    double L = 7;
	    int x1 = p[0].x;
	    int y1 = p[0].y;
	    int x2 = p[1].x;
	    int y2 = p[1].y;
	    int x3 = 0;
	    int y3 = 0;
	    int x4 = 0;
	    int y4 = 0;
	    double awrad = Math.atan(L / H); 
	    double arraow_len = Math.sqrt(L * L + H * H);  
	    double[] arrXY_1 = rotateVec(x2 - x1, y2 - y1, awrad, arraow_len);
	    double[] arrXY_2 = rotateVec(x2 - x1, y2 - y1, - awrad, arraow_len);
	    double x_3 = x2 - arrXY_1[0];   
	    double y_3 = y2 - arrXY_1[1];
	    double x_4 = x2 - arrXY_2[0];   
	    double y_4 = y2 - arrXY_2[1];
	    Double X3 = new Double(x_3);
	    x3 = X3.intValue();
	    Double Y3 = new Double(y_3);
	    y3 = Y3.intValue();
	    Double X4 = new Double(x_4);
	    x4 = X4.intValue();
	    Double Y4 = new Double(y_4);
	    y4 = Y4.intValue();
	    Point[] rtPoint = new Point[2];
	    rtPoint[0] = new Point(x3, y3);
	    rtPoint[1] = new Point(x4, y4);
	    return rtPoint;
	}
	public void changePoints(Point tmp, Point dragpoint) {
		if(isFirstConnectMoved) {
			p[0].x = tmp.x + dragpoint.x;
			p[0].y = tmp.y + dragpoint.y;
			/*p[0].x = p[0].x + dragpoint.x - lastdrag.x;
			p[0].y = p[0].y + dragpoint.y - lastdrag.y;*/
		}
		else if(isSecondConnectMoved) {
			p[1].x = tmp.x + dragpoint.x;
			p[1].y = tmp.y + dragpoint.y;
			/*p[1].x = p[1].x + dragpoint.x - lastdrag.x;
			p[1].y = p[1].y + dragpoint.y - lastdrag.y;*/
		}
	}
	public void changePoints(Point dragpoint) {
		this.p[0].x = p[0].x + dragpoint.x - lastdrag.x;
		this.p[0].y = p[0].y + dragpoint.y - lastdrag.y;
		this.p[1].x = p[1].x + dragpoint.x - lastdrag.x;
		this.p[1].y = p[1].y + dragpoint.y - lastdrag.y;
		lastdrag = new Point(dragpoint);
		System.out.println("dragpoint:" + dragpoint);
		System.out.println("lastdrag:" + lastdrag);
		System.out.println("p[0]:" + p[0]);
		System.out.println("p[1]:" + p[1]);
	}
	public void clearlastdrag() {
		lastdrag = new Point();
	}
}
