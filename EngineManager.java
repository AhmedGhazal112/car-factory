public class EngineManager {
    private GasEngine gasEngine;
    private ElectericalEngine electericalEngine;
    EngineManager(Engine engine){
        if (engine instanceof GasEngine) {
            gasEngine = (GasEngine) engine;
        } else {
            electericalEngine = (ElectericalEngine) engine;
        }
    }

    EngineManager(Engine firstEngine, Engine secondEngine){
        if (firstEngine instanceof GasEngine) {
            gasEngine = (GasEngine) firstEngine;
            electericalEngine = (ElectericalEngine) secondEngine;
        } else {
            electericalEngine = (ElectericalEngine) firstEngine;
            gasEngine = (GasEngine) secondEngine;
        }
    }

    public void start() {
        if(electericalEngine != null) {
            electericalEngine.start();
            return;
        }
        gasEngine.start();
    }

    public void stop() {
        if(electericalEngine != null) {
            electericalEngine.stop();
            return;
        }
        gasEngine.stop();
    }

    public Integer accelerate(Integer carSpeed) {
        carSpeed = Math.min(carSpeed + 20, 200);
        if(electericalEngine != null && gasEngine != null) {
            System.out.println(carSpeed);
            if(carSpeed >= 50 && electericalEngine.isRunning()) {
                gasEngine.start();
                electericalEngine.stop();
            }
        }
        return carSpeed;
    }

    public Integer brake(Integer carSpeed) {
        carSpeed = Math.max(carSpeed - 20, 0);
        if(electericalEngine != null && gasEngine != null) {
            if(carSpeed < 50 && gasEngine.isRunning()) {
                electericalEngine.start();
                gasEngine.stop();
            }
        }
        return carSpeed;
    }
    public void activeEngine() {
        if(electericalEngine != null && electericalEngine.isRunning()) {
            System.out.println("Electerical Engine");
            return;
        }
        if(gasEngine != null && gasEngine.isRunning()) {
            System.out.println("Gas Engine");
            return;
        }
        System.out.println("No engine is active");
    }
}
