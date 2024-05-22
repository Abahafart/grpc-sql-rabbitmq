package mx.com.liverpool.framework.output.postgresql.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "persons")
public class PersonEntity {

  @Id
  private Long id;
  private String name;
  private String email;
  private Integer age;
  private String state;
}
