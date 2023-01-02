package Refactoring;

/*
The PageSaveMode contains another method called renderPreview that shows a preview of the updated document.
 */

public class PageSaveMode {

    private final MyPageSaveMode pageSaveMode = new MyPageSaveMode();

    private void renderPreview(){
        System.out.println("Shows preview of updated document");
    }

    public void savePage() {
        pageSaveMode.savePage();
    }

}
