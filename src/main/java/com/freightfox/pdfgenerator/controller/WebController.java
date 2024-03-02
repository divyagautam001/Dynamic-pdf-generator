package com.freightfox.pdfgenerator.controller;

import com.freightfox.pdfgenerator.entity.BuyerSellerDetails;
import com.freightfox.pdfgenerator.service.FileManagerService;
import com.freightfox.pdfgenerator.service.PdfManagerService;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class WebController {

    Logger logger = LoggerFactory.getLogger(WebController.class);

   @Autowired
    private PdfManagerService pdfManagerService;

   @Autowired
   private FileManagerService fileManagerService;

   @Value("${project.pdf.path}")
   private String path;

    @PostMapping("/generate-pdf")
    public ResponseEntity<String> generatePdf(@RequestBody BuyerSellerDetails details){
        logger.info(details.toString());
        String fileName = "f"+details.hashCode()+".pdf";
        boolean fileExists = fileManagerService.doesFileExist(path,fileName);

        if(!fileExists){
            pdfManagerService.handle(details,fileName);
            logger.info("{} created with buyer seller details - {}",details,fileName);
            return ResponseEntity.ok()
                    .body("pdf created => "+fileName);
        }
        else {
            logger.info("{} already exist",fileName);
            return ResponseEntity.ok()
                    .body("pdf already exist => "+fileName);
        }
    }

    @GetMapping(value = "/pdf/{pdfName}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getPdf(@PathVariable String pdfName) {
        InputStream resource = fileManagerService.getResource(path,pdfName);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(resource));
    }


}
