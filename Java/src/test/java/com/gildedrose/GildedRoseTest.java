package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;
    GildedRose app;

    @Test
    void test_NormalItem_QualityDecrease_PozSellIn_PozQuality() {
        createItemWithSellInAndQuality("Normal Item", 10, 20);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void test_NormalItem_QualityDecrease_NegSellIn_PozQuality(){
        createItemWithSellInAndQuality("Normal Item", -7, 30);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void test_NormalItem_QualityDecrease_ZeroSellIn_PozQuality(){
        createItemWithSellInAndQuality("Normal Item", 0, 30);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void test_Sulfuras_Quality_SellInZero(){
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros",0, 80);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_Sulfuras_Quality_NegSellIn(){
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros", -1, 80);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_Sulfuras_Quality_PozSellIn() {
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros", 1, 80);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_Sulfuras_SellInDecrease(){
        createItemWithSellInAndQuality("Sulfuras, Hand of Ragnaros", 5, 80);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void test_BackstagePass_QualityIncrease_SellInGreaterThenTen() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 20, 40);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
    }

    @Test
    void test_BackstagePass_QualityIncrease_SellInLowerThanTen() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 8, 40);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void test_BackstagePass_QualityIncrease_SellInLowerThanFive() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 3, 40);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
    }

    @Test
    void test_BackstagePass_QualityDecrease_AfterSellIn() {
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", -1, 40);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void test_BackstagePass_QualityDecrease_OnSellIn(){
        createItemWithSellInAndQuality("Backstage passes to a TAFKAL80ETC concert", 0, 40);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_AgedBrie_QualityIncrease_PosSellIn_PosQuality() {
        createItemWithSellInAndQuality("Aged Brie", 10, 40);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
    }

    @Test
    void test_AgedBrie_QualityIncrease_PosSellIn_ZeroQuality(){
        createItemWithSellInAndQuality("Aged Brie", 10, 0);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void test_AgedBrie_QualityIncrease_ZeroSellIn_PosQuality(){
        createItemWithSellInAndQuality("Aged Brie", 0, 20);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void test_AgedBrie_QualityIncrease_ZeroSellIn_ZeroQuality(){
        createItemWithSellInAndQuality("Aged Brie", 0, 0);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void test_AgedBrie_QualityIncrease_NegSellIn_ZeroQuality(){
        createItemWithSellInAndQuality("Aged Brie", -1, 0);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void test_AgedBrie_QualityIncrease_NegSellIn_PosQuality(){
        createItemWithSellInAndQuality("Aged Brie", -1, 20);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void test_ConjuredItem_QualityDecrease_PosSellIn_PosQuality(){
        createItemWithSellInAndQuality("Conjured Item", 10, 20);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void test_ConjuredItem_QualityDecrease_ZeroSellIn_PosQuality(){
        createItemWithSellInAndQuality("Conjured Item", 0, 20);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void test_ConjuredItem_QualityDecrease_NegSellIn_PosQuality(){
        createItemWithSellInAndQuality("Conjured Item", -5, 20);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void test_Quality_IsNever_Under_Zero(){
        createItemWithSellInAndQuality("Normal Item", 10, 0);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_Quality_IsNever_Over50(){
        createItemWithSellInAndQuality("Aged Brie", 5, 50);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_Decrease_SellIn(){
       createItemWithSellInAndQuality("Normal Item", 5, 10);
       app.updateQuality();assertEquals(4, app.items[0].sellIn);
    }

    public void createItemWithSellInAndQuality(String name, int sellIn, int quality){
        items = new Item[]{new Item(name, sellIn, quality) };
        app = new GildedRose(items);
    }


}
