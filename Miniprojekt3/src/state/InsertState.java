package state;

import MP3.Circle;
import MP3.Point;
import MP3.Rectangle;
import MP3.ShapeContainer;
import MP3.ShapeTypes;

public class InsertState implements State{

	@Override
	public void pointerDown(Point point, ShapeContainer shapeContainer) {
		ShapeTypes currentShape = shapeContainer.getShape();
		switch (currentShape) {
			case CIRCLE:
				shapeContainer.addShape(new Circle(point, Math.random() * 50.0));
				break;
			case RECTANGLE:
				shapeContainer.addShape(new Rectangle(point, (Math.random() * 50.0), Math.random() * 50.0));
				break;
			default:
                throw new IllegalArgumentException("Unsupported shape type: " + currentShape);
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
