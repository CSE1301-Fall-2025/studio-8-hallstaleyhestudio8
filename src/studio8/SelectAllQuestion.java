package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	/**
	 * Constructor
	 * 
	 * @param prompt  the question text
	 * @param answer  the string containing all correct choices (e.g., "AC" for A
	 *                and C)
	 * @param choices the array of all possible choices
	 */
	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		// 1 point per choice in total; store answer in base class
		super(prompt, answer, choices.length, choices);
	}

	/**
	 * Returns the number of points scored for a given answer
	 * Partial credit: +1 for each correct answer given, -1 for incorrect answers or
	 * missing correct answers
	 */
	@Override
	public int checkAnswer(String givenAnswer) {
		// Count missing correct answers
		int missingCorrect = findMissingCorrectAnswers(givenAnswer);
		// Count incorrect answers given
		int incorrectGiven = findIncorrectGivenAnswers(givenAnswer);
		// Each correct answer given is worth +1, deductions are applied
		int score = getPoints() - missingCorrect - incorrectGiven;

		// Ensure score is not negative
		if (score < 0)
			score = 0;
		return score;
	}

	/**
	 * Count correct answers missing from the given answer
	 */
	private int findMissingCorrectAnswers(String givenAnswer) {
		return findMissingCharacters(givenAnswer, getAnswer());
	}

	/**
	 * Count given answers that are incorrect
	 */
	private int findIncorrectGivenAnswers(String givenAnswer) {
		return findMissingCharacters(getAnswer(), givenAnswer);
	}

	/**
	 * Helper: count characters in toCheck that are missing from baseString
	 */
	private static int findMissingCharacters(String baseString, String toCheck) {
		int missingValues = 0;
		for (int i = 0; i < toCheck.length(); i++) {
			char characterToLocate = toCheck.charAt(i);
			if (baseString.indexOf(characterToLocate) == -1) {
				missingValues++;
			}
		}
		return missingValues;
	}

	public static void main(String[] args) {
		String[] options = { "A", "B", "C", "D" };
		// Correct answers: A and C
		SelectAllQuestion saq = new SelectAllQuestion(
				"Select all vowels:",
				"AC",
				options);

		System.out.println("User selects AC: " + saq.checkAnswer("AC")); // Full credit, 4 points total
		System.out.println("User selects AB: " + saq.checkAnswer("AB")); // Partial credit
		System.out.println("User selects BD: " + saq.checkAnswer("BD")); // Only wrong answers, score 0
		System.out.println("User selects empty: " + saq.checkAnswer("")); // Missed all correct, score 0
	}
}
