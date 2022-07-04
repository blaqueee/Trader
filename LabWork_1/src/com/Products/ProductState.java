package com.Products;

public enum ProductState {
    NORMAL(1.2),
    SLIGHTLY_SPOILED(0.95),
    HALF_SPOILED(0.55),
    SPOILED(0.25),
    VERY_SPOILED(0.1);

    private double coefficient;

    ProductState(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
