package com.sibasish.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private Timestamp timestamp;
    private Integer status;
    private String errorMessage;
    private String servicePath;
    private String controllerName;
    private String methodName;
}
