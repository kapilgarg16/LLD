public class InfoLogProcessor extends LogProcessor
{
    public void log(int logLevel, String msg)
    {
        if(logLevel == INFO)
        {
            System.out.println("INFO" + message);
        }
        else{
            super.log(loglevel, message);
        }
    }
}