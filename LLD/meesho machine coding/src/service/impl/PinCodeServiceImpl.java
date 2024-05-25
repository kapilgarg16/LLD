package service.impl;

import model.PaymentMode;
import model.PinCodeServiceability;
import repository.PincodeServiceabilityRepository;
import service.PinCodeService;

import java.util.HashMap;

public class PinCodeServiceImpl implements PinCodeService {
    PincodeServiceabilityRepository pincodeServiceabilityRepository;
    public PinCodeServiceImpl(PincodeServiceabilityRepository pincodeServiceabilityRepository){
        this.pincodeServiceabilityRepository = pincodeServiceabilityRepository;
    }
    @Override
    public Boolean createPinCodeServiceability(String sourcePinCode, String destinationPinCode, PaymentMode paymentMode)  {
        PinCodeServiceability pinCodeServiceability = new PinCodeServiceability(destinationPinCode,paymentMode);
        return pincodeServiceabilityRepository.createPinCodeServiceability(sourcePinCode,pinCodeServiceability);
    }

    @Override
    public Boolean checkIsSourceAndDestPinCodeMatchesForPaymentType(String sourcePinCode, String destinationPinCode, PaymentMode paymentMode)  {
        HashMap<String, PaymentMode> allDestinationPincodes = pincodeServiceabilityRepository.getAllDestinationPincodes(sourcePinCode);
        return allDestinationPincodes.containsKey(destinationPinCode) &&
                paymentMode.equals(allDestinationPincodes.get(destinationPinCode));
    }
}
