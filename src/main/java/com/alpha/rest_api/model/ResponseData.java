package com.alpha.rest_api.model;

public enum ResponseData {

    Success("This operation was successful"),
    Failure("This operation was successful");

    ResponseData(String value) {
        this.value = value;
    }

    String value;
}
