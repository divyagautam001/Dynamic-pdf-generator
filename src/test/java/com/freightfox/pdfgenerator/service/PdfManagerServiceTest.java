package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.service.HtmlToPdfService;
import com.freightfox.pdfgenerator.service.PdfManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.freightfox.pdfgenerator.utils.TestData.generatedHtmlString;
import static com.freightfox.pdfgenerator.utils.TestData.getBuyerSellerDetails;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PdfManagerServiceTest {

    @Autowired
    private PdfManagerService pdfManagerService;

    @MockBean
    private HtmlToPdfService htmlToPdfService;

    @Test
    public void shouldGenerateCorrectHtmlForBuyerSellerDetails() {
        String fileName = "fileName.pdf";
        pdfManagerService.handleSync(getBuyerSellerDetails(), fileName);
        verify(htmlToPdfService).htmlToPdf(eq(generatedHtmlString), eq(fileName));
    }
}
