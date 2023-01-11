package Refactored_Code;

import java.util.ArrayList;
import java.util.List;

class MyPrintMode extends PrintMode {
    private String tonerSavingLevel;
    private String colorIntensityLevel = "";


    private static final List<IColorIntensity> colorIntensityList = new ArrayList<>() {{
        new HighColorIntensity();
        new MediumColorIntensity();
        new LowColorIntensity();
    }};

    public void saveToner() {
        for(IColorIntensity intensity: colorIntensityList){
            if(intensity.matchColorIntensity(this.tonerSavingLevel))
                this.colorIntensityLevel = intensity.getResponse();
        }
    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {

    }
}
