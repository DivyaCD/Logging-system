package subject;

import enums.LogType;
import observer.LogObservers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Subject {
    Map<LogType, List<LogObservers>> map=new HashMap<>();

    List<LogObservers> observersList;

    public Subject() {
        observersList=new ArrayList<>();
        map.put(LogType.ERROR,new ArrayList<>());
        map.put(LogType.INFO,new ArrayList<>());
        map.put(LogType.WARN,new ArrayList<>());

    }

    public void addLogger(LogObservers observer, LogType type){
        System.out.println("Added new observer:" + observer.getName());
        for(Map.Entry<LogType, List<LogObservers>> entry:map.entrySet()){
            if(entry.getKey()==type){
                List<LogObservers> observers=entry.getValue();
                observers.add(observer);
            }
        }
        observersList.add(observer);
    }

    public void disableLogger(LogObservers observer){
        System.out.println("Remove an observer from the list:"+observer.getName());
        observersList=observersList.stream().filter(o->!o.equals(observer)).collect(Collectors.toList());
        for(Map.Entry<LogType, List<LogObservers>> entry:map.entrySet()){
            entry.setValue(entry.getValue().stream().filter(observers -> !observers.equals(observer)).collect(Collectors.toList()));
        }
    }

    public abstract void notifyLogs(LogType logType, String log);

}
