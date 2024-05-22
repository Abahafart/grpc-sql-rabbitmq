package mx.com.liverpool.framework.input.grpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.liverpool.grpc.PersonDetailsRequest;
import mx.com.liverpool.grpc.PersonDetailsResponse;
import mx.com.liverpool.grpc.PersonServiceGrpc.PersonServiceImplBase;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import mx.com.liverpool.application.usecases.PersonManagementUseCase;
import mx.com.liverpool.domain.PersonDO;
import mx.com.liverpool.framework.mappers.PersonMapper;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class PersonDetailsGrpc extends PersonServiceImplBase {

  private static final Logger log = LoggerFactory.getLogger(PersonDetailsGrpc.class);
  private final PersonManagementUseCase useCase;
  private final PersonMapper personMapper;

  @Override
  public void calculateAge(PersonDetailsRequest request,
      StreamObserver<PersonDetailsResponse> responseObserver) {
    log.info("request received: {}", request);
    PersonDO personDO = personMapper.fromRequestToModel(request);
    PersonDetailsResponse detailsResponse = personMapper.fromModelToResponse(useCase.complementData(personDO));
    log.info("response generated: {}", detailsResponse);
    responseObserver.onNext(detailsResponse);
    responseObserver.onCompleted();
  }
}
