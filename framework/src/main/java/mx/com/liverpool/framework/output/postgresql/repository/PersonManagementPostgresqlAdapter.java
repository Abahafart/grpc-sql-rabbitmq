package mx.com.liverpool.framework.output.postgresql.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.liverpool.application.ports.output.PersonManagementOutputPort;
import mx.com.liverpool.domain.PersonDO;
import mx.com.liverpool.domain.exception.InformationNotFoundException;
import mx.com.liverpool.framework.mappers.PersonMapper;
import mx.com.liverpool.framework.output.postgresql.data.PersonEntity;
import mx.com.liverpool.framework.output.postgresql.repository.jpa.PersonManagementRepository;

@Repository
@RequiredArgsConstructor
public class PersonManagementPostgresqlAdapter implements PersonManagementOutputPort {

  private static final Logger log = LoggerFactory.getLogger(PersonManagementPostgresqlAdapter.class);
  private final PersonManagementRepository repository;
  private final PersonMapper personMapper;

  @Override
  public PersonDO save(PersonDO model) {
    PersonEntity entity = personMapper.fromModelToEntity(model);
    entity.setAge(25);
    entity.setState("Mexico City");
    PersonDO personDO = personMapper.fromEntityToModel(repository.save(entity));
    personDO.setId(model.getId());
    return personMapper.fromEntityToModel(repository.save(entity));
  }

  @Override
  public PersonDO getById(String id) {
    return personMapper.fromEntityToModel(repository.findById(Long.parseLong(id))
        .orElseThrow(() -> new InformationNotFoundException(String.format("Person with id '%s' not found", id))));
  }

  @Override
  public void delete(String id) {
    repository.findById(Long.parseLong(id)).ifPresent(entity -> {
      log.info("Deleting person with id '{}'", id);
      repository.delete(entity);
    });
  }
}
