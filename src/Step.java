import java.util.List;

public class Step {
    private String prompt;
    private List<String> options; // Options 1-4
    private int correctAnswerIndex; // 0-3 for options 1-4
    private String feedbackCorrect;
    private String feedbackIncorrect;
    private int pointsForCorrect;

    public Step(String prompt, List<String> options, int correctAnswerIndex,
                String feedbackCorrect, String feedbackIncorrect, int pointsForCorrect) {
        if (options.size() != 4) {
            throw new IllegalArgumentException("A step must have exactly 4 answer options.");
        }
        this.prompt = prompt;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.feedbackCorrect = feedbackCorrect;
        this.feedbackIncorrect = feedbackIncorrect;
        this.pointsForCorrect = pointsForCorrect;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public String getFeedbackCorrect() {
        return feedbackCorrect;
    }

    public String getFeedbackIncorrect() {
        return feedbackIncorrect;
    }

    public int getPointsForCorrect() {
        return pointsForCorrect;
    }

    public void displayStep() {
        System.out.println("\n" + prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("5. Risk it!");
    }
}