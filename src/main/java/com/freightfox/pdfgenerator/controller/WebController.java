package com.freightfox.pdfgenerator.controller;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import com.freightfox.pdfgenerator.service.ConvertToPdfService;
import com.freightfox.pdfgenerator.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@RestController
@RequestMapping("/api")
public class WebController {

    Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private ConvertToPdfService convertToPdfService;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private DataService dataService;

    @PostMapping("/generate-pdf")
    public String generatePdf(@RequestBody BuyerSellerDetails details){
        logger.info(details.toString());
        Context context = dataService.setBuyerSellerData(details);
        String finalHtml = springTemplateEngine.process("buyer_seller",context);
        convertToPdfService.htmlToPdf(finalHtml);
        return "success";
    }

}
