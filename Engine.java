public class Engine {
    private Boolean running;
    private Integer internalSpeed;
    Engine() {
        running = false;
        this.internalSpeed = 0;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public Boolean isRunning() {
        return running;
    }

    public void increase(){
        internalSpeed++;
    }
    public void decrease(){
        if(internalSpeed > 0) {
            internalSpeed--;
        }
    }
}
