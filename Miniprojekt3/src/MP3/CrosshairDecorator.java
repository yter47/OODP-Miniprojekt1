package MP3;

import java.awt.Color;
import java.awt.Graphics;

public class CrosshairDecorator implements Shape {
	private Shape decoratee;
	
	public CrosshairDecorator(Shape decoratee) {
		this.decoratee = decoratee;
	}
	
	@Override
	public void draw(Graphics g) {
        decoratee.draw(g);

        Point position = decoratee.getPosition();
        double x = position.getX();
        double y = position.getY();
        double halfWidth = decoratee.getWidth() / 2.0;
        double halfHeight = decoratee.getHeight() / 2.0;

        g.setColor(Color.RED); 
        g.drawLine((int) (x - halfWidth), (int) y, (int) (x + halfWidth), (int) y);
        g.drawLine((int) x, (int) (y - halfHeight), (int) x, (int) (y + halfHeight));
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
