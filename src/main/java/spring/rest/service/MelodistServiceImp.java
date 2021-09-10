package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.entity.Melodist;
import spring.rest.repository.MelodistRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class MelodistServiceImp implements MelodistService {
    @Autowired
    private MelodistRepository melodistRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Melodist> findAll() {
        List<Melodist> result = new ArrayList<>();
        melodistRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Melodist findById(Long id) {
        return melodistRepository.findById(id).get();
    }

    @Override
    public Melodist save(Melodist melodist) {
        return melodistRepository.save(melodist);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Melodist> findAllByPage(Pageable pageable) {
        return melodistRepository.findAll(pageable);
    }
}
