package observer;

import enums.LogType;
import subject.Subject;

public class ConsoleLogger extends LogObservers {


    public ConsoleLogger(Subject subject) {
        super(subject);
    }

    @Override
    public void updateLog(String log) {
        System.out.println("Console: "+log);
    }

    @Override
    public String getName() {
        return "Console";
    }
}
