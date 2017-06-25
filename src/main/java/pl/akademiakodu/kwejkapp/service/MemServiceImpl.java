package pl.akademiakodu.kwejkapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.kwejkapp.dao.MemDao;
import pl.akademiakodu.kwejkapp.entity.Mem;

import java.util.List;

/**
 * Created by luke on 24.06.2017.
 */

@Service
public class MemServiceImpl implements MemService {

    @Autowired
    MemDao memDao;

    @Override
    public List<Mem> getList() {
        return memDao.findAll();
    }

    @Override
    public Mem findById(Long id) {
        Mem m = memDao.findById(id);
        m.increaseCount();
        return m;
    }

    @Override
    public Mem getRandom() {
        Mem m = memDao.getRandom();
        m.increaseCount();
        return m;
    }

    @Override
    public void save(Mem mem) {
        memDao.save(mem);
    }

}
