package spring.rest.service;

import spring.rest.entity.Album;
import spring.rest.entity.Singer;

import java.util.List;

public interface AlbumService {
    List<Album> findBySinger(Singer singer);
    List<Album> findByTitle(String title);
}
