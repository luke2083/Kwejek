package pl.akademiakodu.kwejkapp.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.kwejkapp.entity.Mem;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by luke on 24.06.2017.
 */
@Repository

public class MemDaoStatic implements MemDao {

    private static final List<Mem> MEMS = new ArrayList<>();
    {
        Mem m1 = new Mem();
        m1.setId(1L);
        m1.setTitle("Czarny śpiewa");
        m1.setDescription("Opis");
        m1.setTimestamp(LocalDateTime.now());
        m1.setImagePath("cos.gif");
        m1.setVisitCount(0);

        Mem m2 = new Mem();
        m2.setId(2L);
        m2.setTitle("Cos jedzie");
        m2.setDescription("Opis");
        m2.setTimestamp(LocalDateTime.now());
        m2.setImagePath("prodigy.gif");
        m2.setVisitCount(0);

        Mem m3 = new Mem();
        m3.setId(3L);
        m3.setTitle("Misiek tańczy");
        m3.setDescription("Opis");
        m3.setTimestamp(LocalDateTime.now());
        m3.setImagePath("czarny.gif");
        m3.setVisitCount(0);

        MEMS.add(m1);
        MEMS.add(m2);
        MEMS.add(m3);
    }

    @Override
    public List<Mem> findAll() {
        return MEMS;
    }

    @Override
    public Mem findById(Long id) {
        for (Mem m : MEMS) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void update(Mem mem) {
        MEMS.add(mem);
    }

    @Override
    public Mem getRandom() {
        Random r = new Random();
        int size = MEMS.size();
        long id = r.nextInt(size) + 1;
        System.out.println("id =" + id);
        for (Mem m : MEMS) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void save(Mem mem) {
        MEMS.add(mem);
    }


}
