public class Factory {
    public static Car createCar(Engine engine) {
        EngineManager engineManager = new EngineManager(engine);
        return new Car(engineManager);
    }
    public static Car createCar(Engine firstEngine, Engine secondEngine) {
        EngineManager engineManager = new EngineManager(firstEngine, secondEngine);
        return new Car(engineManager);
    }
    public static Car replaceEngine(Car car, Engine newEngine) {
        EngineManager engineManager = new EngineManager(newEngine);
        System.out.println("Engine is replaced");
        return new Car(engineManager);
    }
}
