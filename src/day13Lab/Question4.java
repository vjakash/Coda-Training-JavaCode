package day13Lab;

import java.util.HashMap;
import java.util.Map;

public class Question4 {

}
 class AccountManager { 
	 private Map<String,Integer> accountTotals = new HashMap<>(); 
	 private int retirementFund; 
	
	 public int getBalance(String accountName) { 
//		 Integer total = accountTotals.get(accountName); 
//		 if (total == null) 
//		 total = Integer.valueOf(0); 
		 return accountTotals.get(accountName); 
	 } 
	 public void setBalance(String accountName, int amount) { 
		 accountTotals.put(accountName, amount); 
	 } 
} 
/*
 this class is to be updated to make use of appropriate generic types, with no changes in behavior (for 
 better or worse). Which of these steps could be performed? (Choose three.) 
 A. Replace line 13 with private Map<String, int> accountTotals = new HashMap<String, int>(); 
 B. Replace line 13 with private Map<String, Integer> accountTotals = new HashMap<String, Integer>(); -true
 C. Replace line 13 with private Map<String<Integer>> accountTotals = new HashMap<String<Integer>>();
 D. Replace lines 17–20 with int total = accountTotals.get(accountName); if (total == null) total = 0; return 
 total; 
 E. Replace lines 17–20 with Integer total = accountTotals.get(accountName); if (total == null) total = 0; 
 return total; 
 F. Replace lines 17–20 with return accountTotals.get(accountName); -true
 G. Replace line 24 with accountTotals.put(accountName, amount); -true
 H. Replace line 24 with accountTotals.put(accountName, amount.intValue()); 

 */