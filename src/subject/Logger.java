package subject;

import enums.LogType;
import observer.LogObservers;

import java.util.List;
import java.util.Map;

public class Logger extends Subject{


    public Map<LogType, List<LogObservers>> getMap() {
        return map;
    }

    public void setMap(Map<LogType, List<LogObservers>> map) {
        this.map = map;
    }

    @Override
    public void notifyLogs(LogType logType, String log) {
        for(Map.Entry<LogType, List<LogObservers>> entry:map.entrySet()){
            if(entry.getKey()==logType){
                entry.getValue().stream().forEach(observers -> observers.updateLog(log));
            }
        }
    }
}
