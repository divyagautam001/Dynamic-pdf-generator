package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class PdfManagerService {

    Logger logger = LoggerFactory.getLogger(PdfManagerService.class);

    private HtmlToPdfService htmlToPdfService;
    private SpringTemplateEngine springTemplateEngine;
    private ContextService contextService;

    @Autowired
    public PdfManagerService(HtmlToPdfService htmlToPdfService, SpringTemplateEngine springTemplateEngine,ContextService contextService){
        this.htmlToPdfService = htmlToPdfService;
        this.springTemplateEngine = springTemplateEngine;
        this.contextService = contextService;
    }

    @Async
    public void handle(BuyerSellerDetails details, String fileName) {
        Context context = contextService.setBuyerSellerData(details);
        logger.info("context created");
        String finalHtml = springTemplateEngine.process("buyer_seller", context);
        logger.info("html generated for given buyer seller details");
        htmlToPdfService.htmlToPdf(finalHtml, fileName);
    }

    public void handleSync(BuyerSellerDetails details, String fileName) {
        Context context = contextService.setBuyerSellerData(details);
        logger.info("context created");
        String finalHtml = springTemplateEngine.process("buyer_seller", context);
        logger.info("html generated for given buyer seller details");
        htmlToPdfService.htmlToPdf(finalHtml, fileName);
    }
}
