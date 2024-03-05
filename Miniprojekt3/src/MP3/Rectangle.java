package MP3;

import java.awt.Graphics;

public class Rectangle implements Shape {

	private Point pos;
	private double width;
	private double height;

	public Rectangle() {

	}

	public Rectangle(double x, double y, double width, double height) {
		this.pos = new Point(x, y);
		this.height = height;
		this.width = width;
	}

	public Rectangle(Point point, double width, double height) {
		this(point.getX(), point.getY(), width, height);
	}

	@Override
	public void draw(Graphics g) {
	    int x = (int) (pos.getX() - this.width / 2);
	    int y = (int) (pos.getY() - this.height / 2);
	    g.drawRect(x, y, (int) this.width, (int) this.height);
	}

	@Override
	public Point getPosition() {
		return pos;
	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
    public boolean intersects(Point point) {
        double centerX = pos.getX() + this.width / 2;
        double centerY = pos.getY() + this.height / 2;

        // Define a threshold for how close the pointer needs to be to the center
        double halfWidth = this.width / 2;
        double halfHeight = this.height / 2;
        double thresholdX = halfWidth * 1.5; // Adjust as needed
        double thresholdY = halfHeight * 1.5; // Adjust as needed

        // Check if the pointer is within the threshold distance from the center
        return Math.abs(point.getX() - centerX) <= thresholdX && Math.abs(point.getY() - centerY) <= thresholdY;
    }

	@Override
	public void moveTo(Point point) {
        pos.moveTo(point);
	}

	@Override
	public void move(double dx, double dy) {
		pos.move(dx, dy);

	}

	@Override
	public void resizeTo(Point point) {
		double newWidth = Math.abs(pos.getX() - point.getX());
		double newHeight = Math.abs(pos.getY() - point.getY());
		
		if(newWidth > 0 && newHeight > 0) {
			this.width = newWidth;
			this.height = newHeight;
		}
	}

	@Override
	public Shape peel() {
		return this;
	}

}
