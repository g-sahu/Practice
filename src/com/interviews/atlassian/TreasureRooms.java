package com.interviews.atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * You are with your friends in a castle, where there are multiple rooms named after flowers.
 * Some of the rooms contain treasures. We call them the treasure rooms. Each room contains a single
 * instruction that tells you which room to go to next.
 *
 * <h2>Instructions 1</h2>
 * <pre>
 * lily ---------     daisy  sunflower
 *               |       |     |
 *               v       v     v
 * jasmin ->  tulip      violet    -> rose --->
 *            ^    |      ^             ^     |
 *            |    |      |             |     |
 *            ------    iris            -------
 * </pre>
 *
 * <p>This is given as a list of pairs of {@code (source_room, destination_room)}:</p>
 *
 * <pre>
 * instructions_1 = [
 *     ["jasmin", "tulip"],
 *     ["lily", "tulip"],
 *     ["tulip", "tulip"],
 *     ["rose", "rose"],
 *     ["violet", "rose"],
 *     ["sunflower", "violet"],
 *     ["daisy", "violet"],
 *     ["iris", "violet"]
 * ]
 * </pre>
 *
 * <p>Write a function that takes two parameters as input:</p>
 *
 * <ul>
 *     <li>A list containing the treasure rooms.</li>
 *     <li>A list of instructions represented as pairs of {@code (source_room, destination_room)}.</li>
 * </ul>
 *
 * <p>Return a collection of all the rooms that satisfy the following two conditions:</p>
 *
 * <ul>
 *     <li>At least two <em>other</em> rooms have instructions pointing to this room.</li>
 *     <li>This room's instruction immediately points to a treasure room.</li>
 * </ul>
 *
 * <pre>
 * treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]
 *
 * filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
 * </pre>
 *
 * <ul>
 *     <li>{@code tulip} can be accessed from rooms {@code lily} and {@code jasmin}. Tulip's
 *     instruction points to a treasure room, {@code tulip} itself.</li>
 *     <li>{@code violet} can be accessed from {@code daisy}, {@code sunflower}, and {@code iris}.
 *     Violet's instruction points to a treasure room, {@code rose}.</li>
 * </ul>
 *
 * <h2>Additional Inputs</h2>
 * <pre>
 * treasure_rooms_2 = ["lily", "jasmin", "violet"]
 *
 * filter_rooms(treasure_rooms_2, instructions_1) => []
 * </pre>
 *
 * <p>None of the rooms reachable from {@code tulip} or {@code violet} are treasure rooms.</p>
 *
 * <h2>Instructions 2</h2>
 * <pre>
 * lily --------             ------
 *               |          |      |
 *               v          v      |
 * jasmin ->  tulip -- > violet ---^
 * </pre>
 *
 * <pre>
 * instructions_2 = [
 *     ["jasmin", "tulip"],
 *     ["lily", "tulip"],
 *     ["tulip", "violet"],
 *     ["violet", "violet"]
 * ]
 *
 * treasure_rooms_3 = ["violet"]
 *
 * filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
 * </pre>
 *
 * <p>{@code tulip} can be accessed from rooms {@code lily} and {@code jasmin}. Tulip's instruction
 * points to a treasure room, {@code violet}.</p>
 *
 * <h2>All Test Cases</h2>
 * <pre>
 * filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
 * filter_rooms(treasure_rooms_2, instructions_1) => []
 * filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
 * </pre>
 *
 * <h2>Complexity Analysis Variables</h2>
 * <ul>
 *     <li>{@code T}: number of treasure rooms</li>
 *     <li>{@code I}: number of instructions given</li>
 * </ul>
 */
public class TreasureRooms {
    public static void main(String[] argv) {
        String[][] instructions_1 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "tulip"},
                {"rose", "rose"},
                {"violet", "rose"},
                {"sunflower", "violet"},
                {"daisy", "violet"},
                {"iris", "violet"}
        };

        String[][] instructions_2 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "violet"},
                {"violet", "violet"}
        };

        String[] treasure_rooms_1 = {"lily", "tulip", "violet", "rose"};
        String[] treasure_rooms_2 = {"lily", "jasmin", "violet"};
        String[] treasure_rooms_3 = {"violet"};

        TreasureRooms tr = new TreasureRooms();
        tr.filterRooms(instructions_2, treasure_rooms_3);
    }

    private List<String> filterRooms(String[][] instructions, String[] rooms) {
        Map<String, String> map = buildMap(instructions);
        String[] roomsCopy = Arrays.copyOf(rooms, rooms.length);
        Arrays.sort(roomsCopy);
        List<String> list = new ArrayList<>();

        for (String room : roomsCopy) {
            String val = map.get(room);

            //Search for val in rooms[]
            if (Arrays.binarySearch(roomsCopy, val) < 0) {
                continue;
            }

            AtomicInteger c = new AtomicInteger();

            //Iterate over the map
            map.forEach((k, v) -> {
                if(v.equals(room) && !k.equals(room)) {
                    c.getAndIncrement();
                }
            });

            if(c.get() >= 2) {
                list.add(room);
            }
        }

        return list;
    }

    private static Map<String, String> buildMap(String[][] ins) {
        Map<String, String> map = new HashMap<>();

        for (String[] arr : ins) {
            map.put(arr[0], arr[1]);
        }

        return map;
    }
}
