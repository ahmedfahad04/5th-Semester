package Refactored_Code;

public class LowColorIntensity implements IColorIntensity{

    @Override
    public boolean matchColorIntensity(String tonerSavingLevel) {
        return tonerSavingLevel.equalsIgnoreCase("low");
    }

    @Override
    public String getResponse() {
        return "low Color Intensity";
    }
}
