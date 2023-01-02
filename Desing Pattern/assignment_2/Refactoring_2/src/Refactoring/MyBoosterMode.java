package Refactoring;

public class MyBoosterMode extends PrintMode {

    private String intensityThreshold;

    @Override
    public void saveToner() {

    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {
        System.out.println("Intensity increased by maximum acceptable level.");
    }
}
