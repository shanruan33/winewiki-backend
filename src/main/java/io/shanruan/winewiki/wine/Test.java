package io.shanruan.winewiki.wine;

import io.shanruan.winewiki.wine.jpa.GrapeEntity;
import io.shanruan.winewiki.wine.jpa.WineEntity;

public class Test {
    public static void main(String[] args) {
        WineEntity wine = new WineEntity( "redWine", "", new GrapeEntity(), "good wine");
        wine.setName("whiteWine");
        System.out.println(wine);
    }
}
