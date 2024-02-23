package org.example.bean;

import lombok.Getter;
import lombok.Setter;
import org.example.annotation.RandomValue;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class TestBean {
    @RandomValue(max = 100.0)
    private double value;
}