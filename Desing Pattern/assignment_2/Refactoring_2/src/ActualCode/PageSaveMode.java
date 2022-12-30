package ActualCode;

/*
The PageSaveMode contains another method called renderPreview that shows a preview of the updated document.
 */

public class PageSaveMode extends PrintMode {

    private void renderPreview(){
        System.out.println("Shows preview of updated document");
    }
    @Override
    public void saveToner() {

    }

    @Override
    public void savePage() {

    }

    @Override
    public void boost() {

    }
}
