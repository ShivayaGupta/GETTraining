package day3;

class Outer {
    private static String name;
    public static void printDetails() {
    	//this.name="Swapna";
    	System.out.println("Name:"+name);
    	
    }
    static class Inner{
    	private String innerName;
    	public void printDetailsOfInnerName() {
    		this.innerName="mithila";
    		System.out.println(innerName);
    	}
    }
    public static void main(String args[]) {
    	//Outer out = new Outer();
    //	out.printDetails();
    	//Outer.Inner in = new Outer().new Inner();
    	//in.printDetailsOfInnerName();
    	Outer.name="swapna moyupally"; 
    	Outer.name="fav";
    	Outer.printDetails();
    	Inner inner= new Inner();
    	inner.printDetailsOfInnerName();
    	
    }
}
