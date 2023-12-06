package com.aor.numbers;

public class DivisibleFilter implements GenericListFilter{
    private int divider;

    public DivisibleFilter(int divider) {
        this.divider = divider;
    }
    @Override
    public boolean accept(Integer number){
        return number % divider ==0;
    }

}
