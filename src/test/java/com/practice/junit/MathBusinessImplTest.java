package com.practice.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathBusinessImplTest {

    @Test
    public void testMathLogicWithMockito() {

        MathService mockedMathService = Mockito.mock(MathService.class);

        List<Long> numberList = new ArrayList<>(10);
        numberList.add(1l);
        numberList.add(10l);
        numberList.add(11l);
        numberList.add(12l);
        numberList.add(12l);
        numberList.add(-12l);



        Mockito.when(mockedMathService.findMaxNumber(numberList)).thenReturn(12l);

        Assertions.assertEquals(12l, new MathBusinessImpl(mockedMathService).findMax(numberList));


    }

}