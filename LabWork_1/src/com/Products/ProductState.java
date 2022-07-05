package com.Products;

public enum ProductState {
    NORMAL(1.2) {
        @Override
        public void spoilProduct(Product product) {
            product.setQuality(SLIGHTLY_SPOILED);
        }
    },
    SLIGHTLY_SPOILED(0.95) {
        @Override
        public void spoilProduct(Product product) {
            product.setQuality(HALF_SPOILED);
        }
    },
    HALF_SPOILED(0.55) {
        @Override
        public void spoilProduct(Product product) {
            product.setQuality(SPOILED);
        }
    },
    SPOILED(0.25) {
        @Override
        public void spoilProduct(Product product) {
            product.setQuality(VERY_SPOILED);
        }
    },
    VERY_SPOILED(0.1) {
        @Override
        public void spoilProduct(Product product) {
            product.setQuality(VERY_SPOILED);
        }
    };

    private double coefficient;

    ProductState(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public abstract void spoilProduct(Product product);
}
