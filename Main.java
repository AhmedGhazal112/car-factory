public class Main{
    public static void main(String[] args) {
        GasEngine gasEngine = new GasEngine();
        ElectericalEngine electericalEngine = new ElectericalEngine();
        Car eCar = Factory.createCar(electericalEngine);
        eCar.start();
        eCar.accelerate();
        // should throw an error because the car speed is not 0
        eCar.stop();

        System.out.println("-------------");

        Car gCar = Factory.createCar(gasEngine);
        gCar.start();
        for(int i = 0; i < 11; i++) {
            gCar.accelerate();
        }
        for(int i = 0; i < 11; i++) {
            gCar.brake();
        }
        gCar.stop();
        Factory.replaceEngine(gCar, electericalEngine);

        System.out.println("-------------");

        Car hybirdCar = Factory.createCar(electericalEngine, gasEngine);
        hybirdCar.start();
        // this will throw an exception because the car is already started
        hybirdCar.start();
        hybirdCar.accelerate();
        hybirdCar.accelerate();
        // speed is 40, active engine should be electerical engine
        hybirdCar.activeEngine();
        hybirdCar.accelerate();
        // speed is 60, active engine should be gas engine
        hybirdCar.activeEngine();
        hybirdCar.brake();
        // speed is 40, active engine should return to electerical engine
        hybirdCar.activeEngine();
        hybirdCar.brake();
        hybirdCar.brake();
        hybirdCar.stop();
        // this will throw an exception because the car is already stopped
        hybirdCar.stop();
    }
}