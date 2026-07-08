package com.nkosinathi.api.ai.service;

import com.nkosinathi.api.ai.agent.FailureAnalysisAgent;
import com.nkosinathi.api.ai.agent.RuleBasedFailureAnalysisAgent;
import com.nkosinathi.api.ai.model.FailureContext;

public class AIService {

    private final FailureAnalysisAgent agent =
            new RuleBasedFailureAnalysisAgent();

    public void analyze(FailureContext context) {

        String analysis = agent.analyze(context);

        System.out.println();
        System.out.println("========== AI ANALYSIS ==========");
        System.out.println(analysis);
        System.out.println("================================");
    }
}