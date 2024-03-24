public class IphoneObservalbleImpl implements StocksObservable {

    public List<NotificationAlertObserver> obesrverList = new ArrayList<>();

    public int stockCount = 0;

    
    public void add(NotificationAlertObserver obesrver)
    {
        obesrverList.add(observer);
    }
    public void remove(NotificationAlertObserver obesrver)
    {
        obesrverList.remove(obesrver);
    }
    public void notifySubscibers()
    {
        for(NotificationAlertObserver obesrver : obesrverList)
        {
            observer.update();
        }
    }
    public void setStockCount(int newStockAdded)
    {
        if(stockCount == 0)
        {
            notifySubscibers();
        }
        stockCount += newStockAdded;
    }
    public int getStockCount()
    {
        return stockCount;
    }

}