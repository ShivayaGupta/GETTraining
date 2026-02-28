package Day4.cars.management;

public class DiselCar extends Car implements AddOns{

	@Override
	public void audioSystem() {
		// TODO Auto-generated method stub
		System.out.println("Audio System with 8 speakers, woofers enabled");
	}

	

	public DiselCar(String model) {
		super(model);
	}
@Override
	public void engineType() {
		System.out.println("engine type is disel");
		
	}
    
}
