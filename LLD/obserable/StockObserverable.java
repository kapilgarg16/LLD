public interface StockObservable {
    public void add(NotificationAlertObserver obesrver);
    public void remove(NotificationAlertObserver obesrver);
    public void notifySubscibers();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}