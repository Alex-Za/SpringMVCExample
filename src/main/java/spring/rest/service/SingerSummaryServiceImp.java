package spring.rest.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.entity.SingerSummary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
@Transactional
public class SingerSummaryServiceImp implements SingerSummaryService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<SingerSummary> findAll() {
        List<SingerSummary> result = em.createQuery(
                "SELECT new spring.rest.entity.SingerSummary(s.firstName, s.lastName) from Singer s",
                SingerSummary.class) .getResultList();
        return result;
    }


}
