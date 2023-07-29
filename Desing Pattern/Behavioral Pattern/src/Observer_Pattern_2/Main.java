package Observer_Pattern_2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileSubject fileSubject = new FileSubject(new File("myfile.txt"));
        fileSubject.addObserver(new ConsoleFileObserver());
        // add more observers here

        // simulate a file change
        fileSubject.setFile(new File("where.txt"));
    }
}

