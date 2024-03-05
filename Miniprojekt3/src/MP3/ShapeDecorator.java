package MP3;

import java.awt.Color;
import java.awt.Graphics;

public class ShapeDecorator implements Shape {
	private Shape decoratee;

	public ShapeDecorator(Shape decoratee) {
		this.decoratee = decoratee;
	}

	@Override
	public void draw(Graphics g) {
        decoratee.draw(g);

        if(decoratee instanceof Circle) {
            g.setColor(Color.BLUE); 
            g.fillOval((int) (decoratee.getPosition().getX() - decoratee.getWidth() / 2.0),
                       (int) (decoratee.getPosition().getY() - decoratee.getHeight() / 2.0),
                       (int) decoratee.getWidth(), (int) decoratee.getHeight());
        } else if (decoratee instanceof Rectangle) {
        	g.setColor(Color.GREEN);
        	g.fillRect((int) (decoratee.getPosition().getX() - decoratee.getWidth() / 2.0),
        	           (int) (decoratee.getPosition().getY() - decoratee.getHeight() / 2.0),
        	           (int) decoratee.getWidth(), (int) decoratee.getHeight());

        }

    }

	@Override
	public Point getPosition() {
		return decoratee.getPosition();
	}

	@Override
	public double getWidth() {
		return decoratee.getWidth();
	}

	@Override
	public double getHeight() {
		return decoratee.getHeight();
	}

	@Override
	public boolean intersects(Point point) {
		return decoratee.intersects(point);
	}

	@Override
	public void moveTo(Point point) {
		decoratee.moveTo(point);
	}

	@Override
	public void move(double dx, double dy) {
		decoratee.move(dx, dy);
	}

	@Override
	public void resizeTo(Point point) {
		decoratee.resizeTo(point);
	}

	@Override
	public Shape peel() {
		return decoratee;
	}
}
