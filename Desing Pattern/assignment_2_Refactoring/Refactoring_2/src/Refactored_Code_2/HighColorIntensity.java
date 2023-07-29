package Refactored_Code_2;

public class HighColorIntensity implements IColorIntensity {

    @Override
    public boolean matchColorIntensity(String tonerSavingLevel) {
        return tonerSavingLevel.equalsIgnoreCase("high");
    }

    @Override
    public String getColorIntensity() {
        return "High Color Intensity";
    }
}
