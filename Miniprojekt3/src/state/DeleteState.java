package state;

import MP3.Point;
import MP3.Shape;
import MP3.ShapeContainer;

public class DeleteState implements State{

	@Override
	public void pointerDown(Point point, ShapeContainer shapeContainer) {
		shapeContainer.select(point);
		Shape shapeToDelete = shapeContainer.getSelected();
		if(shapeToDelete != null) {
			shapeContainer.removeShape(shapeToDelete);
			shapeContainer.setSelected(null);
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
