package com.example.curency.controller;

import com.example.curency.model.Currency;
import com.example.curency.service.CurrencyService;
import com.example.curency.service.ExternalCurrencyRate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyController.class)
//@ContextConfiguration(classes = {CurrencyControllerTest.TestContext.class})
public class CurrencyControllerTest {

    private static final Currency TEST_CURRENCY = Currency.builder()
            .id(1)
            .code("UA")
            .name("Hryvnja")
            .symbol("$")
            .build();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @MockBean
    private ExternalCurrencyRate lastestResponse;

    @Test
    public void shouldGetAllCurrencies() throws Exception {

        when(currencyService.readAll()).thenReturn(List.of(TEST_CURRENCY));
        String expectedJson = getResource("/allCurrencies.json");

        mockMvc.perform(get("/currency"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    public void shouldGetNotFoundIfNoCurrencyPresent() throws Exception {

        when(currencyService.readAll()).thenReturn(List.of());

        mockMvc.perform(get("/currency"))
                .andExpect(status().isNotFound());

    }

    private static String getResource(String filename) throws IOException {
        File resource = new ClassPathResource(filename).getFile();
        return new String(Files.readAllBytes(resource.toPath()));
    }

//    @Configuration
//    @Import(CurrencyController.class)
//    public static class TestContext {
//
////        @Bean
////        public ObjectMapper objectMapper() {
////            return new ObjectMapper();
////        }
//    }
}
