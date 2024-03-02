package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class PdfManagerService {

    Logger logger = LoggerFactory.getLogger(PdfManagerService.class);

    @Autowired
    private HtmlToPdfService htmlToPdfService;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private ContextService contextService;

    public void handle(BuyerSellerDetails details, String fileName) {
        Context context = contextService.setBuyerSellerData(details);
        logger.info("context created");
        String finalHtml = springTemplateEngine.process("buyer_seller", context);
        logger.info("html generated for given buyer seller details");
        htmlToPdfService.htmlToPdf(finalHtml, fileName);
    }
}
