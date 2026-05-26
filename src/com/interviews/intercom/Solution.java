package com.interviews.intercom;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        testAssignsToAlphabeticallyFirstWhenAgentsHaveNeverBeenAssigned();
        testAssignsToAgentNotAssignedForLongestTime();
        testDefaultsLimitToTwoWhenLimitIsNotSet();
        testSkipsAgentsWhoReachedTheirLimit();
        testSetLimitMatchesAgentNamesCaseInsensitively();
        testInitOrderDoesNotAffectAlphabeticalTieBreak();
        testSetLimitReordersPriorityQueueAfterMutation();

        System.out.println("All AssignmentSystem tests passed.");
    }

    private static void testAssignsToAlphabeticallyFirstWhenAgentsHaveNeverBeenAssigned() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Charlie", "Archie", "Bob" });

        assertAssignedAgents(
                List.of("Archie", "Bob", "Charlie"),
                assignmentSystem.assign(new int[] { 101, 102, 103 }),
                "fairly distributes conversations and uses alphabetical order only to break initial ties");
    }

    private static void testAssignsToAgentNotAssignedForLongestTime() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Archie", "Bob", "Charlie" });

        assertAssignedAgents(
                List.of("Archie"),
                assignmentSystem.assign(new int[] { 201 }),
                "first assignment goes to Archie");

        assertAssignedAgents(
                List.of("Bob"),
                assignmentSystem.assign(new int[] { 202 }),
                "next assignment goes to the agent not assigned for the longest time");

        assertAssignedAgents(
                List.of("Charlie"),
                assignmentSystem.assign(new int[] { 203 }),
                "Charlie is now the agent not assigned for the longest time");
    }

    private static void testDefaultsLimitToTwoWhenLimitIsNotSet() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Archie", "Bob" });

        assertAssignedAgents(
                List.of("Archie", "Bob", "Archie", "Bob"),
                assignmentSystem.assign(new int[] { 301, 302, 303, 304 }),
                "agents without explicit limits can each receive two conversations");

        assertAssignedAgents(
                List.of(),
                assignmentSystem.assign(new int[] { 305, 306 }),
                "agents without explicit limits cannot receive more than two conversations");
    }

    private static void testSkipsAgentsWhoReachedTheirLimit() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Archie", "Bob", "Charlie" });
        assignmentSystem.setLimit("Archie", 1);
        assignmentSystem.setLimit("Bob", 4);
        assignmentSystem.setLimit("Charlie", 3);

        assertAssignedAgents(
                List.of("Archie"),
                assignmentSystem.assign(new int[] { 401 }),
                "Archie receives the first conversation");

        assertAssignedAgents(
                List.of("Bob", "Charlie", "Bob", "Charlie"),
                assignmentSystem.assign(new int[] { 402, 403, 404, 405 }),
                "conversations are fairly distributed between available agents after Archie reaches limit");

        assertAssignedAgents(
                List.of("Bob", "Charlie"),
                assignmentSystem.assign(new int[] { 406, 407 }),
                "agents with remaining capacity continue to be selected by last assigned time");
    }

    private static void testSetLimitMatchesAgentNamesCaseInsensitively() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Archie", "Bob" });
        assignmentSystem.setLimit("archie", 1);
        assignmentSystem.setLimit("BOB", 2);

        assertAssignedAgents(
                List.of("Archie"),
                assignmentSystem.assign(new int[] { 501 }),
                "lowercase limit update applies to Archie");

        assertAssignedAgents(
                List.of("Bob", "Bob"),
                assignmentSystem.assign(new int[] { 502, 503 }),
                "uppercase limit update applies to Bob and Archie is skipped after reaching limit");
    }

    private static void testInitOrderDoesNotAffectAlphabeticalTieBreak() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Charlie", "bob", "archie" });
        assignmentSystem.setLimit("Charlie", 1);
        assignmentSystem.setLimit("bob", 1);
        assignmentSystem.setLimit("archie", 1);

        assertAssignedAgents(
                List.of("archie"),
                assignmentSystem.assign(new int[] { 601 }),
                "alphabetical tie-break is independent of init order");
    }

    private static void testSetLimitReordersPriorityQueueAfterMutation() {
        AssignmentSystem assignmentSystem = new AssignmentSystem();
        assignmentSystem.init(new String[] { "Archie", "Bob" });

        assertAssignedAgents(
                List.of("Archie"),
                assignmentSystem.assign(new int[] { 701 }),
                "Archie receives the first conversation");

        assignmentSystem.setLimit("Bob", 0);

        assertAssignedAgents(
                List.of("Archie"),
                assignmentSystem.assign(new int[] { 702 }),
                "setLimit should reorder the queue when Bob becomes unavailable");
    }

    private static void assertAssignedAgents(List<String> expected, List<String> actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(testName + " failed. Expected: " + expected + ", actual: " + actual);
        }
    }

}
