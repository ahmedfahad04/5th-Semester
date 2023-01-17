package Refactored_Code_2;

import java.util.ArrayList;
import java.util.List;

public class TonerSaveMode extends PrintMode{

    private String tonerSavingLevel;
    private String colorIntensityLevel = "";

    private static final List<IColorIntensity> colorIntensityList = new ArrayList<>() {{
        new HighColorIntensity();
        new MediumColorIntensity();
        new LowColorIntensity();
    }};

    @Override
    public void applyConfiguration() {
        for(IColorIntensity intensity: colorIntensityList){
            if(intensity.matchColorIntensity(this.tonerSavingLevel))
                this.colorIntensityLevel = intensity.getColorIntensity();
        }
    }
}
