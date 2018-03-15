package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Dostavka;
import org.springframework.data.repository.CrudRepository;


public interface DostavkaRepository extends CrudRepository<Dostavka,Long> {
    Dostavka getUserById(long id);
}
