package pl.akademiakodu.kwejkapp.dao;

import pl.akademiakodu.kwejkapp.entity.Mem;

import java.util.List;

/**
 * Created by luke on 24.06.2017.
 */
public interface MemDao {

    List<Mem> findAll();
    Mem findById(Long id);
    void update(Mem mem);

    Mem getRandom();

    void save(Mem mem);
}
