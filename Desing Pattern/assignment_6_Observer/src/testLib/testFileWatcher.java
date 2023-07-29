package testLib;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import static java.nio.file.StandardWatchEventKinds.*;

public class testFileWatcher {
    public static void main(String[] args) throws IOException {
        try (WatchService service = FileSystems.getDefault().newWatchService()) {

            Map<WatchKey, Path> keyMap = new HashMap<>();
            Path path = Paths.get("src/Files");
            keyMap.put(path.register(service, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY), path);

            WatchKey watchkey;

            do {
                watchkey = service.take();
                Path eventDir = keyMap.get(watchkey);

                for(WatchEvent<?> event: watchkey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path)event.context();
                    System.out.println(eventDir + ": " + kind + ": " + eventPath);
                }
            } while(watchkey.reset());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
