package com.gildedrose.service;

import com.gildedrose.model.Inventory;
import com.gildedrose.model.StockItem;

public class InventoryService {

    public void update(final Inventory inventory) {
        for (int i = 0; i < inventory.getStockItems().size(); i++) {
            updateItemSellInDays(inventory.getStockItem(i));
            updateItemQuality(inventory.getStockItem(i));
        }
    }

    private void updateItemSellInDays(StockItem item) {
        if (item.isSellable()) {
            item.setSellInDays(item.getSellInDays() - 1);
        }
    }

    private void updateItemQuality(StockItem item) {
        item.degrade();
    }
}
