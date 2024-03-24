public class MobileAlertObserverImpl implements NotificationAlertObserver 
{
    String userName;
    StockObservable obesrverable;

    public MobileAlertObserverImpl(string emailID, StockObservable observable)
    {
        this.observable = observable;
        this.userName = emailID;
    }

    public void update()
    {
        sendMsgOnMobile(userName, msg:"product is in stock hurry up")
    }

    private  void sendMsgOnMobile(string userName, string msg) {

        System.out.println("msg" + userName);
        
    }
}