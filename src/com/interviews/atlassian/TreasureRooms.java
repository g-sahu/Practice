package com.interviews.atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
    You are with your friends in a castle, where there are multiple rooms named after flowers.
    Some of the rooms contain treasures - we call them the treasure rooms.
    Each room contains a single instruction that tells you which room to go to next.

     *** instructions_1 ***

     lily ---------     daisy  sunflower
                   |       |     |
                   v       v     v
     jasmin ->  tulip      violet    -> rose --->
                ^    |      ^             ^     |
                |    |      |             |     |
                ------    iris            -------

    This is given as a list of pairs of (source_room, destination_room)

    instructions_1 = [
        ["jasmin", "tulip"],
        ["lily", "tulip"],
        ["tulip", "tulip"],
        ["rose", "rose"],
        ["violet", "rose"],
        ["sunflower", "violet"],
        ["daisy", "violet"],
        ["iris", "violet"]
    ]

    Write a function that takes two parameters as input:
    * a list containing the treasure rooms, and
    * a list of instructions represented as pairs of (source_room, destination_room)

    and returns a collection of all the rooms that satisfy the following two conditions:

    * at least two *other* rooms have instructions pointing to this room
    * this room's instruction immediately points to a treasure room

    treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]

    filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
    * tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (tulip itself)
    * violet can be accessed from daisy, sunflower and iris. Violet's instruction points to a treasure room (rose)

    Additional inputs

    treasure_rooms_2 = ["lily", "jasmin", "violet"]

    filter_rooms(treasure_rooms_2, instructions_1) => []
    * none of the rooms reachable from tulip or violet are treasure rooms

     *** instructions_2 ***

     lily --------             ------
                   |          |      |
                   v          v      |
     jasmin ->  tulip -- > violet ---^

    instructions_2 = [
        ["jasmin", "tulip"],
        ["lily", "tulip"],
        ["tulip", "violet"],
        ["violet", "violet"]
    ]

    treasure_rooms_3 = ["violet"]

    filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
    * tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (violet)

    All the test cases:
    filter_rooms(treasure_rooms_1, instructions_1)    => ["tulip", "violet"]
    filter_rooms(treasure_rooms_2, instructions_1)    => []
    filter_rooms(treasure_rooms_3, instructions_2)    => [tulip]

    Complexity Analysis variables:
    T: number of treasure rooms
    I: number of instructions given
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
