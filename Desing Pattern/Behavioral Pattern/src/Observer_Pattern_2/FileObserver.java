package Observer_Pattern_2;

import java.util.Observer;

public interface FileObserver extends Observer {
    void update(FileSubject fileSubject);
}

