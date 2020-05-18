package io.shanruan.winewiki.wine.jpa;

import javax.persistence.*;

@Entity
@Table(name = "wine")
public class WineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //; will stop annotation going further
    private String name;
    private String imgUrl;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //delete this wine === delete this grape, provide data in wine table and grape table at the same time, can be Lazy, means not the same time.
    @JoinColumn(name = "grape_id")
    private GrapeEntity grape;
    private String description;

    //empty constructor

    public WineEntity() {
    }

    // constructor
    public WineEntity(String name, String imgUrl, GrapeEntity grape, String description) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.grape = grape;
        this.description = description;
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int idx) {
        this.id = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public GrapeEntity getGrape() {
        return grape;
    }

    public void setGrape(GrapeEntity grape) {
        this.grape = grape;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //toString
    @Override
    public String toString() {
        return "WineEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", grape=" + grape +
                ", description='" + description + '\'' +
                '}';
    }
}
