package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks,
                    Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String employee) {
        return switch (employee.toLowerCase()) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            case "all" -> getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default -> new HashSet<>();
        };
    }

    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... taskSets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> taskSet : taskSets) {
            union.addAll(taskSet);
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> firstSet, Set<Task> secondSet) {
        Set<Task> intersection = new HashSet<>(firstSet);
        intersection.retainAll(secondSet);
        return intersection;
    }

    public Set<Task> getIntersect(Set<Task> firstSet, Set<Task> secondSet) {
        return getIntersection(firstSet, secondSet);
    }

    public Set<Task> getDifferences(Set<Task> firstSet, Set<Task> secondSet) {
        Set<Task> difference = new HashSet<>(firstSet);
        difference.removeAll(secondSet);
        return difference;
    }

    public Set<Task> getDifference(Set<Task> firstSet, Set<Task> secondSet) {
        return getDifferences(firstSet, secondSet);
    }
}
