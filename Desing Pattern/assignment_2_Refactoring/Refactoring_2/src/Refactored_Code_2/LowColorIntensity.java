package Refactored_Code_2;

public class LowColorIntensity implements IColorIntensity {

    @Override
    public boolean matchColorIntensity(String tonerSavingLevel) {
        return tonerSavingLevel.equalsIgnoreCase("low");
    }

    @Override
    public String getColorIntensity() {
        return "low Color Intensity";
    }
}
