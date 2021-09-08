package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rest.dao.SingerDao;
import spring.rest.entity.Singer;

import java.util.List;

@Service
public class SingerServiceImp implements SingerService {
    @Autowired
    private SingerDao singerDao;

    @Override
    public List<Singer> findAll() {
        return this.singerDao.findAll();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Override
    public Singer findById(Long id) {
        return singerDao.findById(id);
    }

    @Override
    public Singer save(Singer singer) {
        this.singerDao.save(singer);
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        this.singerDao.delete(singer);
    }
}
