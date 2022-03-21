package com.example.curency.service;

import com.example.curency.repository.CurrencyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class CurrencyServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Test
    public void shouldReturnEmptyResultIfThereIsNoCurrencyInDatabase(){
        when(currencyRepository.findAll()).thenReturn(List.of());

        assertThat(currencyService.readAll()).isEmpty() ;
    }
}
