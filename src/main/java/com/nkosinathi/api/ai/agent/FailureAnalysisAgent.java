package com.nkosinathi.api.ai.agent;

import com.nkosinathi.api.ai.model.FailureContext;

public interface  FailureAnalysisAgent {

    String analyze(FailureContext context);
}
