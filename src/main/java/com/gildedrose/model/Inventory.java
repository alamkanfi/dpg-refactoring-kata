package com.gildedrose.model;

import java.util.List;

import com.gildedrose.exception.StockItemNotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class Inventory {

    @Singular
    private final List<StockItem> stockItems;

    public StockItem getStockItem(int index) throws StockItemNotFoundException {
        if (index > stockItems.size()) {
            throw new StockItemNotFoundException("Index " + index + " is out of bounds.");
        }
        return stockItems.get(index);
    }

}
