package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item.name)
                    && !isBackstagePass(item.name)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item.name)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (isBackstagePass(item.name)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item.name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item.name)) {
                    if (!isBackstagePass(item.name)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item.name)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public boolean isAgedBrie(String name){
        return name.equals("Aged Brie");
    }

    public boolean isSulfuras(String name){
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackstagePass(String name){
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

}