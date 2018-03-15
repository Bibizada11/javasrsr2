package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Delivery;
import kz.kaznitu.lessons.models.User;
import org.springframework.data.repository.CrudRepository;


public interface DeliveryRepository extends CrudRepository<Delivery,Long> {
    Delivery getUserById(long id);
}
