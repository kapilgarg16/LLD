//Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class). 
//Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

public abstract class LogProcessor
{
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLoggerProccessor;

    LogProcessor(LogProcessor loggerProcessor)
    {
        this.nextLoggerProccessor = loggerProcessor;
    }

    public void log (int loglevel, String message)
    {
        if(nextLoggerProccessor != null)
        {
            nextLoggerProccessor.log(loglevel, message);
        }
    }



}
