package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item)
                    && !isBackstagePass(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (isBackstagePass(item)) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            }
            endDay(item);

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePass(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseQuality(item);
                }
            }
        }
    }

    public boolean isAgedBrie(Item item){
        return item.name.equals("Aged Brie");
    }

    public boolean isSulfuras(Item item){
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackstagePass(Item item){
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public void increaseQuality(Item item){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void decreaseQuality(Item item){
        if( (!isAgedBrie(item) || !isBackstagePass(item)
                || !isSulfuras(item)) && item.quality > 0 ){
            item.quality = item.quality - 1;
        }
    }

    public void endDay(Item item){
        if(!isSulfuras(item)){
            item.sellIn -= 1;
        }
    }

    public void normalItemQualityDecay(Item item) {
        if (!isAgedBrie(item)
                && !isBackstagePass(item)) {
            if (item.quality > 0) {
                if (!isSulfuras(item)) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }

}