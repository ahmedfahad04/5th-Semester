package Refactored_Code_2;

/*
The BoosterMode increases the color intensity up to a maximum acceptable level that is set via its intensityThreshold field.
 */

public class BoosterMode extends PrintMode {

    private String intensityThreshold;

    @Override
    public void applyConfiguration() {
        System.out.println("Intensity increased by maximum acceptable level.");
    }
}
