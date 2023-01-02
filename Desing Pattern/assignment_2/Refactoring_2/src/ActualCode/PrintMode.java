package ActualCode;

/*
TonerSaveMode additionally contains a field named tonerSavingLevel. 
In the saveToner method, if tonerSavingLevel is set high, color intensity is reduced by following a well-known standard algorithm. 
Similarly, if tonerSavingLevel is medium and low, two different algorithms are used to reduce color intensity. In the PageSaveMode, 
a single algorithm is used to adjust page size and orientation in a way that the number of pages required is reduced.
 */

/*
    1. Duplicate Code [resolve: strategy Pattern]
    {saveToner() in TonerSaveMode}

    2. Refused Bequest []
    {boost(), savePage() in TonerSaveMode; saveToner(), savePage() in BoosterMode;
     saveToner(), boost() in PageSaveMode}

 */

public abstract class PrintMode {
    private int numberOfPages;
    private int pageSize;
    private String orientation;
    private String colorIntensity;
    private double costPerPage;

    public abstract void saveToner();
    public abstract void savePage();
    public abstract void boost();


}