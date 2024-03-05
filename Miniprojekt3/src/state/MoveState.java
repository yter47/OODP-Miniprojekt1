package state;

import MP3.Point;
import MP3.Shape;
import MP3.ShapeContainer;

public class MoveState implements State {

	@Override
	public void pointerDown(Point point, ShapeContainer shapeContainer) {
		shapeContainer.select(point);
	}

	@Override
	public void pointerUp(Point point, ShapeContainer shapeContainer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pointerMoved(Point point, ShapeContainer shapeContainer, boolean pointerDown) {
		if (pointerDown) {
			Shape selected = shapeContainer.getSelected();
			if (selected != null) {
				selected.moveTo(point);
				shapeContainer.repaint();
			}
		}
	}
}
