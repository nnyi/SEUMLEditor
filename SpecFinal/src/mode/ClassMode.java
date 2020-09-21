package mode;

import java.awt.Point;
import Shapes.Rectangle;

public class ClassMode extends Mode{
	ClassMode(){
		
	}
	public void onClick(Point p, PaintTube pt) {
		pt.depthNumber++;
		pt.tmpshape = new Rectangle(p);
		pt.tmpshape.changeDepth(pt.depthNumber);
		pt.Shapes.add(pt.tmpshape);
	}
}
