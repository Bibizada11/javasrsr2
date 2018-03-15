package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.TelePhone;
import org.springframework.data.repository.CrudRepository;

public interface TelePhoneRepository extends CrudRepository<TelePhone, Long> {
    TelePhone getUserById(long id);
}
