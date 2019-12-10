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
                computeAgedBrieNewQuality(item);
                break;
            case("Backstage passes to a TAFKAL80ETC concert"):
                computeBackstagePassNewQuality(item);
                break;
            case("Conjured Item"):
                computeConjuredItemNewQuality(item);
                break;
            case("Sulfuras, Hand of Ragnaros"):
                break;
            default:
                computeNormalItemQuality(item);
        }
        decreaseItemSellIn(item);
    }

    public void computeAgedBrieNewQuality(Item item){
        if(isUnderMaxQuality(item)) {
            increaseAgedBrieQuality(item);
        }
    }

    public void computeBackstagePassNewQuality(Item item){
        if(isUnderMaxQuality(item)) {
            increaseBackstagePassQuality(item);
        }
    }

    public void computeConjuredItemNewQuality(Item item){
        if(isOverMinQuality(item)){
            increaseConjuredItemQuality(item);
        }
    }

    public void computeNormalItemQuality(Item item){
        if(isOverMinQuality(item)) {
            decreaseNormalItemQuality(item);
        }
    }

    private void increaseAgedBrieQuality(Item item) {
        if(!isOverSellInDate(item)){
            item.quality += 2;
        }
        else {
            item.quality += 1;
        }
    }

    private void increaseBackstagePassQuality(Item item) {
        if(item.sellIn > 10 ) {
            item.quality += 1;
        }
        else if(item.sellIn > 5 ) {
            item.quality += 2;
        }
        else if(item.sellIn > 0) {
            item.quality += 3;
        }
        else {
            item.quality = 0;
        }
    }

    private void increaseConjuredItemQuality(Item item) {
        if(isOverSellInDate(item)) {
            item.quality -= 2;
        }
        else {
            item.quality -= 4;
        }
    }

    public void decreaseNormalItemQuality(Item item){
        if(isOverSellInDate(item)){
            item.quality -= 1;
        }
        else item.quality -= 2;
    }

    public void decreaseItemSellIn(Item item){
        if(!isSulfuras(item)) {
            item.sellIn -= 1;
        }
    }

    public boolean isSulfuras(Item item){
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isUnderMaxQuality(Item item){
        return item.quality < 50;
    }

    public boolean isOverMinQuality(Item item){
        return item.quality > 0;
    }

    public boolean isOverSellInDate(Item item) { return item.sellIn > 0;}

}