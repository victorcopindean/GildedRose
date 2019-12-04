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
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        app = new GildedRose(items);
    }

    @Test
    void testNormalItem() {
        app.updateQuality();
        assertEquals(4,app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testAgedBrie() {
        app.updateQuality();
        assertEquals(9, app.items[1].sellIn);
        assertEquals(31, app.items[1].quality);
    }

    @Test
    void testSulfuras() {
        app.updateQuality();
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
    }

    @Test
    void testBackstagePassGreaterThanTenDays() {
        app.updateQuality();
        assertEquals(19, app.items[3].sellIn);
        assertEquals(11, app.items[3].quality);
    }

    @Test
    void testBackstagePassTenDaysOrLower() {
        app.updateQuality();;
        assertEquals(9, app.items[4].sellIn);
        assertEquals(12, app.items[4].quality);
    }

    @Test
    void testBackstagePassFiveDaysOrLower() {
        app.updateQuality();
        assertEquals(4, app.items[5].sellIn);
        assertEquals(13, app.items[5].quality);
    }

}
