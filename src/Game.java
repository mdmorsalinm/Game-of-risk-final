import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Scenario> scenarios;
    private Scanner scanner;
    private Random random;

    public Game() {
        this.player = new Player();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.scenarios = new ArrayList<>();
        initializeScenarios();
    }

    private void initializeScenarios() { // does not return anything but uses the setp class to create questions. It also designates answers and pops them into an arraylist.
        List<Step> ddosSteps = Arrays.asList(
                new Step("Your company's main e-commerce site is suddenly laggy and unreachable for many users. Initial checks show a massive spike in traffic from diverse IP addresses. What's the most likely immediate concern?",
                        Arrays.asList("Server hardware failure.", "A Distributed Denial of Service (DDoS) attack.", "Unexpected viral marketing success.", "Database connection pool exhaustion."),
                        1, 
                        "Correct! This pattern strongly indicates a DDoS attack overwhelming your servers.",
                        "Incorrect. While other issues can cause slowdowns, the massive, diverse traffic spike is key here.",
                        250),
                new Step("You've confirmed a DDoS attack. What's your FIRST priority to mitigate the impact?",
                        Arrays.asList("Immediately try to identify and prosecute the attackers.", "Contact your ISP or DDoS mitigation service.", "Take the website completely offline to prevent further damage.", "Start analyzing server logs for attack patterns."),
                        1, 
                        "Correct! Engaging specialized services is the quickest way to start filtering malicious traffic.",
                        "Incorrect. While other actions are important, immediate mitigation is key.",
                        300),
                new Step("The mitigation service is working, but some malicious traffic is still getting through. They suggest a technique to quickly drop traffic from known bad IPs. What is this likely to be?",
                        Arrays.asList("Implementing a Web Application Firewall (WAF) rule.", "Blacklisting specific IP ranges.", "Rate limiting all incoming connections.", "Scaling up server resources."),
                        1, 
                        "Correct! Blacklisting specific IPs or ranges is a common tactic to block known attackers.",
                        "Incorrect. While other methods help, blacklisting is a direct way to block known offenders.",
                        350),
                new Step("The attack has subsided. What's a crucial long-term step to improve resilience against future DDoS attacks?",
                        Arrays.asList("Switch to a cheaper hosting provider.", "Invest in a robust DDoS mitigation solution and develop an incident response plan.", "Publicly shame the attackers if identified.", "Reduce website functionality to lower traffic."),
                        1, 
                        "Correct! Proactive measures and a clear plan are essential for future protection.",
                        "Incorrect. Long-term resilience requires strategic investment and planning.",
                        400)
        );
        scenarios.add(new Scenario("DDoS Attack", "Experience a Distributed Denial of Service attack.", 500, ddosSteps));

     // Like the DDOS questions, this is a set of another 4 questions on a different cyber incident, along with 4 answers.
        List<Step> phishingSteps = Arrays.asList(
                new Step("You receive an email supposedly from 'IT Support' with the subject 'Urgent: Security Update Required!' It asks you to click a link to update your password. What's your first check?",
                        Arrays.asList("Immediately click the link to secure your account.", "Check the sender's email address for legitimacy.", "Forward it to all your colleagues to warn them.", "Delete it without thinking."),
                        1, 
                        "Correct! Always verify the sender's email address for slight misspellings or unexpected domains.",
                        "Incorrect. Clicking links in suspicious emails is dangerous. Verification is key.",
                        200),
                new Step("The sender's email is 'it.support@company-security.com' but your company's domain is '@company.com'. The link hovers over 'http://companysceurity.com/login'. What's a major red flag?",
                        Arrays.asList("The email uses an urgent tone.", "The sender's domain is slightly off, and the link URL is misspelled.", "The email is asking for password update.", "IT Support never sends emails."),
                        1, 
                        "Correct! Mismatched/misspelled domains and URLs are classic phishing indicators.",
                        "Incorrect. While urgency is common, the domain/URL mismatch is a technical red flag.",
                        250),
                new Step("You suspect it's phishing. What's the BEST course of action?",
                        Arrays.asList("Reply to the email asking if it's legitimate.", "Delete the email and forget about it.", "Report the email to your IT/Security department using established procedures.", "Click the link in a virtual machine to see what happens."),
                        2, 
                        "Correct! Reporting allows IT to warn others and block the source.",
                        "Incorrect. Ignoring it or engaging with the phisher can be risky.",
                        300),
                new Step("Your colleague clicked a similar link and entered their credentials. What's the most URGENT advice for them?",
                        Arrays.asList("Run a virus scan on their computer.", "Immediately change their password for that account and any other accounts using the same password, and report it.", "Wait to see if anything bad happens.", "Unplug their computer from the network."),
                        1, 
                        "Correct! Compromised credentials must be changed immediately, and the incident reported for further action.",
                        "Incorrect. The most immediate threat is account takeover.",
                        350)
        );
        scenarios.add(new Scenario("Email Phishing", "Deal with a sophisticated email phishing attempt.", 300, phishingSteps));

        List<Step> smishingSteps = Arrays.asList(
                new Step("You receive an SMS: 'Your bank account has been locked due to suspicious activity. Click here to verify: [shortened URL]'. What's your initial reaction?",
                        Arrays.asList("Click the link immediately to unlock your account.", "Call the bank using the number on their official website or your bank card, NOT from the SMS.", "Text back 'STOP' to unsubscribe.", "Ignore the message; it's probably spam."),
                        1, 
                        "Correct! Never use links or numbers from suspicious messages. Always use official contact methods.",
                        "Incorrect. Clicking links in unsolicited SMS can lead to malware or credential theft.",
                        150),
                new Step("The shortened URL, if expanded, might lead to a fake banking login page. What element on a fake login page often gives it away?",
                        Arrays.asList("It asks for too much information (e.g., PIN and full SSN).", "The page looks exactly like the real one.", "It uses HTTPS, so it must be secure.", "The bank's logo is slightly blurry."),
                        0, 
                        "Correct! Phishing sites often try to harvest excessive sensitive information.",
                        "Incorrect. Scammers are good at mimicry; HTTPS can be on fake sites too. Asking for unusual info is a big clue.",
                        200),
                new Step("If you accidentally visited the link but didn't enter info, what's a good precaution?",
                        Arrays.asList("No action needed if no info was entered.", "Clear browser cache and cookies, and monitor your device for strange behavior.", "Factory reset your phone immediately.", "Call the number in the SMS to complain."),
                        1, 
                        "Correct! Even visiting can sometimes trigger downloads. Clearing data and monitoring is prudent.",
                        "Incorrect. While no info entered is good, some sites might attempt drive-by downloads.",
                        250),
                new Step("How can you best educate others about smishing?",
                        Arrays.asList("Tell them to always trust shortened URLs from banks.", "Advise them to be wary of unsolicited messages asking for urgent action or personal info, and to verify independently.", "Suggest installing an app that blocks all unknown numbers.", "Tell them smishing only targets older people."),
                        1, 
                        "Correct! The core defense is skepticism and independent verification of any urgent request.",
                        "Incorrect. Educating about verification and skepticism is key.",
                        300)
        );
        scenarios.add(new Scenario("Smishing Attack", "Identify and respond to an SMS phishing (smishing) attempt.", 200, smishingSteps));

    
        List<Step> logActivitySteps = Arrays.asList(
                new Step("You're reviewing server logs and notice multiple failed login attempts for an admin account from an unrecognized IP address in a foreign country, followed by a successful login. What's your primary concern?",
                        Arrays.asList("The admin might have forgotten their password.", "A potential brute-force attack leading to a compromised admin account.", "Network latency causing login issues.", "A new employee is testing access from abroad."),
                        1,
                        "Correct! This pattern is highly indicative of a compromised account via brute-force or credential stuffing.",
                        "Incorrect. While other explanations are possible, the foreign IP and successful login after failures scream 'compromise'.",
                        250),
                new Step("Having confirmed a likely account compromise, what is the MOST critical first action?",
                        Arrays.asList("Start a full forensic analysis of the server.", "Immediately disable the compromised admin account and force a password reset.", "Try to trace the attacker's IP address.", "Inform the admin user they might be compromised."),
                        1, 
                        "Correct! Containing the breach by disabling the account prevents further malicious activity.",
                        "Incorrect. While other steps are important, containment is the immediate priority.",
                        300),
                new Step("After disabling the account, you need to assess the extent of the breach. What's a key area to investigate in the logs?",
                        Arrays.asList("Normal user login activity.", "Commands executed and files accessed by the compromised account after the suspicious login.", "Firewall logs for all traffic from that country.", "Performance metrics of the server."),
                        1, 
                        "Correct! Understanding what the attacker did post-compromise is crucial for remediation.",
                        "Incorrect. The priority is to determine the attacker's actions using the compromised account.",
                        350),
                new Step("To prevent similar incidents, what security measure should be strengthened?",
                        Arrays.asList("Disable all admin accounts.", "Implement Multi-Factor Authentication (MFA) for all admin accounts and monitor for suspicious logins.", "Block all IP addresses from foreign countries.", "Reduce the complexity requirements for passwords to make them easier to remember."),
                        1, 
                        "Correct! MFA is a strong deterrent against credential compromise, and monitoring helps detect breaches.",
                        "Incorrect. Strengthening authentication and detection is key, not overly restrictive or weakening measures.",
                        400)
        );
        scenarios.add(new Scenario("Unusual Log Activity", "Investigate suspicious account login patterns.", 400, logActivitySteps));
    }
// NOW WE HAVE ALL 4 SECTIONS with 4 ANSWERS TO EACH Q.
    public void start() {
        System.out.println("Welcome to the Cybersecurity Incident Response Game!"); // intro
        player.displayStatus();

        boolean playing = true;
        while (playing && player.isAlive() && player.hasSufficientPoints()) { // Checking if the player has not lost all 5000 pts or 3 lives.
            displayScenarios();
            int scenarioChoice = getUserChoice(1, scenarios.size() + 1) -1; 

            if (scenarioChoice == scenarios.size()) { 
                System.out.println("Thanks for playing! Exiting game.");
                playing = false;
                continue;
            }

            Scenario currentScenario = scenarios.get(scenarioChoice);
            playScenario(currentScenario);

            if (!player.isAlive() || !player.hasSufficientPoints()) { // IF LOST EVERYTHING, YOU LOSE!
                gameOver();
                playing = false;
            } else if (playing) { 
                System.out.println("\nScenario '" + currentScenario.getName() + "' part completed or handled!");
                player.displayStatus();
                System.out.println("Do you want to tackle another scenario? (yes/no)");
                String playAgain = scanner.nextLine().trim().toLowerCase();
                if (!playAgain.equals("yes")) {
                    playing = false;
                    System.out.println("Thanks for playing! Exiting game.");
                }
            }
        }
        if (playing && (!player.isAlive() || !player.hasSufficientPoints())) { 
            gameOver();
        }
        System.out.println("Game ended.");
        scanner.close();
    }

    private void displayScenarios() {
        System.out.println("\nChoose a cybersecurity incident to experience:");
        for (int i = 0; i < scenarios.size(); i++) {
            Scenario s = scenarios.get(i);
            System.out.println((i + 1) + ". " + s.getName() + " - " + s.getDescription() + " (Risk Amount: " + s.getRiskAmount() + ")");
        }
        System.out.println((scenarios.size() + 1) + ". Quit Game");
    } // Describe the chosen senario and set up questions

    private void playScenario(Scenario scenario) {
        System.out.println("\n--- Starting Scenario: " + scenario.getName() + " ---");
        System.out.println(scenario.getDescription());
        System.out.println("This scenario has a risk amount of: " + scenario.getRiskAmount());

        int currentStepIndex = 0; // Start at the first step


        while (currentStepIndex < scenario.getNumberOfSteps() && player.isAlive() && player.hasSufficientPoints()) {
            Step currentStep = scenario.getSteps().get(currentStepIndex);
            boolean advanceToNextStep = false;

            player.displayStatus();
            currentStep.displayStep();
            int choice = getUserChoice(1, 5);

            if (choice == 5) { // User chose to "Risk it!" // Our risk selection work. Here the user will be asked to roll if they decide to risk. If they roll a 5, they are allowed to skip with no penalty.
                // THEY HAVE AN 80% CHANCE TO LOSE, so its a big risk!
                System.out.println("You chose to RISK IT!");
                int riskRoll = random.nextInt(5) + 1;
                System.out.println("Rolled a " + riskRoll + "...");
                delay(1000);

                if (riskRoll == 5) { // Lucky roll - ONLY 5 allows skipping
                    System.out.println("LUCKY! You rolled a 5! You get to skip this step without penalty!");
                    advanceToNextStep = true;
                } else { // Rolls 1, 2, 3, 4 - Penalty, NO SKIP
                    int penalty = scenario.getRiskAmount() * riskRoll;
                    System.out.println("Unlucky roll (" + riskRoll + "). You lose " + penalty + " points.");
                    player.subtractPoints(penalty);
                    delay(1000); // Give time to read penalty message
                    // THEY LOSE THE POINTS!

                    if (!player.hasSufficientPoints() || !player.isAlive()) {

                        System.out.println("That risk was too costly! The consequences are dire.");

                    } else {
                        System.out.println("You did not roll a 5. You still need to answer the question for this step (or try risking it again).");
                    }

                }
                delay(1000);

            } else {
                int answerIndex = choice - 1;
                if (answerIndex == currentStep.getCorrectAnswerIndex()) {
                    System.out.println("\nCORRECT!");
                    System.out.println(currentStep.getFeedbackCorrect());
                    player.addPoints(currentStep.getPointsForCorrect());
                    advanceToNextStep = true; // Correct answer, so advance to next step
                } else {
                    System.out.println("\nINCORRECT!");
                    System.out.println(currentStep.getFeedbackIncorrect());
                    player.loseHeart();

                    if (player.isAlive() && player.hasSufficientPoints()) {
                        System.out.println("Try this step again, or choose to 'Risk It'.");
                    }
                }
                delay(2000);
            }

            if (!player.isAlive() || !player.hasSufficientPoints()) { // constantly checking if alive.
                break;
            }

            if (advanceToNextStep) {
                currentStepIndex++;
                if (currentStepIndex < scenario.getNumberOfSteps() && player.isAlive() && player.hasSufficientPoints()) {
                    System.out.println("\n>>> Proceeding to the next part of the scenario... <<<");
                    delay(1500);
                }
            } else if (player.isAlive() && player.hasSufficientPoints()){
                System.out.println("\n>>> Let's re-evaluate the current situation... <<<");
                delay(1500);
            }

        } // End of while loop for steps

        if (player.isAlive() && player.hasSufficientPoints()) {
            if (currentStepIndex == scenario.getNumberOfSteps()) { // All steps were successfully handled
                System.out.println("\nCongratulations! You've successfully navigated all parts of the " + scenario.getName() + " scenario!");
                player.addPoints(scenario.getRiskAmount() * 2); // Bonus for completing scenario
            }
        }
    }

    private int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            try {
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
        }
        scanner.nextLine(); 
        return choice;
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep interrupted");
        }
    }

    private void gameOver() { // game end screen
        System.out.println("\nxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x    GAME OVER     x");
        System.out.println("xxxxxxxxxxxxxxxxxxxx");
        if (!player.isAlive()) {
            System.out.println("You ran out of hearts!");
        }
        if (!player.hasSufficientPoints()) {
            System.out.println("You ran out of points!");
        }
        player.displayStatus();
    }
}
