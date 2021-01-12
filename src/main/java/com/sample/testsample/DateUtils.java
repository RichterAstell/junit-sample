package com.sample.testsample;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtils {
    public LocalDate getNowDate() {
        return LocalDate.now();
    }
}
