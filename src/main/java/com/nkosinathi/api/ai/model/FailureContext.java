package com.nkosinathi.api.ai.model;

public class FailureContext {

    private String endpoint;
    private String httpMethod;

    private int expectedStatus;
    private int actualStatus;

    private String requestBody;
    private String responseBody;

    private String assertionMessage;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public int getExpectedStatus() {
        return expectedStatus;
    }

    public void setExpectedStatus(int expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    public int getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(int actualStatus) {
        this.actualStatus = actualStatus;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getAssertionMessage() {
        return assertionMessage;
    }

    public void setAssertionMessage(String assertionMessage) {
        this.assertionMessage = assertionMessage;
    }
}