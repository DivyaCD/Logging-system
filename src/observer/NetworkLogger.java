package observer;

import subject.Subject;

public class NetworkLogger extends LogObservers {
    public NetworkLogger(Subject subject) {
        super(subject);
    }

    @Override
    public void updateLog(String log) {
        System.out.println("Network: "+log);
    }

    @Override
    public String getName() {
        return "Network Logger";
    }
}