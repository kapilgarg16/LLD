package service;

import exception.EcommerceException;
import model.PaymentMode;
import model.PinCodeServiceability;

public interface PinCodeService {
    Boolean createPinCodeServiceability(String sourcePinCode, String destinationPinCode, PaymentMode paymentMode) ;

    Boolean checkIsSourceAndDestPinCodeMatchesForPaymentType(String sourcePinCode, String destinationPinCode, PaymentMode paymentMode) ;
}