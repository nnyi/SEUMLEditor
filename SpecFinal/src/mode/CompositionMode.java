package mode;

import java.awt.Point;
import Shapes.Compositeline;
import Shapes.ConnectionLine;

public class CompositionMode extends Mode{
	CompositionMode(){
		
	}
	public void onPressed(Point p, PaintTube pt) {
		checkfirstpoint(p, pt);
	}
	public void onReleased(Point p, PaintTube pt) {
		checksecondpoint(p, pt);
	}
	void checkfirstpoint(Point p, PaintTube pt) {
		for(int i = 0; i < pt.Shapes.size();i++) {
			pt.firstConnectshape = pt.Shapes.elementAt(i);
			if(pt.firstConnectshape.isInShape(p)) {
				pt.isInitalInShape = pt.firstConnectshape.isInShape(p);
				pt.firstpoint = pt.firstConnectshape.nearestconnect(p);
				break;
			}
		}
	}
	void checksecondpoint(Point p, PaintTube pt) {
		for(int i = 0; i < pt.Shapes.size();i++) {
			pt.secondConnectshape = pt.Shapes.elementAt(i);
			if(pt.secondConnectshape.isInShape(p) && pt.isInitalInShape && !pt.firstConnectshape.equals(pt.secondConnectshape)) {
				pt.secondpoint = pt.secondConnectshape.nearestconnect(p);
				pt.tmpshape = new Compositeline(pt.firstpoint, pt.secondpoint, pt.firstConnectshape, pt.secondConnectshape);
				pt.Connectlines.add((ConnectionLine) pt.tmpshape);
				pt.isInitalInShape = false;
				break;
			}
		}
	}
}
