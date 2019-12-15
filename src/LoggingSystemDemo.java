import enums.LogType;
import observer.ConsoleLogger;
import observer.FileLogger;
import observer.LogObservers;
import observer.NetworkLogger;
import subject.Logger;

public class LoggingSystemDemo {

    public static void main(String[] args){
        Logger logger=new Logger();

        LogObservers console=new ConsoleLogger(logger);
        LogObservers network=new NetworkLogger(logger);
        LogObservers file=new FileLogger(logger);

        logger.addLogger(console,LogType.ERROR);
        logger.addLogger(file,LogType.ERROR);
        logger.addLogger(console,LogType.INFO);
        logger.addLogger(network,LogType.WARN);

        System.out.println();
        logger.notifyLogs(LogType.ERROR,"My first error!");
        logger.notifyLogs(LogType.INFO,"My first info!");
        logger.notifyLogs(LogType.ERROR,"My second error!");
        logger.notifyLogs(LogType.WARN,"My first warning!");

        logger.disableLogger(console);
        System.out.println();
        logger.notifyLogs(LogType.ERROR,"My first error!");
        logger.notifyLogs(LogType.INFO,"My first info!");

    }
}
