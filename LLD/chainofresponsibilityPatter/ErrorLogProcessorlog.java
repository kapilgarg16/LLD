public class ErrorLogProcessor extends LogProcessor
{
    public void log(int logLevel, String msg)
    {
        if(logLevel == ERROR)
        {
            System.out.println("ERROR" + message);
        }
        else{
            super.log(loglevel, message);
        }
    }
}