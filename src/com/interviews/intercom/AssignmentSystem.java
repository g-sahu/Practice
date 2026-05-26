package com.interviews.intercom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

public class AssignmentSystem {
    private final Map<String, Agent> agentMap = new HashMap<>();
    private final TreeSet<Agent> availableAgents = new TreeSet<>();
    private long assignmentSequence;

    public void init(String[] agentNames) {
        agentMap.clear();
        availableAgents.clear();
        assignmentSequence = 0;

        for (String agentName : agentNames) {
            Agent agent = new Agent(agentName);
            agentMap.put(getAgentKey(agentName), agent);
            availableAgents.add(agent);
        }
    }

    public void setLimit(String agentName, int limit) {
        Agent matchedAgent = agentMap.get(getAgentKey(agentName));

        if (matchedAgent != null) {
            availableAgents.remove(matchedAgent);
            matchedAgent.setLimit(limit);

            if (matchedAgent.getConversations() < matchedAgent.getLimit()) {
                availableAgents.add(matchedAgent);
            }
        }
    }

    public List<String> assign(int[] conversationIds) {
        List<String> result = new ArrayList<>();

        for (int id: conversationIds) {
            Agent agent = availableAgents.pollFirst();
            if (agent == null) {
                break;
            }

            agent.setConversations(agent.getConversations() + 1);
            agent.setLastAssignedAt(++assignmentSequence);

            if (agent.getConversations() < agent.getLimit()) {
                availableAgents.add(agent);
            }
            result.add(agent.getName());
        }

        return result;
    }

    private String getAgentKey(String agentName) {
        return agentName.toLowerCase(Locale.ROOT);
    }
}
