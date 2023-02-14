package classwork;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class ConcreteSubject extends Subject {

    private final String fileDirectory;

    public ConcreteSubject(String fname) {
        this.fileDirectory = fname;
    };

    public void trackFileChanges() throws IOException, InterruptedException {
        // Creates a instance of WatchServices

        WatchService watcher = FileSystems.getDefault().newWatchService();

        Path logDir = Paths.get(fileDirectory);
        logDir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

        while (true) {
            WatchKey key = watcher.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == ENTRY_CREATE) {
                    Notify("Entry was CREATED on log dir.:" + event.context());
                } else if (kind == ENTRY_MODIFY) {
                    Notify("Entry was MODIFY on log dir.:" + event.context());
                } else if (kind == ENTRY_DELETE) {
                    Notify("Entry was DELETED on log dir.:" + event.context());
                }
            }
            key.reset();
        }
    };

}
