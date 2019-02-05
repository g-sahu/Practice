package com.practice.game.snake;

import java.util.List;

import javafx.util.Pair;

public class Snake implements Runnable {
	static final String LEFT = "LEFT";
	static final String RIGHT = "RIGHT";
	static final String UP = "UP";
	static final String DOWN = "DOWN";
	
	int width, height;
	List<Pair<Integer, Integer>> foodItems = null;
	Pair<Integer, Integer> head, tail;
	String direction;
	
	public Snake(int width, int height, List<Pair<Integer, Integer>> foodItems) {
		this.width = width;
		this.height = height;
		this.foodItems = foodItems;
		head = new Pair<Integer, Integer>(0, 0);
		tail = new Pair<Integer, Integer>(0, 0);
		direction = RIGHT;
	}
	
	public void run() {
		switch(direction) {
			case LEFT:
				if(head.getKey() > 0) {
					head = new Pair<Integer, Integer>(head.getKey() - 1, head.getValue());
					tail = new Pair<Integer, Integer>(tail.getKey() - 1, tail.getValue());
				} else {
					return;
				}
				
				break;
			
			case RIGHT:
				if(head.getKey() < width) {
					head = new Pair<Integer, Integer>(head.getKey() + 1, head.getValue());
					tail = new Pair<Integer, Integer>(tail.getKey() + 1, tail.getValue());
				} else {
					return;
				}
				
				break;
				
			case UP:
				if(head.getValue() > 0) {
					head = new Pair<Integer, Integer>(head.getKey(), head.getValue() - 1);
					tail = new Pair<Integer, Integer>(tail.getKey(), tail.getValue() - 1);
				} else {
					return;
				}
				
				break;
				
			case DOWN:
				if(head.getValue() < height) {
					head = new Pair<Integer, Integer>(head.getKey(), head.getValue() + 1);
					tail = new Pair<Integer, Integer>(tail.getKey(), tail.getValue() + 1);
				} else {
					return;
				}
				
				break;
		}
	}
	
	public void turnLeft() {
		
	}

	public void turnRight() {
		
	}
}