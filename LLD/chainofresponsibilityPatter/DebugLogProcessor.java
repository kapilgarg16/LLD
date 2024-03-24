public class DebugLogProcessor extends LogProcessor
{
    public void log(int logLevel, String msg)
    {
        if(logLevel == DEBUG)
        {
            System.out.println("Debug" + message);
        }
        else{
            super.log(loglevel, message);
        }
    }
}