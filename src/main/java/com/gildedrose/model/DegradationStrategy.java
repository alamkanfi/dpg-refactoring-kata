package com.gildedrose.model;

public enum DegradationStrategy {
    INCREASE_QUALITY {
        @Override
        public void degrade(StockItem item) {
            if (item.getQuality() < item.getMaxQuality()) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    },
    DECREASE_QUALITY {
        @Override
        public void degrade(StockItem item) {
            if (item.getQuality() > item.getMinQuality()) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    },
    DECREASE_QUALITY_FAST {
        @Override
        public void degrade(StockItem item) {
            if (item.getQuality() > item.getMinQuality()) {
                item.setQuality(item.getQuality() - 2);
            }
        }
    },
    LEGENDARY_QUALITY {
        @Override
        public void degrade(StockItem item) {
            item.setQuality(item.getMaxQuality());
        }
    },
    BACKSTAGE_QUALITY {
        @Override
        public void degrade(StockItem item) {
            if (item.getSellInDays() < 5) {
                item.setQuality(item.getQuality() +3);
            } else if (item.getSellInDays() < 10) {
                item.setQuality(item.getQuality() +2);
            } else {
                item.setQuality(item.getQuality() +1);
            }
            if (item.getQuality() > item.getMaxQuality()) {
                item.setQuality(item.getMaxQuality());
            }
            if (item.getSellInDays() < item.getMinQuality()) {
                item.setQuality(item.getMinQuality());
            }
        }
    };

    public abstract void degrade(StockItem item);
}
