package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.exception.PdfGenerationFailedException;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

@Service
public class HtmlToPdfService {

    Logger logger = LoggerFactory.getLogger(HtmlToPdfService.class);

    @Value("${project.pdf.path}")
    private String path;

    public void htmlToPdf(String htmlString, String filename) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(new DefaultFontProvider());
        HtmlConverter.convertToPdf(htmlString, pdfWriter, converterProperties);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + filename);
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new PdfGenerationFailedException(e.getMessage());
        }

    }
}
