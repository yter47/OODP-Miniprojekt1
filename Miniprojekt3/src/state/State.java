package state;

import MP3.Point;
import MP3.ShapeContainer;

public interface State {
	void pointerDown(Point point, ShapeContainer shapeContainer);
	void pointerUp(Point point, ShapeContainer shapeContainer);
	void pointerMoved(Point point, ShapeContainer shapeContainer, boolean pointerDown);
}
