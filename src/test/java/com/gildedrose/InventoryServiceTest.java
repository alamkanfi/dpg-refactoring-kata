package com.gildedrose;

import com.gildedrose.model.DegradationStrategy;
import com.gildedrose.model.Inventory;
import com.gildedrose.model.Item;
import com.gildedrose.model.StockItem;
import com.gildedrose.service.InventoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryServiceTest {
    @Test
    public void testDexterityVest() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("+5 Dexterity Vest", 10, 20))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.DECREASE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(9, inventory.getStockItem(0).getSellInDays());
        assertEquals(19, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testAgedBrie() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Aged Brie", 2, 0))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.INCREASE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(1, inventory.getStockItem(0).getSellInDays());
        assertEquals(1, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testElixir() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Elixir of the Mongoose", 5, 7))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.DECREASE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(4, inventory.getStockItem(0).getSellInDays());
        assertEquals(6, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testSulfurasFixedQuality() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Sulfuras, Hand of Ragnaros", 0, 80))
            .sellable(false)
            .minQuality(80)
            .maxQuality(80)
            .degradationStrategy(DegradationStrategy.LEGENDARY_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(0, inventory.getStockItem(0).getSellInDays());
        assertEquals(80, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testSulfuras2() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Sulfuras, Hand of Ragnaros", -1, 80))
            .sellable(false)
            .minQuality(80)
            .maxQuality(80)
            .degradationStrategy(DegradationStrategy.LEGENDARY_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();
        inventoryService.update(inventory);
        assertEquals(-1, inventory.getStockItem(0).getSellInDays());
        assertEquals(80, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testBackstageIncreaseQuality() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(14, inventory.getStockItem(0).getSellInDays());
        assertEquals(21, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testBackstageIncreaseQualityFast() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(5, inventory.getStockItem(0).getSellInDays());
        assertEquals(22, inventory.getStockItem(0).getQuality());
    }
    @Test
    public void testBackstageIncreaseVeryFast() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(2, inventory.getStockItem(0).getSellInDays());
        assertEquals(23, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testBackstageIncreaseToMaxQuality() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(9, inventory.getStockItem(0).getSellInDays());
        assertEquals(50, inventory.getStockItem(0).getQuality());
    }

    @Test
    public void testBackstage3() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.BACKSTAGE_QUALITY)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(4, inventory.getStockItem(0).getSellInDays());
        assertEquals(50, inventory.getStockItem(0).getQuality());
    }


    @Test
    public void testConjuredDecreaseFast() {
        final InventoryService inventoryService = new InventoryService();
        StockItem stockItem = StockItem.builder()
            .item(new Item("Conjured Mana Cake", 3, 6))
            .sellable(true)
            .minQuality(0)
            .maxQuality(50)
            .degradationStrategy(DegradationStrategy.DECREASE_QUALITY_FAST)
            .build();
        final Inventory inventory = Inventory.builder()
            .stockItem(stockItem)
            .build();

        inventoryService.update(inventory);
        assertEquals(2, inventory.getStockItem(0).getSellInDays());
        assertEquals(4, inventory.getStockItem(0).getQuality());
    }


}
