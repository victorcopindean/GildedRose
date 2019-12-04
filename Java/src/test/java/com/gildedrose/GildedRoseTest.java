package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;
    GildedRose app;

    @BeforeEach
    void setUp() {
        items = new Item[] {
                new Item("NormalItem", 5, 50),
                new Item("Aged Brie", 10, 30),
                new Item("Sulfuras, Hand of Ragnaros", 0,80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", -4, 40),
                new Item("NormalItemPassedSellIn", -1, 40),
                new Item("Aged Brie", -1, 40)};
        app = new GildedRose(items);
    }

    @Test
    void testNormalItem() {
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testAgedBrie() {
        app.updateQuality();
        assertEquals(31, app.items[1].quality);
    }

    @Test
    void testSulfuras() {
        app.updateQuality();
        assertEquals(80, app.items[2].quality);
    }

    @Test
    void testBackstagePassGreaterThanTenDays() {
        app.updateQuality();
        assertEquals(11, app.items[3].quality);
    }

    @Test
    void testBackstagePassTenDaysOrLower() {
        app.updateQuality();;
        assertEquals(12, app.items[4].quality);
    }

    @Test
    void testBackstagePassFiveDaysOrLower() {
        app.updateQuality();
        assertEquals(13, app.items[5].quality);
    }

    @Test
    void testBackstagePassAfterSellIn() {
        app.updateQuality();
        assertEquals(0,app.items[6].quality);
    }

    @Test
    void testQualityDegradeAfterSellIn() {
        app.updateQuality();
        assertEquals(38, app.items[7].quality);
    }

    @Test
    void testQualityIncreaseBrieAfterSellIn() {
        app.updateQuality();
        assertEquals(41, app.items[8].quality);
    }

}
