package Refactored_Code_2;

public class MediumColorIntensity implements IColorIntensity {

    @Override
    public boolean matchColorIntensity(String tonerSavingLevel) {
        return tonerSavingLevel.equalsIgnoreCase("medium");
    }

    @Override
    public String getColorIntensity() {
        return "Medium Color Intensity";
    }
}
