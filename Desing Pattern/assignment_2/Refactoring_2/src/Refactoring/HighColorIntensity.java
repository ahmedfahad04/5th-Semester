package Refactoring;

public class HighColorIntensity implements IColorIntensity{

    @Override
    public boolean matchColorIntensity(String tonerSavingLevel) {
        return tonerSavingLevel.equalsIgnoreCase("high");
    }

    @Override
    public String getResponse() {
        return "High Color Intensity";
    }
}
