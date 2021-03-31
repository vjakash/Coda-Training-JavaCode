package examBuilder;


import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;


public class AttendExam {
	public static void main(String[] args) {
		Exam e=new Exam();
		e.startTest(4, QuestionsCollection.getQuestions(),1);
	}
}
abstract class Questions{
	String qn;
	String options[];
	int correctAns;
	int mark;
}
class Question extends Questions implements Cloneable{
	private static Question question;
	private Question(String qn,String[] options,int correctAns,int mark) {
		this.qn=qn;
		this.options=options;
		this.correctAns=correctAns;
		this.mark=mark;
	}
	private Question setValue(String qn,String[] options,int correctAns,int mark) {
		this.qn=qn;
		this.options=options;
		this.correctAns=correctAns;
		this.mark=mark;
		return this;
	}
	public static Question getObject(String qn,String[] options,int correctAns,int mark)  throws Exception {
		if(question==null) {
			question=new Question(qn, options, correctAns, mark);
		}
		return question.createClone().setValue(qn, options, correctAns, mark);
	}
	private Question createClone() throws Exception{
		return (Question)super.clone();
	}
}
class QuestionsCollection{
	static ArrayList<Question> questionsColl=new ArrayList<Question>(10);
	public static ArrayList<Question> getQuestions(){
		try {
			questionsColl.add(Question.getObject("Which is an Animal?",new String[] {"Ball","Apple","Cat","Car"},2,10));
			questionsColl.add(Question.getObject("Which is a Sport?",new String[] {"Ball","Apple","Cat","Football"},3,1));
			questionsColl.add(Question.getObject("Which is a bird?",new String[] {"Sparrow","Apple","Cat","Football"},0,1));
			questionsColl.add(Question.getObject("Which is a fruit?",new String[] {"Ball","Apple","Cat","Football"},1,1));
			questionsColl.add(Question.getObject("Which is a car?",new String[] {"Ball","Honda","Cat","Football"},1,1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionsColl;
	}
}
class Exam{
	private Map<Question,Integer> answers;
	public void startTest(int noOfQuestions,ArrayList<Question> questionsColl,int timeLimit) {
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {  
		    @Override  
		    public void run() {  
		    	System.out.println("---------------Time up------------------");
		        calcMark();
		        System.exit(0);
		    };  
		},timeLimit*60*1000);
		System.out.println("The test has started and will close automatically in "+timeLimit+" minute(s)");
		Scanner sc=new Scanner(System.in);
		answers=new HashMap<Question,Integer>();
		int length=questionsColl.size()-1;
		while(noOfQuestions>0 && length>=0) {
			int rand=(int)Math.floor(Math.random()*length);
			Question currentQuestion=questionsColl.get(rand);
			questionsColl.set(rand, questionsColl.get(length));
			questionsColl.set(length, currentQuestion);
			length--;
			noOfQuestions--;
			System.out.println(currentQuestion.qn);
			for(int i=0;i<currentQuestion.options.length;i++) {
				System.out.println((i+1)+"."+currentQuestion.options[i]);
			}
			System.out.println("Enter the correct option");
			int currentAns=sc.nextInt();
			while(currentAns>currentQuestion.options.length) {
				System.out.println("Invalid Option,please enter a valid option");
				currentAns=sc.nextInt();
			}
			answers.put(currentQuestion, currentAns);
		}
		System.out.println("--------------Test over-------------------");
		calcMark();
	}
	public int calcMark() {
		int totalScored=0,totalMarks=0;
		Set<Map.Entry<Question,Integer>> s=answers.entrySet();
		Iterator<Map.Entry<Question,Integer>> iter=s.iterator();
		while(iter.hasNext()) {
			Map.Entry<Question,Integer> me=iter.next();
			if(me.getKey().correctAns==me.getValue()-1) {
				totalScored+=me.getKey().mark;
			}
			totalMarks+=me.getKey().mark;
		}
		System.out.println("You scored: "+totalScored+"/"+totalMarks);
		return totalScored;
	}
}

