package mx.com.liverpool.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDO {

  private String id;
  private String name;
  private String email;
  private Integer age;
  private String state;
  private Long trackId;

}
