package Day4.cars.management;

public class CarsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       PetrolCar pcar = new PetrolCar("swift");
       pcar.engineType();
       pcar.audioSystem();
       pcar.roofOpen();
       pcar.showModel();
       DiselCar dcar = new DiselCar("swift");
       dcar.engineType();
       dcar.audioSystem();
       dcar.roofOpen();
       dcar.showModel();
       
       
	}

}
