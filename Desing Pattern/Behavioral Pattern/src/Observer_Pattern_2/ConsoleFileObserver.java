package Observer_Pattern_2;

import java.io.File;
import java.util.Observable;

public class ConsoleFileObserver implements FileObserver {
    public void update(Observable o, Object arg) {
        if (o instanceof FileSubject) {
            FileSubject fileSubject = (FileSubject) o;
            File file = fileSubject.getFile();
            System.out.println("File " + file.getName() + " has been changed.");
        }
    }

    @Override
    public void update(FileSubject fileSubject) {

    }
}

