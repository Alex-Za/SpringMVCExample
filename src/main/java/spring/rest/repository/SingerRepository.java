package spring.rest.repository;

import org.springframework.data.repository.CrudRepository;
import spring.rest.entity.Singer;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
