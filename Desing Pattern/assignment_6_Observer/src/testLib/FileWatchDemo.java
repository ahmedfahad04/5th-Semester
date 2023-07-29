package testLib;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatchDemo {
    public static void main(String[] args) {
        try {
            // Creates a instance of WatchService.
            WatchService watcher = FileSystems.getDefault().newWatchService();

            // Registers the logDir below with a watch service.
            Path logDir = Paths.get("src/Files");
            logDir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            // Monitor the logDir at listen for change notification.
            while (true) {
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    System.out.println("KIND: "+ kind);

                    if (kind == ENTRY_CREATE) {
                        System.out.println("Entry was created on log dir.:" + event.context());
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.println("Entry was modified on log dir.:" + event.context());
                    } else if (kind == ENTRY_DELETE) {
                        System.out.println("Entry was deleted from log dir.:" + event.context());
                    }
                }

                System.out.println("Calling...");
                key.reset();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}