package mx.com.liverpool.framework.output.postgresql.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.liverpool.framework.output.postgresql.data.PersonEntity;

public interface PersonManagementRepository extends JpaRepository<PersonEntity, Long> {

}
