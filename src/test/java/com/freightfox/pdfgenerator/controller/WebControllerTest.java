package com.freightfox.pdfgenerator.controller;

import com.freightfox.pdfgenerator.service.FileManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.freightfox.pdfgenerator.utils.TestData.buyerSellerDetailsString;
import static com.freightfox.pdfgenerator.utils.TestData.getBuyerSellerDetails;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileManagerService fileManagerService;

    @Test
    void shouldReturnOkResponseWhenAsyncGeneratePdfCalledWithExistingData() throws Exception {
        when(fileManagerService.doesFileExist(any(String.class))).thenReturn(true);

        MvcResult result = this.mockMvc.perform(post("/api/generate-pdf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(buyerSellerDetailsString)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        String generatedFileName = "f" + getBuyerSellerDetails().hashCode() + ".pdf";
        assertThat(content).contains("pdf already exist => " + generatedFileName);
    }

    @Test
    void shouldReturnOkResponseWhenAsyncGeneratePdfCalledOnNewData() throws Exception {
        when(fileManagerService.doesFileExist(any(String.class))).thenReturn(false);

        MvcResult result = this.mockMvc.perform(post("/api/generate-pdf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(buyerSellerDetailsString)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        String generatedFileName = "f" + getBuyerSellerDetails().hashCode() + ".pdf";
        assertThat(content).isEqualTo("pdf => " + generatedFileName + " will be created within some time");
    }

    @Test
    void shouldReturnOkResponseWhenAsyncGeneratePdfCalledAndIOExceptionOccurs() throws Exception {
        when(fileManagerService.doesFileExist(any(String.class))).thenReturn(false);

        MvcResult result = this.mockMvc.perform(post("/api/generate-pdf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(buyerSellerDetailsString)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        String generatedFileName = "f" + getBuyerSellerDetails().hashCode() + ".pdf";
        assertThat(content).isEqualTo("pdf => " + generatedFileName + " will be created within some time");
    }

    @Test
    void shouldReturnInternalServerErrorResponseWhenSyncGeneratePdfCalledAndIOExceptionOccurs() throws Exception {
        when(fileManagerService.doesFileExist(any(String.class))).thenReturn(false);
        doThrow(new RuntimeException(new IOException())).when(fileManagerService).saveResource(any(String.class),any(ByteArrayOutputStream.class));

        this.mockMvc.perform(post("/api/sync/generate-pdf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(buyerSellerDetailsString)
                )
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

}