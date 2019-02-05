package com.practice.java;

public class EnumExample {
	enum Header {
		PROJECT_ID,
		ORG_NAME,
		ORG_TYPE,
		DONATION_TYPE
	}
	
	public static void main(String args[]) {
		for(Header h: Header.values()) {
			switch(h) {
				case PROJECT_ID:
					System.out.println(Header.PROJECT_ID);
					break;
		
				case ORG_NAME:
					System.out.println(Header.ORG_NAME);
					break;
		
				case ORG_TYPE:
					System.out.println(Header.ORG_TYPE);
					break;
			}
		}
	}

}
