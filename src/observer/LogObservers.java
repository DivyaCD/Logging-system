package observer;

import subject.Subject;

public abstract class LogObservers {
    Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LogObservers(Subject subject) {
        this.subject = subject;
    }

    public abstract void updateLog(String log);

    public abstract String getName();

}
