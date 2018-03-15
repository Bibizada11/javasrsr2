package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepository extends CrudRepository<Computer,Long> {
    Computer getUserById(long id);
}
