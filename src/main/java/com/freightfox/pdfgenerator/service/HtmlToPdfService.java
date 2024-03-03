package com.freightfox.pdfgenerator.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class HtmlToPdfService {

    Logger logger = LoggerFactory.getLogger(HtmlToPdfService.class);

    @Autowired
    private FileManagerService fileManagerService;

    public void htmlToPdf(String htmlString, String filename) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(new DefaultFontProvider());
        HtmlConverter.convertToPdf(htmlString, pdfWriter, converterProperties);
        logger.info("converted html to pdf and assigned it to byteArrayOutputStream");
        fileManagerService.saveResource(filename, byteArrayOutputStream);
    }
}
