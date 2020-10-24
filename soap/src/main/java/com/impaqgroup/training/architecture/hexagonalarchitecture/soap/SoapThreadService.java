package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

public interface SoapThreadService {
    void commenceNewThread(CommenceNewThread commenceNewThread);

    ListAllThreadsResponse listAllThread(ListAllThreads listAllThreads);
}
