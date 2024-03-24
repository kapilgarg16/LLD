public class public static void main(String[] args) {
    VendingMachine vendingMachine = new VendingMachine();


    try{
        System.out.println("filling up the inventory");

        fillUpInventory(vendingMachine);
        displayInventory(vendingMachine);


    //---------------------------------------------------
        //click on insert coin button
        State machineState = vendingMachine.getVendingMachineState();

       //vending machine is already in idlestate, 

       //click to insert coin
       machineState.clickOnInsertCoinButton(vendingMachine);
    //------------------------------------

    //---------------------------------------------

       //moving to hasmoney state
       machineState = vendingMachine.getVendingMachineState();

       //inserting the coins in machine
       machineState.insertCoin(vendingMachine, Coin.PENNY);
       machineState.insertCoin(vendingMachine, Coin.NICKEL);

       //click on select product button
       machineState.clickOnStartProductSelectionButton(machineState);

    //---------------------------------------------

    //----------------------------------------------
        //moving to selection state
        machineState = vendingMachine.getVendingMachineState(); 

        machineState.chooseProduct(vendingMachine, 101);
        

        displayInventory(vendingMachine);
    }
    catch (Exception e){
        displayInventory(vendingMachine);
    }


        //add the items in inventory
        public void fillUpInventory(VendingMachine vendingMachine){
            Itemshelf[] slots = vendingMachine.getInventory().getInventory();

            for(int i = 0 ; i < slots.length ; i++){

                Item newItem = new Item();

                if(i >=0 && i<3) {
                    newItem.setItemType(ItemType.coke);
                    newItem.setPrice(20);
                }else if(i >=3 && i<5){
                    newItem.setItemType(ItemType.PEPSI);
                    newItem.setPrice(9);
                }else if(i >=5 && i<7){
                    newItem.setItemType(ItemType.JUICE);
                    newItem.setPrice(13);
                }else if(i >=7 && i<10){
                    newItem.setItemType(ItemType.SODA);
                    newItem.setPrice(7);
                }
                slots[i].setItem(newItem);
                slot[i].setItemSoldOut(false);
            }
        }

        //display the item
        private static void displayInventory(VendingMachine vendingMachine){

            ItemShelf[] slots = vendingMachine.getInventory().getInventory();
            for (int i = 0; i < slots.length; i++) {
    
                System.out.println("CodeNumber: " + slots[i].getItemShelfCode() +
                        " Item: " + slots[i].getItem().getItemType().name() +
                        " Price: " + slots[i].getItem().getPrice() +
                        " isAvailable: " + !slots[i].isItemSoldOut());
            }
        }
    

}