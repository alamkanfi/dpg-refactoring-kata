package com.gildedrose.exception;


public class StockItemNotFoundException extends RuntimeException {
    public StockItemNotFoundException(String message) {
        super(message);
    }
}
