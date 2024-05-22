package mx.com.liverpool.application.ports.input;

import lombok.RequiredArgsConstructor;
import mx.com.liverpool.application.generic.ServiceApplication;
import mx.com.liverpool.application.ports.output.PersonManagementOutputPort;
import mx.com.liverpool.application.usecases.PersonManagementUseCase;
import mx.com.liverpool.domain.PersonDO;

@ServiceApplication
@RequiredArgsConstructor
public class PersonManagementInputPort implements PersonManagementUseCase {

  private final PersonManagementOutputPort managementOutputPort;

  @Override
  public PersonDO complementData(PersonDO personDO) {
    return managementOutputPort.save(personDO);
  }
}
