package pl.akademiakodu.kwejkapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.kwejkapp.entity.Mem;

import java.util.*;

/**
 * Created by luke on 25.06.2017.
 */

@Repository
@Primary
public class MemDaoImpl implements MemDao {

    @Autowired
    MemDaoCrud memDaoCrud;

    @Override
    public List<Mem> findAll() {
        Iterable<Mem> coll = memDaoCrud.findAllSortedByTimestampDesc();
        List<Mem> mems = new ArrayList<>();
        coll.forEach(mems::add);
        return mems;
    }

    @Override
    public Mem findById(Long id) {
        return memDaoCrud.findOne(id);
    }

    @Override
    public void update(Mem mem) {
        this.save(mem);
    }

    @Override
    public Mem getRandom() {
        List<Long> list = memDaoCrud.findAllIds();
        int size = list.size();
        System.out.println("Rozmiar: " + size);
        Random r = new Random();
        int random = r.nextInt(size);
        System.out.println("Losowy ID: " + random);
        Mem m = this.findById(list.get(random));
        return m;
    }

    @Override
    public void save(Mem mem) {
        memDaoCrud.save(mem);
    }
}
