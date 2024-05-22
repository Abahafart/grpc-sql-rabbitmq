package mx.com.liverpool.framework.mappers;

import org.mapstruct.Mapper;

import mx.com.liverpool.grpc.PersonDetailsRequest;
import mx.com.liverpool.grpc.PersonDetailsResponse;

import mx.com.liverpool.domain.PersonDO;
import mx.com.liverpool.framework.config.MappingConfig;
import mx.com.liverpool.framework.output.postgresql.data.PersonEntity;

@Mapper(config = MappingConfig.class)
public interface PersonMapper extends GenericMapper<PersonDO, PersonDetailsRequest, PersonDetailsResponse, PersonEntity> {

}
