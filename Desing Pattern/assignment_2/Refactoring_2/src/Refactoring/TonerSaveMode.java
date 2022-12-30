package Refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TonerSaveMode extends PrintMode{

    private static List<IColorIntensity> colorIntensityList = new ArrayList<>() {{
        new HighColorIntensity();
        new MediumColorIntensity();
        new LowColorIntensity();
    }};

    private String tonerSavingLevel;
    private String colorIntensityLevel = "";

    @Override
    public void saveToner() {

        // duplicate code
        // solve with strategy pattern

        for(IColorIntensity intensity: colorIntensityList){
            if(intensity.matchColorIntensity(this.tonerSavingLevel))
                colorIntensityLevel = intensity.getResponse();
        }
    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {

    }
}
