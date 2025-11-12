package studio8;

public class MultipleChoiceQuestion extends Question {

	// Instance variable for the list of answer choices
	private String[] choices;

	/**
	 * Constructor
	 * 
	 * @param prompt  the question text
	 * @param answer  the correct answer
	 * @param points  number of points this question is worth
	 * @param choices an array of possible answers
	 */
	public MultipleChoiceQuestion(String prompt, String answer, int points, String[] choices) {
		// Call the superclass constructor for shared fields
		super(prompt, answer, points);
		// Handle the new field for multiple choice options
		this.choices = choices;
	}

	/**
	 * Display the prompt and the list of choices.
	 */
	@Override
	public void displayPrompt() {
		// Display the question and points from the superclass
		super.displayPrompt();
		// Display each choice with a label number
		for (int i = 0; i < choices.length; i++) {
			System.out.println((i + 1) + ". " + choices[i]);
		}
	}

	/**
	 * Getter for choices
	 * 
	 * @return String[] of choices
	 */
	public String[] getChoices() {
		return this.choices;
	}

	public static void main(String[] args) {
		// Create and test a MultipleChoiceQuestion
		String[] options = { "131", "231", "425", "1301" };

		MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(
				"Which course is the introduction to Computer Science at WashU?",
				"131",
				5,
				options);

		mcq.displayPrompt();
		System.out.println("Answer check (131): " + mcq.checkAnswer("131")); // Should print 5
		System.out.println("Answer check (425): " + mcq.checkAnswer("425")); // Should print 0
	}
}
