public class Car {
    private Boolean running;
    private Integer speed;
    private EngineManager engineManager;

    Car(EngineManager engineManager){
        running = false;
        speed = 0;
        this.engineManager = engineManager;
    }

    public void start() {
        if(running) {
            System.out.println("Car is already running");
            return;
        }
        engineManager.start();
        speed = 0;
        running = true;
    }

    public void stop() {
        try{
            if(!running) {
                throw new Exception("Car is already stopped");
            }
            if(speed > 0) {
                throw new Exception("Car speed should be 0 to stop");
            }
            engineManager.stop();
            running = false;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void accelerate() {
        speed = engineManager.accelerate(speed);
    }
    public void brake() {
        speed = engineManager.brake(speed);
    }

    public void activeEngine() {
        engineManager.activeEngine();
    }
}
