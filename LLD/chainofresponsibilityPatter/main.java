public class public static void main(String[] args) {

    LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

    logObject.log(LogProcessor:Error, message:"Exception Happended");
}