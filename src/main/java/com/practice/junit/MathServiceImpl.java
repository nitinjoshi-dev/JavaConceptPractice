package com.practice.junit;

import java.util.List;

public class MathServiceImpl implements MathService {


    @Override
    public Long findMaxNumber(List<Long> numberList) {
        Long max = Long.MIN_VALUE;

        for(long number : numberList) {
            if (max < number) {
                max = number;
            }
        }

        return max;
    }
}
