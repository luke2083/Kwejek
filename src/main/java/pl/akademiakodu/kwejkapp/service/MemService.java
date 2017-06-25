package pl.akademiakodu.kwejkapp.service;

import pl.akademiakodu.kwejkapp.entity.Mem;

import java.util.List;

/**
 * Created by luke on 24.06.2017.
 */
public interface MemService {

    List<Mem> getList();
    Mem findById(Long id);
    Mem getRandom();
    void save(Mem mem);

}
