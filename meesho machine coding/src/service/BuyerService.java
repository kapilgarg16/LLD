package service;

import model.Buyer;

public interface BuyerService {
     String addBuyer(Buyer buyer);
     Buyer getBuyer(String buyerId);
}
