package BasicRequirements;

import java.util.Objects;

public class TonerSaveMode extends PrintMode{

    private String tonerSavingLevel;

    @Override
    public void saveToner() {

        //  duplicate code
        // solve with strategy pattern
        if (Objects.equals(tonerSavingLevel, "high"))
            System.out.println("Color intensity is reduced by following a well-known standard algorithm.");
        else if (Objects.equals(tonerSavingLevel, "medium"))
            System.out.println("Color intensity is reduced by following a well-known standard algorithm.");
        else if (Objects.equals(tonerSavingLevel, "low"))
            System.out.println("Color intensity is reduced by following a well-known standard algorithm.");
    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {

    }
}
