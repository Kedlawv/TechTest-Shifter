package com.wabu.techTest.REST;

public enum Rating {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    int numeric;
    Rating(int numeric){
        this.numeric = numeric;
    }
}
