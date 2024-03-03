package com.freightfox.pdfgenerator.service;

import com.freightfox.pdfgenerator.service.FileManagerService;
import com.freightfox.pdfgenerator.service.HtmlToPdfService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith({MockitoExtension.class})
public class HtmlToPdfServiceTest {

    @Mock
    FileManagerService fileManagerService;

    @InjectMocks
    HtmlToPdfService htmlToPdfService;

    @Test
    public void shouldGeneratePdfFromGivenHtmlString(){
        htmlToPdfService.htmlToPdf("<h1>hello</h1>","filename.pdf");
        verify(fileManagerService,times(1)).saveResource(eq("filename.pdf"), any(ByteArrayOutputStream.class));
    }
}
