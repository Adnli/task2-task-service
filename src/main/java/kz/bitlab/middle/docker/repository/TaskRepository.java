package kz.bitlab.middle.docker.repository;

import kz.bitlab.middle.docker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByAuthorId(Long authorId);

    Task findTaskById(Long id);
}
