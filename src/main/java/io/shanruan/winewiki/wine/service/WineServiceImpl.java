package io.shanruan.winewiki.wine.service;

import io.shanruan.winewiki.wine.jpa.WineEntity;
import io.shanruan.winewiki.wine.jpa.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService {
    @Autowired
    private WineRepository wineRepository;
    @Override
    public WineEntity save(WineEntity inputWine) {
        WineEntity outputWine = wineRepository.save(inputWine); // save will auto save the data and return the updated data in the database
        return outputWine;
    }

    @Override
    public List<WineEntity> findAll() {
        return wineRepository.findAll();
    }

    @Override
    public WineEntity findById(int id) {
        Optional<WineEntity> wineEntityOptional = wineRepository.findById(id);
        WineEntity outputWine = wineEntityOptional.orElse(null);
//        WineEntity outputWine;
//        if(wineEntityOptional.isPresent()){
//            outputWine = wineEntityOptional.get();
//        }else{
//            outputWine=null;
//        }
        return outputWine;
    }

    @Override
    public void deleteById(int id) {
        wineRepository.deleteById(id);
    }

}
