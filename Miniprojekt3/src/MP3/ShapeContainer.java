package MP3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import state.InsertState;
import state.State;

public class ShapeContainer extends JPanel implements Pointable {
	private static final long serialVersionUID = 1L;
	private List<Shape> shapes = new LinkedList<Shape>();
	private State currentState;
	private Shape selected;
	private ShapeTypes currentShape;
	private MarkTypes markType;

	public ShapeContainer() {
		super();
		this.currentState = new InsertState();
		this.currentShape = ShapeTypes.CIRCLE;
		this.markType = MarkTypes.FILL;
		MouseHandler mouseHandler = new MouseHandler(this);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.setBackground(Color.white);
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : shapes)
			shape.draw(g);
	}

	public void select(Point point) {
		for (Shape shape : shapes) {
			if (shape.intersects(point)) {
				selected = shape;
				return;
			}
		}
		selected = null;
	}

	public void pointerDown(Point point) {
		currentState.pointerDown(point, this);
	}

	public void pointerUp(Point point) {
		currentState.pointerUp(point, this);
	}

	public void pointerMoved(Point point, boolean pointerDown) {
		currentState.pointerMoved(point, this, pointerDown);
	}

	public void setState(State state) {
		this.currentState = state;
	}

	public void setSelected(Shape selected) {
		this.selected = selected;
	}

	public Shape getSelected() {
		return this.selected;
	}

	public List<Shape> getShapes() {
		return this.shapes;
	}

	public void removeShape(Shape shape) {
		shapes.remove(shape);
		repaint();
	}

	public void setShape(ShapeTypes shapeType) {
		if (shapeType == ShapeTypes.CIRCLE) {
			this.currentShape = ShapeTypes.CIRCLE;
		} else
			this.currentShape = ShapeTypes.RECTANGLE;
	}

	public ShapeTypes getShape() {
		return this.currentShape;
	}

	public void setMarkType(MarkTypes markType) {
		if (markType == MarkTypes.FILL) {
			this.markType = MarkTypes.FILL;
		} else
			this.markType = MarkTypes.CROSSHAIR;
	}

	public MarkTypes getMarkType() {
		return this.markType;
	}
}
