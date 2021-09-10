package spring.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.rest.entity.Melodist;

import java.util.List;

public interface MelodistService {
    List<Melodist> findAll();
    Melodist findById(Long id);
    Melodist save(Melodist melodist);
    Page<Melodist> findAllByPage(Pageable pageable);
}
