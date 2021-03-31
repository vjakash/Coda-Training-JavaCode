package day5FunFridayPack;

import day5FunFriday.TempAccount;

public class Question52 {
	public static void print(TempAccount arr[]) {
		for(TempAccount obj:arr) {
			obj.getName();
			obj.getBalance();
		}
	}
}
