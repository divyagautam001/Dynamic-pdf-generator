package com.freightfox.pdfgenerator.controller;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import com.freightfox.pdfgenerator.service.ConvertToPdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@RestController
@RequestMapping("/api")
public class WebController {

    Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private ConvertToPdfService convertToPdfService;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @PostMapping("/generate-pdf")
    public String generatePdf(@RequestBody BuyerSellerDetails details){
        logger.info(details.toString());
        String finalHtml = springTemplateEngine.process("buyer_seller",new Context());
        convertToPdfService.htmlToPdf(finalHtml);
        return "success";
    }

}
