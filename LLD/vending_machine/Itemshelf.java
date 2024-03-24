public class Itemshelf
{
    int itemCode;
    Item item;
    boolean isSoldOut;

    public int getItemShelfCode(){
        return itemCode;
    }
    public void setItemShelfCode(int itemCode){
        this.itemCode = itemCode;
    }

    public Item getItem(){
        return item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public bool isItemSoldOut(){
        return isSoldOut;
    }

    public void setItemSoldOut(boolean isSoldOut){
        this.isSoldOut = isSoldOut;
    }
}
