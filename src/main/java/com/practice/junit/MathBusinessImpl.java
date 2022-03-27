package com.practice.junit;

import java.util.List;

public class MathBusinessImpl {

    private MathService mathService;

    public MathBusinessImpl(MathService mathService) {
        this.mathService = mathService;
    }

    public Long findMax(List<Long> numberList) {
        return mathService.findMaxNumber(numberList);
    }
}
