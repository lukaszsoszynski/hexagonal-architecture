package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

import java.util.Optional;

public interface SoapUserService {
    Optional<FindUserByEmailResponse> findUserByEmail(FindUserByEmail request);
}
