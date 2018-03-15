package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User getUserById(long id);
}
