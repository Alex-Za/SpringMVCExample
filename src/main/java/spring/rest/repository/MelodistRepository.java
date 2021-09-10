package spring.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.rest.entity.Melodist;

public interface MelodistRepository extends PagingAndSortingRepository<Melodist, Long> {
}
