package spring.rest.service;

import spring.rest.entity.Singer;

import java.util.List;

public interface SingerService {
//    List<Singer> findAll();
//    List<Singer> findAllWithAlbum();
//    Singer findById(Long id);
//    Singer save(Singer contact);
//    void delete(Singer contact);
//    List<Singer> findALlByNativeQuery();
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
