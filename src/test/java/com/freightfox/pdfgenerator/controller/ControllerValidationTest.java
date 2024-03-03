package com.freightfox.pdfgenerator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static com.freightfox.pdfgenerator.utils.TestData.invalidBuyerSellerDetailsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnBadRequestResponseWhenSyncGeneratePdfCalledAndIOExceptionOccurs() throws Exception {

        MvcResult result = this.mockMvc.perform(post("/api/sync/generate-pdf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidBuyerSellerDetailsString)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        Map<String,String> content = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Map.class);
        assertThat(content).containsKey("seller");
        assertThat(content).containsKey("sellerGstin");
        assertThat(content).containsKey("buyer");
        assertThat(content).containsKey("buyerGstin");
    }

    @Test
    void shouldReturnBadRequestResponseWhenAsyncGeneratePdfCalledAndIOExceptionOccurs() throws Exception {

        MvcResult result = this.mockMvc.perform(post("/api/sync/generate-pdf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidBuyerSellerDetailsString)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        Map<String,String> content = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Map.class);
        assertThat(content).containsKey("seller");
        assertThat(content).containsKey("sellerGstin");
        assertThat(content).containsKey("buyer");
        assertThat(content).containsKey("buyerGstin");
    }
}
