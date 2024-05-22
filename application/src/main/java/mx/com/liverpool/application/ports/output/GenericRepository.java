package mx.com.liverpool.application.ports.output;

/**
 *
 * @param <M> domain object from domain package
 */
public interface GenericRepository<M> {

  M save(M model);
  M getById(String id);
  void delete(String id);

}
