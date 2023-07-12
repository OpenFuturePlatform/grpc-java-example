package io.openfuture.employee.service;

import io.openfuture.constants.Role;
import io.openfuture.employee.EmployeeRequest;
import io.openfuture.employee.EmployeeResponse;
import io.openfuture.employee.EmployeeServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class EmployeeService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    @Override
    public void getEmployee(EmployeeRequest request,
                            StreamObserver<EmployeeResponse> responseObserver) {

        //call repository to load the data from database
        //we have added static data for example
        EmployeeResponse empResp = EmployeeResponse
                .newBuilder()
                .setEmpId(request.getEmpId())
                .setName("abc")
                .setRole(Role.USER)
                .build();

        //set the response object
        responseObserver.onNext(empResp);

        //mark process is completed
        responseObserver.onCompleted();
    }
}
