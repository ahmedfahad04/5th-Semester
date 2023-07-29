package Refactored_Code_2;

/*
The PageSaveMode contains another method called renderPreview that shows a preview of the updated document.
 */

public class PageSaveMode extends PrintMode{

    @Override
    public void applyConfiguration() {
        System.out.println("Saving page...");
    }
}
