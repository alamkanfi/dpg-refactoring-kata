package com.gildedrose.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class StockItem {
    private final Item item;
    private final DegradationStrategy degradationStrategy;
    private final int minQuality;
    private final int maxQuality;
    private final boolean sellable;

    public String getName() {
        return item.name;
    }

    public int getQuality() {
        return item.quality;
    }
    public void setQuality(int quality) {
        this.item.quality = quality;
    }

    public int getSellInDays() {
        return item.sellIn;
    }

    public void setSellInDays(int sellInDays) {
        this.item.sellIn = sellInDays;
    }

    public void degrade() {
        degradationStrategy.degrade(this);
    }
}
