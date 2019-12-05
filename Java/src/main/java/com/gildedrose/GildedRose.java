package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            computeNewQualityAndSellIn(item);
        }
    }

    public void computeNewQualityAndSellIn(Item item){
        decreaseQuality(item);
        increaseQuality(item);
        advanceSellIn(item);
    }

    public void decreaseQuality(Item item){
        if(item.quality > 0 && isNormalItem(item)) {
            if(item.sellIn > 0) {
                item.quality = item.quality - 1;
            }
            else item.quality = item.quality - 2;
        }
        if(item.quality > 0 && isConjuredItem(item)){
            if(item.sellIn > 0) {
                item.quality = item.quality - 2;
            }
            else item.quality = item.quality - 4;
        }
    }

    public void increaseQuality(Item item){
       increaseAgedBrieQuality(item);
       increaseBackstagePassQuality(item);
    }

    public void increaseAgedBrieQuality(Item item){
        if(isAgedBrie(item) && item.quality < 50) {
            if(item.sellIn <= 0){
                item.quality = item.quality + 2;
            }
            else item.quality = item.quality + 1;
        }
    }

    public void increaseBackstagePassQuality(Item item){
        if(isBackstagePass(item) && item.quality < 50) {
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

    public void advanceSellIn(Item item){
        if(!isSulfuras(item)){
            item.sellIn -= 1;
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

    public boolean isConjuredItem(Item item){
        return item.name.equals("Conjured Item");
    }

    public boolean isNormalItem(Item item){
        return !isSulfuras(item) && !isAgedBrie(item) && !isBackstagePass(item) && !isConjuredItem(item);
    }

}