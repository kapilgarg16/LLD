public class Item
{
    int price;
    ItemType itemType;

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void getItemType(){
        return itemType;
    }

    public ItemType setItemType(ItemType itemType){
        this.itemType = itemType;
    }


}