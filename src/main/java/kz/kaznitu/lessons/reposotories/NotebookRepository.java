package kz.kaznitu.lessons.reposotories;

import kz.kaznitu.lessons.models.Delivery;
import kz.kaznitu.lessons.models.Notebook;
import org.springframework.data.repository.CrudRepository;

public interface NotebookRepository extends CrudRepository<Notebook,Long> {
    Notebook getUserById(long id);
}
