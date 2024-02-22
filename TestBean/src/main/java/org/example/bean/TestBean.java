package org.example.bean;

import lombok.Getter;
import lombok.Setter;
import org.example.annotation.RandomValue;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class TestBean {
    @RandomValue(min = 0.0, max = 100.0)
    private double value;
}