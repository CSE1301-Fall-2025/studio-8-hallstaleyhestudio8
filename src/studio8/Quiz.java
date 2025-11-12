package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;

	/**
	 * Constructor
	 * 
	 * @param questions array of Question objects
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
	}

	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * 
	 * @param in Scanner to read user input
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}

	/**
	 * Gets the total number of points possible in the quiz.
	 * 
	 * @return int total points
	 */
	public int getTotalPoints() {
		int total = 0;
		for (Question q : questions) {
			total += q.getPoints();
		}
		return total;
	}

	/**
	 * Asks the user all questions in the quiz, prints the points earned for each,
	 * and finally prints the total points earned.
	 * 
	 * @param in Scanner object for user input
	 */
	public void takeQuiz(Scanner in) {
		int totalEarned = 0;

		for (Question q : questions) {
			// Display the question prompt
			q.displayPrompt();

			// Get user's answer
			String userAnswer = getUserAnswer(in);

			// Check answer and calculate points
			int earned = q.checkAnswer(userAnswer);
			totalEarned += earned;

			// Display points earned for this question
			System.out.println("Points earned: " + earned + "\n");
		}

		// Display total points earned
		System.out.println("You have earned " + totalEarned + " points out of " + getTotalPoints() + " points.");
	}

	/**
	 * Example main method: creates a Quiz and runs it
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Sample Question
		Question q1 = new Question("Fill in the blank: Java uses ____ to inherit a class.", "extends", 5);

		// Sample MultipleChoiceQuestion
		String[] mcChoices = { "131", "231", "425", "1301" };
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
				"Which course is the introduction to Computer Science at WashU?",
				"131",
				5,
				mcChoices);

		// Sample SelectAllQuestion
		String[] saChoices = { "A", "B", "C", "D" };
		SelectAllQuestion q3 = new SelectAllQuestion(
				"Select all consonants:",
				"BCD",
				saChoices);

		Question[] allQuestions = { q1, q2, q3 };
		Quiz quiz = new Quiz(allQuestions);

		// Take the quiz
		quiz.takeQuiz(sc);

		sc.close();
	}

}
