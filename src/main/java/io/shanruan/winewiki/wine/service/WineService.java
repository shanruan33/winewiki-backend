package io.shanruan.winewiki.wine.service;

import io.shanruan.winewiki.wine.jpa.WineEntity;

import java.util.List;

public interface WineService {
    WineEntity save(WineEntity inputWine);

    List<WineEntity> findAll();

    WineEntity findById(int id);

    void deleteById(int id);

}
