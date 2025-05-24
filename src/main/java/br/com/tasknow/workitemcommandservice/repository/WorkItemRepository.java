package br.com.tasknow.workitemcommandservice.repository;

import br.com.tasknow.workitemcommandservice.domain.WorkItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkItemRepository extends CrudRepository<WorkItem, UUID> {
}
