package com.gildedrose;

import com.gildedrose.model.DegradationStrategy;
import com.gildedrose.model.Inventory;
import com.gildedrose.model.Item;
import com.gildedrose.model.StockItem;
import com.gildedrose.service.InventoryService;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        final InventoryService inventoryService = new InventoryService();
        Inventory inventory = Inventory.builder()
            .stockItem(
                StockItem.builder()
                    .item(new Item("+5 Dexterity Vest", 10, 20))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.DECREASE_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Aged Brie", 2, 0))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.INCREASE_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Elixir of the Mongoose", 5, 7))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.DECREASE_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Sulfuras, Hand of Ragnaros", 0, 80))
                    .sellable(false)
                    .minQuality(80)
                    .maxQuality(80)
                    .degradationStrategy(DegradationStrategy.LEGENDARY_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Sulfuras, Hand of Ragnaros", -1, 80))
                    .sellable(false)
                    .minQuality(80)
                    .maxQuality(80)
                    .degradationStrategy(DegradationStrategy.LEGENDARY_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
                .build())
            .stockItem(
                StockItem.builder()
                    .item(new Item("Conjured Mana Cake", 3, 6))
                    .sellable(true)
                    .minQuality(0)
                    .maxQuality(50)
                    .degradationStrategy(DegradationStrategy.DECREASE_QUALITY_FAST)
                .build())
            .build();

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");

            for (StockItem item : inventory.getStockItems()) {
                System.out.println(item);
            }
            System.out.println();
            inventoryService.update(inventory);
        }
    }

}
