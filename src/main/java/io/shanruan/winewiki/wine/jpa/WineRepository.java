package io.shanruan.winewiki.wine.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Integer> { //<> includes the two type objects JpaRepository will use
}
