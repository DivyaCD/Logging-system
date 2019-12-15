package observer;

import subject.Subject;

public class FileLogger extends LogObservers {
    public FileLogger(Subject subject) {
        super(subject);
    }

    @Override
    public void updateLog(String log) {
        System.out.println("File: "+log);
    }

    @Override
    public String getName() {
        return "File logger";
    }
}