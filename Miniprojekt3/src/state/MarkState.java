package state;

import MP3.CrosshairDecorator;
import MP3.MarkTypes;
import MP3.Point;
import MP3.Shape;
import MP3.ShapeContainer;
import MP3.ShapeDecorator;

public class MarkState implements State {

	@Override
	public void pointerDown(Point point, ShapeContainer shapeContainer) {
		shapeContainer.select(point);
		Shape selected = shapeContainer.getSelected();
		if (selected != null) {
	        MarkTypes markType = shapeContainer.getMarkType();
	        Shape markedShape = decorateSelectedShape(selected, markType);
	        shapeContainer.removeShape(selected);
	        shapeContainer.addShape(markedShape);
	    }
	}
	
	private Shape decorateSelectedShape(Shape selected, MarkTypes markType) {
	    switch (markType) {
	        case FILL:
	            return new ShapeDecorator(selected);
	        
	        case CROSSHAIR:
	            return new CrosshairDecorator(selected);
	         
	        default:
	            throw new IllegalArgumentException("Unsupported mark type: " + markType);
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
