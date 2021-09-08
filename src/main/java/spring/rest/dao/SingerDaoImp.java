package spring.rest.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.rest.entity.Singer;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SingerDaoImp implements SingerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Override
    public Singer findById(Long id) {
        return sessionFactory.getCurrentSession().get(Singer.class, id);
    }

    @Transactional
    @Override
    public Singer save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
    }
}
