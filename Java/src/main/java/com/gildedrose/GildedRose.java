package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            computeNewQuality(item);
        }
    }

    public void computeNewQuality(Item item){
        normalItemQualityDecay(item);
        agedBrieQualityIncrease(item);
        backstagePassQualityIncrease(item);
        endDay(item);
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

    public boolean isNormalItem(Item item){
        return !isSulfuras(item) && !isAgedBrie(item) && !isBackstagePass(item);
    }

    public void increaseQuality(Item item){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void normalItemQualityDecay(Item item){
        if(item.quality > 0 && isNormalItem(item)) {
            if(item.sellIn > 0) {
                item.quality = item.quality - 1;
            }
            else item.quality = item.quality - 2;
        }
    }

    public void agedBrieQualityIncrease(Item item){
        if(isAgedBrie(item)) {
            increaseQuality(item);
        }
        if(isAgedBrie(item) && item.sellIn <= 0){
            increaseQuality(item);
        }
    }

    public void backstagePassQualityIncrease(Item item){

        if(isBackstagePass(item)) {
            if(item.sellIn > 10 ) {
                item.quality = item.quality + 1;
            }
            else if(item.sellIn > 5 ) {
                item.quality = item.quality + 2;
            }
            else if(item.sellIn > 0) {
                item.quality = item.quality + 3;
            }
            else item.quality = 0;
        }
    }

    public void endDay(Item item){
        if(!isSulfuras(item)){
            item.sellIn -= 1;
        }
    }
}