package spring.rest.dao;

import spring.rest.entity.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer contact);
    void delete(Singer contact);
}
