package state;

import MP3.Point;
import MP3.Shape;
import MP3.ShapeContainer;

public class UnmarkState implements State {

	@Override
	public void pointerDown(Point point, ShapeContainer shapeContainer) {
		shapeContainer.select(point);
		Shape selected = shapeContainer.getSelected();
		if (selected != null) {
			Shape unmarkedShape = selected.peel();
			shapeContainer.removeShape(selected);
			shapeContainer.addShape(unmarkedShape);
		}
	}

	@Override
	public void pointerUp(Point point, ShapeContainer shapeContainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pointerMoved(Point point, ShapeContainer shapeContainer, boolean pointerDown) {
		// TODO Auto-generated method stub
		
	}

}
