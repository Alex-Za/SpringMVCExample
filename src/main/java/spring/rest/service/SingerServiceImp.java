package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.dao.SingerDao;
import spring.rest.entity.Singer;
import spring.rest.repository.SingerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class SingerServiceImp implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Transactional
    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        singerRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
        return singerRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}


//@Service
//@Repository
//@Transactional
//public class SingerServiceImp implements SingerService {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<Singer> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Singer> findAllWithAlbum() {
//        return null;
//    }
//
//    @Override
//    public Singer findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Singer save(Singer singer) {
//        if (singer.getId() == null) {
//            em.persist(singer);
//        } else {
//            em.merge(singer);
//        }
//        return singer;
//    }
//
//    @Override
//    public void delete(Singer singer) {
//        Singer mergedSinger = em.merge(singer);
//        em.remove(mergedSinger);
//    }
//
//    @Transactional
//    @Override
//    public List<Singer> findALlByNativeQuery() {
//        return em.createNativeQuery("SELECT * FROM singer", Singer.class).getResultList();
//    }
//}

//@Service
//public class SingerServiceImp implements SingerService {
//    @Autowired
//    private SingerDao singerDao;
//
//    @Override
//    public List<Singer> findAll() {
//        return this.singerDao.findAll();
//    }
//
//    @Override
//    public List<Singer> findAllWithAlbum() {
//        return null;
//    }
//
//    @Override
//    public Singer findById(Long id) {
//        return singerDao.findById(id);
//    }
//
//    @Override
//    public Singer save(Singer singer) {
//        this.singerDao.save(singer);
//        return singer;
//    }
//
//    @Override
//    public void delete(Singer singer) {
//        this.singerDao.delete(singer);
//    }
//}
