interface LightAction {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        LightAction motionTrigger = () -> System.out.println("Lights ON: Motion detected!");
        LightAction nightTrigger = () -> System.out.println("Lights ON: Night mode pattern!");
        LightAction voiceTrigger = () -> System.out.println("Lights ON: Voice command pattern!");

        motionTrigger.activate();
        nightTrigger.activate();
        voiceTrigger.activate();
    }
}
