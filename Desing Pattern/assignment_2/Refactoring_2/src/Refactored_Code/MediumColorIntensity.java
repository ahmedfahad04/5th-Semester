package Refactored_Code;

public class MediumColorIntensity implements IColorIntensity{

    @Override
    public boolean matchColorIntensity(String tonerSavingLevel) {
        return tonerSavingLevel.equalsIgnoreCase("medium");
    }

    @Override
    public String getResponse() {
        return "Medium Color Intensity";
    }
}
