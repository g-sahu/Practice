package com.interviews.intercom;

public class Agent implements Comparable<Agent> {
    private String name;
    private int limit = 2;
    private int conversations;
    private long lastAssignedAt;

    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getConversations() {
        return conversations;
    }

    public void setConversations(int conversations) {
        this.conversations = conversations;
    }

    public long getLastAssignedAt() {
        return lastAssignedAt;
    }

    public void setLastAssignedAt(long lastAssignedAt) {
        this.lastAssignedAt = lastAssignedAt;
    }

    @Override
    public int compareTo(Agent agent) {
        boolean b1 = conversations >= limit;
        boolean b2 = agent.getConversations() >= agent.getLimit();
        int c1 = Boolean.compare(b1, b2);

        if (c1 == 0) {
            int c2 = Long.compare(lastAssignedAt, agent.getLastAssignedAt());
            return c2 == 0 ? name.compareToIgnoreCase(agent.getName()) : c2;
        }

        return c1;
    }
}
