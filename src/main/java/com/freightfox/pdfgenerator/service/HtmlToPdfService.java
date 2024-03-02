package com.freightfox.pdfgenerator.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class HtmlToPdfService {

    @Autowired
    private FileManagerService fileManagerService;

    public void htmlToPdf(String htmlString, String filename) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(new DefaultFontProvider());
        HtmlConverter.convertToPdf(htmlString, pdfWriter, converterProperties);

        fileManagerService.saveResource(filename, byteArrayOutputStream);
    }
}
