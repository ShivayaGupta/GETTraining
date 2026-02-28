package day3;

public class Calculator implements SimpleCalculator , ScientificCal{
	@Override
	public int add(int a,int b) {
		return a+b;
	}
	@Override
	public int sub(int a,int b) {
		return a-b;
	}
	@Override

	public int mul(int a,int b) {
		return a*b;
	}
	@Override
	public float div(int a,int b) {
		return (float)a/b;
	}
	@Override
	public double pow(int a ,int b) {
		return Math.pow(a, b);
	}
	@Override
	public double sqroot(int a) {
		return Math.sqrt(a);
	}

}
