package io.shanruan.winewiki.wine.controller;

import io.shanruan.winewiki.wine.jpa.WineEntity;
import io.shanruan.winewiki.wine.jpa.WineRepository;
import io.shanruan.winewiki.wine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // api related controller
@RequestMapping("/api") // api url eg. api/v1/wine
public class WineController {
    @Autowired
    private WineService wineService;

    @GetMapping("/hello") // define it as a get api to spring
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/wines")
    public WineEntity createWine(@RequestBody WineEntity inputWine){
        WineEntity outputWine = wineService.save(inputWine); // save will auto save the data and return the updated data in the database
        return outputWine;
        // or return wineRepository.save(inputWine);
    }

    @GetMapping("/wines")
    public List<WineEntity> getWines(){
        return wineService.findAll();
    }

    @GetMapping("/wines/{id}")
    public WineEntity getById(@PathVariable int id){
        WineEntity outputWine = wineService.findById(id);
        return outputWine;
    }

    @DeleteMapping("/wines/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        WineEntity outputWine = wineService.findById(id);
        if (outputWine != null){
            wineService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found!");
        }

    }

}
