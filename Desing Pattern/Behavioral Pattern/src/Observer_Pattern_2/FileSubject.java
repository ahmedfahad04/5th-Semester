package Observer_Pattern_2;

import java.io.File;
import java.util.Observable;

public class FileSubject extends Observable {
    private File file;

    public FileSubject(File file) {
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
        setChanged();
        notifyObservers();
    }

    public File getFile() {
        return file;
    }
}

