package mode;

import java.awt.Point;
import Shapes.Oval;

public class UseCaseMode extends Mode{
	UseCaseMode(){
		
	}
	public void onClick(Point p, PaintTube pt) {
		pt.depthNumber++;
		pt.tmpshape = new Oval(p);
		pt.tmpshape.changeDepth(pt.depthNumber);
		pt.Shapes.add(pt.tmpshape);
	}
}
