package Refactored_Code_2;

public class Temp {

    private String orientation;
    private String colorIntensity;
    private double costPerPage;

    public int getNumberOfPage() {
        return new Document().numberOfPage;
    }

    public int getPageSize() {
        return new Document().pageSize;
    }

    private final TonerSaveMode tonerSaveMode = new TonerSaveMode();
    private final BoosterMode boosterMode = new BoosterMode();
    private final PageSaveMode pageSaveMode = new PageSaveMode();

    public void saveToner(){
        tonerSaveMode.saveToner();
    }
    public void savePage(){
        pageSaveMode.savePage();
    }
    public void boost(){
        boosterMode.boost();
    }


}
