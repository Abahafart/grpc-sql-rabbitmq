package mx.com.liverpool.framework.mappers;

/**
 *
 * @param <M> domain object from domain package
 * @param <Req> request object from domain package
 * @param <Res> response object from domain object
 * @param <E> entity object from framework object
 */
public interface GenericMapper<M, Req, Res, E>{

  M fromRequestToModel(Req request);
  Res fromModelToResponse(M model);
  E fromModelToEntity(M model);
  M fromEntityToModel(E entity);
}
