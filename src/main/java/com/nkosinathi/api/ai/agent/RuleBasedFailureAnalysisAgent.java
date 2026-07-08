package com.nkosinathi.api.ai.agent;

import com.nkosinathi.api.ai.model.FailureContext;

public class RuleBasedFailureAnalysisAgent
        implements FailureAnalysisAgent {

    @Override
    public String analyze(FailureContext context) {

        String response = context.getResponseBody();

        if (context.getActualStatus() == 500 &&
                response.contains("MethodArgumentNotValidException")) {

            return """
                    AI Root Cause Analysis

                    Validation executed successfully.

                    The API threw MethodArgumentNotValidException.

                    However, the exception was converted into HTTP 500.

                    Expected:
                    HTTP 400 Bad Request

                    Recommendation:
                    Create an exception handler for
                    MethodArgumentNotValidException.
                    """;
        }

        if (context.getActualStatus() == 404) {
            return "Endpoint not found.";
        }

        if (context.getActualStatus() == 401) {
            return "Authentication failure.";
        }

        return "No AI diagnosis available.";
    }
}