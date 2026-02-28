package day3Shape;

public class Square implements Shape{
    private int side;

	public Square() {
		super();
	}

	public Square(int side) {
		super();
		this.side = side;
	}
	@Override
    public void area() {
	   System.out.println(side*side);
	}
	public void circum() {
		System.out.println(4*side);
	}
}
