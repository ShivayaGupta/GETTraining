package Day4.cars.management;


public class PetrolCar extends Car implements AddOns {

	@Override
	public void engineType() {
		System.out.println("Petrol Variant");
	}

	@Override
	public void audioSystem() {
		System.out.println("Audio System with 6 speakers, woofers enabled");
	}

	public PetrolCar(String model) {
		super(model);
	}
	
}