public class Inventory{

    Itemshelf[] inventory = null;
    
    Inventory(int totalItemCount){
        inventory = new Itemshelf[totalItemCount];

        initialEmptyInventory();
    }

    public Itemshelf[] getInventory(){
        return inventory;
    }
    public initialEmptyInventory(){
        int itemcode = 100;
        for(int i = 0 ; i < inventory.length  ; i++){
            inventory[i] = new Itemshelf();
            inventory[i].setItemShelfCode(itemcode);
            inventory[i].setItemSoldOut(false);
            itemcode++;
        }
    }

    public addItemInInventory(Item item, int itemcode) throws Exception{
        for(itemshelf : inventory){
            if(itemshelf.getItemShelfCode() == itemcode){
                if(itemshelf.isItemSoldOut() == true)
                {
                    itemshelf.setItem = item;
                    itemshelf.setItemSoldOut(false);
                }
                else
                {
                    throw new Exception("item is already available in Item shelf...");
                }

            }
        }
    }

    public Item getItemFromInventory(int itemCode){
        for(itemshelf : inventory){
            if(itemshelf.getItemShelfCode() == itemcode){
                if(itemshelf.isItemSoldOut() == false){
                    itemshelf.setItemSoldOut(true);
                    return itemshelf.getItem();
                }
                else{
                    throw new Exception("item is not available in shelf");
                }
            }
            else{
                throw new Exception("Please enter correct itemcode");
            }
        }
    }
}   