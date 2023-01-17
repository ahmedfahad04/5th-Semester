package Refactored_Code;

/*
TonerSaveMode additionally contains a field named tonerSavingLevel. 
In the saveToner method, if tonerSavingLevel is set high, color intensity is reduced by following a well-known standard algorithm. 
Similarly, if tonerSavingLevel is medium and low, two different algorithms are used to reduce color intensity. In the PageSaveMode, 
a single algorithm is used to adjust page size and orientation in a way that the number of pages required is reduced.
 */

/*
    1. Duplicate Code [resolve: strategy Pattern]
    {if-else ladder in saveToner() of TonerSaveMode}

    2. Refused Bequest [resolve: Replace inheritance with delegation]
    {boost(), savePage() in TonerSaveMode; saveToner(), savePage() in BoosterMode;
     saveToner(), boost() in PageSaveMode}

    3. Primitive Obsession [resolve: Replace Data with value object]
    {int numberOfPage, int pageSize in PrintMode}

    4. Black Sheep [resolve: Move Method]
    {changePriority() in PrintJob}

    5. Feature Envy [resolve: Move Method]
    {changePriority() in PrintJob}

 */


public abstract class PrintMode {

    private String orientation;
    private String colorIntensity;
    private double costPerPage;

    public int getNumberOfPage() {
        return new Document().numberOfPage;
    }

    public int getPageSize() {
        return new Document().pageSize;
    }



    public abstract void saveToner();
    public abstract void savePage();
    public abstract void boost();


    public abstract void applyConfiguration();
}