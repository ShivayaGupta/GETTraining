package Day4.cars.management;

public class GasCar extends Car implements AddOns{

	@Override
	public void engineType() {
		System.out.println("System type is gas car");
		
	}

	@Override
	public void audioSystem() {
		// TODO Auto-generated method stub
		
		System.out.println("audio system is with 8 speakers,2 woofers added");
	}

	public GasCar(String model) {
		super(model);
	}

	

}
