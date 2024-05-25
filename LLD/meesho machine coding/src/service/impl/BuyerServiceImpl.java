package service.impl;

import exception.EcommerceException;
import model.Buyer;
import repository.BuyerRepository;
import service.BuyerService;

public class BuyerServiceImpl implements BuyerService {
    BuyerRepository buyerRepository;

   public BuyerServiceImpl(BuyerRepository buyerRepository){
       this.buyerRepository = buyerRepository;
   }

    @Override
    public String addBuyer(Buyer buyer) throws EcommerceException {
        buyerRepository.createBuyer(buyer);
        return buyer.getBuyerId();
    }

    @Override
    public Buyer getBuyer(String buyerId) {
       return buyerRepository.getBuyer(buyerId);
    }
}
