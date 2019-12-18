package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;
    GildedRose app;

    @Test
    void NormalItem_QualityDecrease_PozSellIn_PozQuality() {
        createItemWithSellInAndQuality("Normal Item", 10, 20);
        app.updateQuality();
        resultingQualityShouldBe(19);
    }

    @Test
    void NormalItem_QualityDecrease_NegSellIn_PozQuality(){
        createItemWithSellInAndQuality("Normal Item", -7, 30);
        app.updateQuality();
        resultingQualityShouldBe(28);
    }

    @Test
    void NormalItem_QualityDecrease_ZeroSellIn_PozQuality(){
        createItemWithSellInAndQuality("Normal Item", 0, 30);
        app.updateQuality();
        resultingQualityShouldBe(28);
    }

    @Test
    void Sulfuras_Quality_SellInZero(){
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros",0, 80);
        app.updateQuality();
        resultingQualityShouldBe(80);
    }

    @Test
    void Sulfuras_Quality_NegSellIn(){
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros", -1, 80);
        app.updateQuality();
        resultingQualityShouldBe(80);
    }

    @Test
    void Sulfuras_Quality_PozSellIn() {
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros", 1, 80);
        app.updateQuality();
        resultingQualityShouldBe(80);
    }

    @Test
    void Sulfuras_SellInDecrease(){
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros", 5, 80);
        app.updateQuality();
        resultingQualityShouldBe(80);
    }

    @Test
    void BackstagePass_QualityIncrease_SellInGreaterThenTen() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 20, 40);
        app.updateQuality();
        resultingQualityShouldBe(41);
    }

    @Test
    void BackstagePass_QualityIncrease_SellInLowerThanTen() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 8, 40);
        app.updateQuality();
        resultingQualityShouldBe(42);
    }

    @Test
    void BackstagePass_QualityIncrease_SellInLowerThanFive() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 3, 40);
        app.updateQuality();
        resultingQualityShouldBe(43);
    }

    @Test
    void BackstagePass_QualityDecrease_AfterSellIn() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", -1, 40);
        app.updateQuality();
        resultingQualityShouldBe(0);
    }

    @Test
    void BackstagePass_QualityDecrease_OnSellIn(){
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 0, 40);
        app.updateQuality();
        resultingQualityShouldBe(0);
    }

    @Test
    void AgedBrie_QualityIncrease_PosSellIn_PosQuality() {
        createItemWithSellInAndQuality("Aged Brie", 10, 40);
        app.updateQuality();
        resultingQualityShouldBe(41);
    }

    @Test
    void AgedBrie_QualityIncrease_PosSellIn_ZeroQuality(){
        createItemWithSellInAndQuality("Aged Brie", 10, 0);
        app.updateQuality();
        resultingQualityShouldBe(1);
    }

    @Test
    void AgedBrie_QualityIncrease_ZeroSellIn_PosQuality(){
        createItemWithSellInAndQuality("Aged Brie", 0, 20);
        app.updateQuality();
        resultingQualityShouldBe(22);
    }

    @Test
    void AgedBrie_QualityIncrease_ZeroSellIn_ZeroQuality(){
        createItemWithSellInAndQuality("Aged Brie", 0, 0);
        app.updateQuality();
       resultingQualityShouldBe(2);
    }

    @Test
    void AgedBrie_QualityIncrease_NegSellIn_ZeroQuality(){
        createItemWithSellInAndQuality("Aged Brie", -1, 0);
        app.updateQuality();
        resultingQualityShouldBe(2);
    }

    @Test
    void AgedBrie_QualityIncrease_NegSellIn_PosQuality(){
        createItemWithSellInAndQuality("Aged Brie", -1, 20);
        app.updateQuality();
        resultingQualityShouldBe(22);
    }

    @Test
    void ConjuredItem_QualityDecrease_PosSellIn_PosQuality(){
        createItemWithSellInAndQuality("Conjured Item", 10, 20);
        app.updateQuality();
        resultingQualityShouldBe(18);
    }

    @Test
    void ConjuredItem_QualityDecrease_ZeroSellIn_PosQuality(){
        createItemWithSellInAndQuality("Conjured Item", 0, 20);
        app.updateQuality();
        resultingQualityShouldBe(16);
    }

    @Test
    void ConjuredItem_QualityDecrease_NegSellIn_PosQuality(){
        createItemWithSellInAndQuality("Conjured Item", -5, 20);
        app.updateQuality();
        resultingQualityShouldBe(16);
    }

    @Test
    void Quality_IsNever_Under_Zero(){
        createItemWithSellInAndQuality("Normal Item", 10, 0);
        app.updateQuality();
        resultingQualityShouldBe(0);
    }

    @Test
    void Quality_IsNever_Over_50(){
        createItemWithSellInAndQuality("Aged Brie", 5, 50);
        app.updateQuality();
        resultingQualityShouldBe(50);
    }

    @Test
    void test_Decrease_SellIn(){
       createItemWithSellInAndQuality("Normal Item", 5, 10);
       app.updateQuality();
       assertEquals(4, app.items[0].sellIn);
    }

    public void createItemWithSellInAndQuality(String name, int sellIn, int quality){
        items = new Item[]{new Item(name, sellIn, quality) };
        app = new GildedRose(items);
    }

    public void resultingQualityShouldBe(int quality){
        assertEquals(quality, app.items[0].quality);
    }


}
