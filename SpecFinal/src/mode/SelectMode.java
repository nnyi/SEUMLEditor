package mode;

import java.awt.Point;

public class SelectMode extends Mode{
	SelectMode(){
		
	}
	public void onClick(Point p, PaintTube pt) {
		pt.cancelAllSelected();
		int SeleNum = 0;
        for(int i = 0; i < pt.Shapes.size(); i++) {
        	if(pt.Shapes.elementAt(i).isInShape(p) && SeleNum == 0) {
        		pt.Shapes.elementAt(i).isSelected = true;
        		pt.tmpshape = pt.Shapes.elementAt(i);
        		SeleNum++;
        	}else {
        		pt.Shapes.elementAt(i).isSelected = false;
        	}
        }
	}
	public void onPressed(Point p,PaintTube pt) {
		System.out.println("Pressed");
		pt.cancelAllSelected();
		pt.firstpoint = new Point(p);
		pt.tmpshape = pt.PointInWhichShape(pt.firstpoint);
		if(pt.tmpshape != null) {
			pt.Dragflag = true;
			pt.checkConnectlinesMoved(pt.tmpshape);
			pt.getAllMovedLine();
		}
	}
	public void onReleased(Point p, PaintTube pt) {
		System.out.println("Released");
		pt.cancelAllSelected();
		pt.secondpoint = new Point(p);
		if(pt.Dragflag) {
			pt.dragpoint = new Point(pt.secondpoint.x - pt.firstpoint.x,pt.secondpoint.y - pt.firstpoint.y);
			pt.tmpshape.changePoints(pt.dragpoint);
			pt.chageConnectionlines(pt.dragpoint);
			pt.clearAlllastdrag();
			pt.tmp.clear();
			pt.cancelConnectlinesMoved();
			pt.Dragflag = false;
		}else if(!pt.Dragflag) {
			pt.checkArea(pt.firstpoint, pt.secondpoint);
		}
	}
	public void onDragged(Point p, PaintTube pt) {
		System.out.println("Dragged");
		pt.cancelAllSelected();
		if(pt.Dragflag) {
			pt.dragpoint = new Point(p.x - pt.firstpoint.x,p.y - pt.firstpoint.y);
			pt.tmpshape.changePoints(pt.dragpoint);
			pt.chageConnectionlines(pt.dragpoint);
		}
	}
	void settitle(String str, PaintTube pt) {
		pt.tmpshape.setTitle(str);
	}
}
