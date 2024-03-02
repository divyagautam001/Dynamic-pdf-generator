package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class ContextService {


    public Context setBuyerSellerData(BuyerSellerDetails details) {
        Context context = new Context();
        context.setVariable("details", details);
        return context;
    }
}
