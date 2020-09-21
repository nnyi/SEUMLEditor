package mode;

import java.awt.Point;
import java.util.Vector;
import Shapes.ConnectionLine;
import Shapes.Group;
import Shapes.Shape;

public class PaintTube {
	Vector<Shape> Shapes;
	Vector<ConnectionLine> Connectlines, tmpCt;
	Point firstpoint, secondpoint, dragpoint;
	Shape tmpshape, firstConnectshape, secondConnectshape;
	Vector<Point> tmp;
	boolean isInitalInShape = false, Dragflag = false;;
	int depthNumber = 0;
	public PaintTube(){
		Shapes = new Vector<Shape>();
		Connectlines = new Vector<ConnectionLine>();
		tmp = new Vector<Point>();
		tmpCt = new Vector<ConnectionLine>();
	}
	public Vector<Shape> getShapes() {
		return Shapes;
	}
	public Vector<ConnectionLine> getConnectlines() {
		return Connectlines;
	}
	void cancelAllSelected() {
		for(int i = 0; i < Shapes.size();i++) {
			Shapes.elementAt(i).isSelected = false;
		}
		for(int i = 0; i < Connectlines.size();i++) {
			Connectlines.elementAt(i).isSelected = false;
		}
	}
	void checkConnectlinesMoved(Shape s) {
		if(Connectlines.isEmpty()) {
		}else {
			for(int i = 0; i < Connectlines.size(); i++) {
				if(s.depth == Connectlines.elementAt(i).firstConnect.depth) {
					Connectlines.elementAt(i).isFirstConnectMoved = true;
				}
				else if(s.depth == Connectlines.elementAt(i).secondConnect.depth){
					Connectlines.elementAt(i).isSecondConnectMoved = true;
				}
			}
		}
	}
	Shape PointInWhichShape(Point p) {
		for(int i = 0; i < Shapes.size();i++) {
			if(Shapes.elementAt(i).isInShape(p)) {
				return Shapes.elementAt(i);
			}
		}
		tmpshape = null;
		return tmpshape;
	}
	void getAllMovedLine() {
		if(Connectlines.isEmpty()) {
			
		}else {
			for(int i = 0; i < Connectlines.size(); i++) {
				if(Connectlines.elementAt(i).isFirstConnectMoved) {
					tmp.add(new Point(Connectlines.elementAt(i).p[0]));
				}
				else if(Connectlines.elementAt(i).isSecondConnectMoved) {
					tmp.add(new Point(Connectlines.elementAt(i).p[1]));
				}
			}
		}
	}
	void chageConnectionlines(Point dragpoint) {
		if(Connectlines.isEmpty()) {
			System.out.println("づ");
		}else {
			int  p = 0;
			for(int i = 0; i < Connectlines.size();i++) {
				if(Connectlines.elementAt(i).isFirstConnectMoved) {
					Connectlines.elementAt(i).changePoints(tmp.elementAt(p), dragpoint);
					p++;
				}else if(Connectlines.elementAt(i).isSecondConnectMoved) {
					Connectlines.elementAt(i).changePoints(tmp.elementAt(p), dragpoint);
					p++;
				}
			}
		}
	}
	void clearAlllastdrag() {
		for(int i = 0; i < Shapes.size();i++) {
			Shapes.elementAt(i).clearlastdrag();
		}
		for(int i = 0; i < Connectlines.size();i++) {
			Connectlines.elementAt(i).clearlastdrag();
		}
	}
	void cancelConnectlinesMoved() {
		for(ConnectionLine l: Connectlines) {
			if(l.isFirstConnectMoved) {
				l.isFirstConnectMoved = false;
			}
			else if(l.isSecondConnectMoved){
				l.isSecondConnectMoved = false;
			}
		}
	}
	void checkArea(Point p1, Point p2){
		cancelAllSelected();
		for(int i = 0; i < Shapes.size();i++) {
			if(p1.x <= Shapes.elementAt(i).initialpoint.x && p1.y <= Shapes.elementAt(i).initialpoint.y && 
			p2.x >= Shapes.elementAt(i).initialpoint.x + Shapes.elementAt(i).width && p2.y >= Shapes.elementAt(i).initialpoint.y + Shapes.elementAt(i).height) {
				Shapes.elementAt(i).isSelected = true;
			}
		}
		for(int i = 0; i < Connectlines.size();i++) {
			if(p1.x <=Connectlines.elementAt(i).p[0].x && p1.y <= Connectlines.elementAt(i).p[0].y 
			&& p1.x <=Connectlines.elementAt(i).p[1].x && p1.y <= Connectlines.elementAt(i).p[1].y 
			&& p2.x >=Connectlines.elementAt(i).p[0].x && p2.y >= Connectlines.elementAt(i).p[0].y
			&& p2.x >=Connectlines.elementAt(i).p[1].x && p2.y >= Connectlines.elementAt(i).p[1].y) {
				Connectlines.elementAt(i).isSelected = true;
				System.out.println("┳�[퐑1");
			}
		}
	}
	public void settitle(String str) {
		tmpshape.setTitle(str);
	}
	public void Group() {
		int SelectNumber = 0;
		for(int i = 0; i < Shapes.size();i++) {
			if(Shapes.elementAt(i).isSelected) {
				SelectNumber++;
			}
		}
		if(SelectNumber > 1) {
			tmpshape = new Group(firstpoint, secondpoint);
			for(int i = 0; i < Shapes.size();i++) {
				if(Shapes.elementAt(i).isSelected) {
					Shapes.elementAt(i).isSelected = false;
					tmpshape.addShape(Shapes.elementAt(i));
				}
			}
			for(int i = 0; i < Connectlines.size();i++) {
				if(Connectlines.elementAt(i).isSelected) {
					Connectlines.elementAt(i).isSelected = false;
					tmpshape.addConnectline(Connectlines.elementAt(i));
					System.out.println("┳�[퐑2");
				}
			}
			for(int i = 0; i < tmpshape.SizeGroupShapes();i++) {
				Shapes.remove(tmpshape.elementAtGroupShapes(i));
			}
			for(int i = 0; i < tmpshape.SizeGroupConnectlines();i++) {
				Connectlines.remove(tmpshape.elementAtGroupConnectlines(i));
				System.out.println("┳쬟퐑1");
			}
			Shapes.add(tmpshape);
		}
	}
	public void unGroup() {
		if(tmpshape != null && tmpshape instanceof Group) {
			for(int i = 0; i < tmpshape.SizeGroupShapes();i++) {
				Shapes.add(tmpshape.elementAtGroupShapes(i));
			}
			for(int i = 0; i < tmpshape.SizeGroupConnectlines();i++) {
				Connectlines.add(tmpshape.elementAtGroupConnectlines(i));
			}
			tmpshape.clearShape();
			tmpshape.clearConnectionLine();
			removeLineOfGroup();
			Shapes.remove(tmpshape);
			System.out.println("tmpshape ungroup");
		}
	}
	void removeLineOfGroup() {
		for(int i = 0; i < Connectlines.size();i++) {
			if(Connectlines.elementAt(i).firstConnect.equals(tmpshape) 
				|| Connectlines.elementAt(i).secondConnect.equals(tmpshape)) {
				System.out.println("group ┳퐑:" + i);
				tmpCt.add(Connectlines.elementAt(i));
			}
		}
		for(int i = 0; i < tmpCt.size();i++) {
			Connectlines.remove(tmpCt.elementAt(i));
		}
		tmpCt.clear();
	}
}
