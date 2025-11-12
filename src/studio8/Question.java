package studio8;

public class Question {

	// === Fields ===
	private String prompt;
	private String answer;
	private int points;

	/**
	 * Constructor
	 * 
	 * @param prompt the question text shown to the user
	 * @param answer the correct answer
	 * @param points number of points this question is worth
	 */
	public Question(String prompt, String answer, int points) {
		this.prompt = prompt;
		this.answer = answer;
		this.points = points;
	}

	/**
	 * Prints out the current question's prompt, with a parenthetical
	 * number of points possible.
	 */
	public void displayPrompt() {
		System.out.println(this.prompt + " (" + this.points + " points)");
	}

	/**
	 * Check the answer provided by a user
	 * 
	 * @param givenAnswer
	 * @return the number of points earned by the givenAnswer
	 */
	public int checkAnswer(String givenAnswer) {
		if (this.answer.equals(givenAnswer)) { // exact string comparison
			return this.points;
		} else {
			return 0;
		}
	}

	/**
	 * Getter method for the points possible
	 * 
	 * @return int points
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * Getter method for the answer to the question
	 * 
	 * @return String answer
	 */
	public String getAnswer() {
		return this.answer;
	}

	public static void main(String[] args) {
		// Create a Question object and test its methods
		Question q1 = new Question("What keyword is used to define a class in Java?", "class", 5);

		q1.displayPrompt();
		System.out.println("Answer check (class): " + q1.checkAnswer("class")); // should return 5
		System.out.println("Answer check (interface): " + q1.checkAnswer("interface")); // should return 0
	}
}
