package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;
    GildedRose app;

    @BeforeEach
    void setUp() {
        items = new Item[]{
                new Item("NormalItem", 5, 50),
                new Item("NormalItemPozSellInZeroQuality", 4, 0),
                new Item("NormalItemNegSellInZeroQuality", -1, 0),
                new Item("NormalItemNegSellInPozQuality", -1, 40),
                new Item("NormalItemZeroSellInPozQuality",0, 20 ),
                new Item("NormalItemZeroSellInZeroQuality", 0, 0),
                new Item("Aged Brie", 10, 30),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Sulfuras, Hand of Ragnaros", 1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", -4, 40)};
        app = new GildedRose(items);
        app.updateQuality();
    }

    @Test
    void testNormalItem() {
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testNormalItemPozSellInZeroQuality() {
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void testNormalItemNegativeSellInZeroQuality(){
        assertEquals(0, app.items[2].quality);
    }

    @Test
    void testNormalItemNegativeSellInPozQuality(){
        assertEquals(38, app.items[3].quality);
    }

    @Test
    void testNormalItemZeroSellInPozQuality(){
        assertEquals(18, app.items[4].quality);
    }

    @Test
    void testNormalItemZeroSellInZeroQuality() {
        assertEquals(0, app.items[5].quality);
    }

    @Test
    void testAgedBrie() {
        assertEquals(31, app.items[6].quality);
    }

    @Test
    void testSulfurasSellInZero(){
        assertEquals(80, app.items[7].quality);
    }

    @Test
    void testSulfurasNegSellIn(){
        assertEquals(80, app.items[8].quality);
    }

    @Test
    void testSulfurasPozSellIn() {
        assertEquals(80, app.items[9].quality);
    }

    @Test
    void testBackstagePassGreaterThanTenDays() {
        assertEquals(11, app.items[10].quality);
    }

    @Test
    void testBackstagePassTenDaysOrLower() {
        assertEquals(12, app.items[11].quality);
    }

    @Test
    void testBackstagePassFiveDaysOrLower() {
        assertEquals(13, app.items[12].quality);
    }

    @Test
    void testBackstagePassAfterSellIn() {
        assertEquals(0,app.items[13].quality);
    }

    /*@Test
    void testQualityIncreaseBrieAfterSellIn() {
        assertEquals(41, app.items[8].quality);
    }*/

}
