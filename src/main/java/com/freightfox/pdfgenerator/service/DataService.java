package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class DataService {


    public Context setBuyerSellerData(BuyerSellerDetails details){
        Context context = new Context();
        context.setVariable("details",details);
        return context;
    }
}
