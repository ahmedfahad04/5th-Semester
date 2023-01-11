package Refactoring;

public class MyPageSaveMode extends PrintMode {
    @Override
    public void saveToner() {

    }

    @Override
    public void savePage() {
        System.out.println("Saving page...");
    }

    @Override
    public void boost() {

    }
}
