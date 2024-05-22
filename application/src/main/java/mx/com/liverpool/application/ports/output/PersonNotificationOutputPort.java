package mx.com.liverpool.application.ports.output;

import mx.com.liverpool.domain.PersonDO;

public interface PersonNotificationOutputPort {

  void sendNotification(PersonDO personDO);

}
