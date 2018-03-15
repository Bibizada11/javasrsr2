package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
    Phone getUserById(long id);
}
