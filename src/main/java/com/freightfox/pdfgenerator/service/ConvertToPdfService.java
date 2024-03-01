package com.freightfox.pdfgenerator.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

@Service
public class ConvertToPdfService {

    Logger logger = LoggerFactory.getLogger(ConvertToPdfService.class);

    public void htmlToPdf(String htmlString){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);

            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setFontProvider(new DefaultFontProvider());
            HtmlConverter.convertToPdf(htmlString, pdfWriter, converterProperties);

            FileOutputStream fileOutputStream = new FileOutputStream("/mnt/hdd/DATA/Projects/Divya/pdfgenerator/localStorage/someFile.pdf");
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            fileOutputStream.close();
        }
        catch (Exception e){
            logger.error("Failed to convert HTML file to PDF");
        }
    }
}
