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
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Sulfuras, Hand of Ragnaros", 1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", -4, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", -5, 0),
                new Item("Aged Brie", 10, 15),
                new Item("Aged Brie", 10, 0),
                new Item("Aged Brie", 0, 15),
                new Item("Aged Brie", 0, 0),
                new Item("Aged Brie", -5, 0),
                new Item("Aged Brie", -5, 10),
                new Item("Aged Brie", 10, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                new Item("Conjured Item", 10, 50),
                new Item("Conjured Item", 0, 30),
                new Item("Conjured Item", -5, 10),
                new Item("Conjured Item", 10, 0),
                new Item("Conjured Item", 0, 0),
                new Item("Conjured item", -5, 0)};
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
    void testSulfurasSellInZero(){

        assertEquals(80, app.items[6].quality);
    }

    @Test
    void testSulfurasNegSellIn(){

        assertEquals(80, app.items[7].quality);
    }

    @Test
    void testSulfurasPozSellIn() {

        assertEquals(80, app.items[8].quality);
    }

    @Test
    void testBackstagePassGreaterThanTenDays() {

        assertEquals(11, app.items[9].quality);
    }

    @Test
    void testBackstagePassTenDaysOrLower() {

        assertEquals(12, app.items[10].quality);
    }

    @Test
    void testBackstagePassFiveDaysOrLower() {
        assertEquals(13, app.items[11].quality);
    }

    @Test
    void testBackstagePassAfterSellIn() {
        assertEquals(0,app.items[12].quality);
    }

    @Test
    void testBackstagePassOnSellIn(){
        assertEquals(0, app.items[13].quality);
    }

    @Test
    void testBackStagePassZeroSellInZeroQuality(){
        assertEquals(0, app.items[14].quality);
    }

    @Test
    void testBackStagePassNegSellInZeroQuality(){
        assertEquals(0, app.items[15].quality);
    }

    @Test
    void testAgedBriePosSellInPosQuality() {
        assertEquals(16, app.items[16].quality);
    }

    @Test
    void testAgedBriePosSellInZeroQuality(){
        assertEquals(1, app.items[17].quality);
    }

    @Test
    void testAgedBrieZeroSellInPosQuality(){
        assertEquals(17, app.items[18].quality);
    }

    @Test
    void testAgedBrieZeroSellInZeroQuality(){
        assertEquals(2, app.items[19].quality);
    }

    @Test
    void testAgedBrieNegSellInZeroQuality(){
        assertEquals(2, app.items[20].quality);
    }

    @Test
    void testAgedBrieNegSellInPosQuality(){
        assertEquals(12, app.items[21].quality);
    }

    @Test
    void testAgedBrieMaxQuality(){
        assertEquals(50, app.items[22].quality);
    }

    @Test
    void testBackStagePassMaxQualityOverTenDays(){
        assertEquals(50, app.items[23].quality);
    }

    @Test
    void testBackStagePassMaxQualityOverFiveDays(){
        assertEquals(50, app.items[24].quality);
    }

    @Test
    void testBackStagePassMaxQualityOverZeroDays(){
        assertEquals(50, app.items[25].quality);
    }

    @Test
    void testConjuredItemPosSellInPosQuality(){
        assertEquals(48, app.items[26].quality);
    }

    @Test
    void testConjuredItemZeroSellInPosQuality(){
        assertEquals(26, app.items[27].quality);
    }

    @Test
    void testConjuredItemNegSellInPosQuality(){
        assertEquals(6, app.items[28].quality);
    }

    @Test
    void testConjuredItemsPozSellInZeroQuality(){
        assertEquals(0, app.items[29].quality);
    }

    @Test
    void testConjuredItemsZeroSellInZeroQuality(){
        assertEquals(0, app.items[30].quality);
    }

    @Test
    void testConjuredItemsNegSellInZeroQuality(){
        assertEquals(0, app.items[31].quality);
    }

    @Test
    void testEndDay(){
        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[1].sellIn);
        assertEquals(-2, app.items[3].sellIn);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(-1, app.items[5].sellIn);
        assertEquals(0, app.items[6].sellIn);
        assertEquals(-1, app.items[7].sellIn);
        assertEquals(1, app.items[8].sellIn);
        assertEquals(19, app.items[9].sellIn);
        assertEquals(9, app.items[10].sellIn);
        assertEquals(4, app.items[11].sellIn);
        assertEquals(-5, app.items[12].sellIn);
        assertEquals(-1, app.items[13].sellIn);
        assertEquals(-1, app.items[14].sellIn);
        assertEquals(-6, app.items[15].sellIn);
        assertEquals(9, app.items[16].sellIn);
        assertEquals(9, app.items[17].sellIn);
        assertEquals(-1, app.items[18].sellIn);
        assertEquals(-1, app.items[19].sellIn);
        assertEquals(-6, app.items[20].sellIn);
        assertEquals(-6, app.items[21].sellIn);

    }
}
