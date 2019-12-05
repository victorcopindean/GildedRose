package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            computeNewItemValueAndSellIn(item);
        }
    }

    public void computeNewItemValueAndSellIn(Item item){
        switch (item.name){
            case ("Aged Brie"):
                increaseAgedBrieQuality(item);
            case("Backstage passes to a TAFKAL80ETC concert"):
                increaseBackstagePassQuality(item);
            case("Conjured Item"):
                decreaseConjuredItemQuality(item);
            case("Sulfuras, Hand of Ragnaros"):
                break;
            default:
                decreaseNormalItemQuality(item);
        }
        advanceSellIn(item);
    }

    public void decreaseNormalItemQuality(Item item){
        if(item.quality > 0) {
            if(item.sellIn > 0) {
                item.quality = item.quality - 1;
            }
            else {
                item.quality = item.quality - 2;
            }
        }
    }

    public void decreaseConjuredItemQuality(Item item){
        if(item.quality > 0 && isConjuredItem(item)){
            if(item.sellIn > 0) {
                item.quality = item.quality - 2;
            }
            else {
                item.quality = item.quality - 4;
            }
        }
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
}