import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    /**
     * main
     * @param args
     */
    static String username;
    public static void main(String[] args) {

        int percentage = 0;
        int categorySelection;
        int firstElection;
        int loquesea = 0;
        String[] questions = new String[20];
        String[] answers = new String[20];

        System.out.println("Write your name: ");
        username = Teclat.llegirString();


        firstElection = askHowManyQuestions();
        categorySelection = chooseCategory();
        categorySelected(categorySelection, firstElection, questions, answers);

    }

    /**
     * category selected
     * @param categorySelection
     * @param firstElection
     * @param questions
     * @param answers
     */
    private static void categorySelected(int categorySelection, int firstElection, String[] questions, String[] answers) {
        int correctAnsw = 0;

        switch (categorySelection) {
            case 1 -> {
                System.out.println(' ');
                System.out.println("You selected the general category");
                questions = generalCategory();
                answers = generalAnswers();

            }
            case 2 -> {
                System.out.println(' ');
                System.out.println("You selected the science category");
                questions = scienceCategory();
                answers = scienceAnswers();
            }
            case 3 -> {
                System.out.println(' ');
                System.out.println("You selected the geography and History category");
                questions = geographyHistoryCategory();
                answers = geographyHistoryAnswers();
            }
            case 4 -> {
                System.out.println(' ');
                System.out.println("You selected the music category");
                questions = musicCategory();
                answers = musicAnswers();
            }
        }
        correctAnsw = questionIsSelected(firstElection, questions, answers);
        correctPercentage(correctAnsw, firstElection, username, categorySelection);
    }

    /**
     * question is selected
     * @param firstElection
     * @param questions
     * @param answers
     * @return question is selected
     */
    private static int questionIsSelected(int firstElection, String[] questions, String[] answers) {

        Random r = new Random();
        char answer;

        int correctAnsw = 0;
        int questionsAnswered = 0;

        //intento fer dos funcions aqui pero no funciona el programa si les faig
        do {
            int loquesea = r.nextInt(questions.length);

            System.out.println(" ");
            System.out.println("///////////////////////////////////////////////////////////////////////////////");
            System.out.println(ANSI_BLUE + questions[loquesea] + "(y or n)" + ANSI_RESET);
            System.out.println("///////////////////////////////////////////////////////////////////////////////");

            answer = Teclat.llegirChar();
            boolean answerIsNotCorrectlyWrited = answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N';
            boolean answerIsCorrect = answers[loquesea].equalsIgnoreCase(String.valueOf(answer));
            boolean answerIsCorrectlyWrited = answer == 'y' && answer == 'Y' && answer == 'n' && answer == 'N';

            if (answerIsNotCorrectlyWrited) {
                do {
                    System.out.println("Please write 'y (yes)' or 'n (no)' ");
                    answer = Teclat.llegirChar();

                    if (answerIsCorrect) {
                        System.out.println(ANSI_GREEN + "Correct" + ANSI_RESET);
                        correctAnsw++;
                    } else {
                        System.out.println(ANSI_RED + "Incorrect" + ANSI_RESET);
                    }
                    questionsAnswered++;
                }
                while (answerIsCorrectlyWrited);
            } else {
                if (answers[loquesea].equalsIgnoreCase(String.valueOf(answer))) {
                    System.out.println(ANSI_GREEN + "Correct" + ANSI_RESET);
                    correctAnsw++;
                } else {
                    System.out.println(ANSI_RED + "Incorrect" + ANSI_RESET);
                }
                questionsAnswered++;
            }


        }
        while (questionsAnswered < (firstElection));

        //correctPercentage(correctAnsw, firstElection);

        return correctAnsw;
    }

    /**
     * choose category
     * @return choose category
     */

    private static int chooseCategory() {
        int categorySelection = 0;
        do {
            System.out.println("///////////////////////////");
            System.out.println("Choose a category:");
            System.out.println("1.General questions");
            System.out.println("2.Science");
            System.out.println("3.Geography and History");
            System.out.println("4.Music");
            System.out.println("///////////////////////////");

            categorySelection = Teclat.llegirInt();
        }
        while (categorySelection != 1 && categorySelection != 2 && categorySelection != 3 && categorySelection != 4);
        return categorySelection;
    }

    /**
     * ask how many question
     * @return ask how many question
     */

    private static int askHowManyQuestions() {
        int firstElection = 0;
        do {
            System.out.println("How many questions you want (minimum 5)? ");
            firstElection = Teclat.llegirInt();
        }
        while (firstElection < 5);

        return firstElection;
    }

    /**
     * general category
     * @return general category
     */

    public static String[] generalCategory() {
        String[] question = {"The age of the universe is 13 000 millions of years? ",
                "The Spanish Civil war broke out in 1936? ",
                "The statue of Liberty was crafted by the americans? ",
                "Istanbul is the capital of Turkey? ",
                "The Earth is the fourth planet of the solar system? ",
                "The theory of the relativity was formulated by Isaac Newton",
                "Papillon is the French word for Butterfly? ",
                "There are 61 active volcanoes in Hawaii? ",
                "Ice is denser than water? ",
                "Great Britain is the largest island in the world? ",
                "Queen Elizabeth II has 3 children? ",
                "Starbucks logo features a siren? ",
                "Neil Armstrong was the first man to travel into space? ",
                "Hot water freezes faster than cold water? ",
                "There are 118 elements in the periodic table? ",
                "Candy Floss was invented by a dentist? ",
                "Johann Sebastian Bach was deaf? ",
                "The larger island in the Mediterranean Sea is Sicily? ",
                "The Hundred Years War lasted 99 years",
                "Marie Curie was the first woman to be awarded a Nobel peace prize? "};

        return question;
    }

    /**
     * general answers
     * @return general answers
     */

    public static String[] generalAnswers() {
        String[] correctAnswers = {"Y",
                "Y",
                "N",
                "N",
                "N",
                "N",
                "Y",
                "N",
                "N",
                "N",
                "N",
                "Y",
                "N",
                "Y",
                "Y",
                "Y",
                "N",
                "Y",
                "N",
                "N"};
        return correctAnswers;
    }

    /**
     * science category
     * @return science category
     */

    public static String[] scienceCategory() {
        String[] science = {"The age of the universe is 13 000 millions of years? ",
                "The Earth is the fourth planet of the solar system? ",
                "The theory of the relativity was formulated by Isaac Newton? ",
                "Ice is denser than water? ",
                "Neil Armstrong was the first man to travel into space? ",
                "Hot water freezes faster than cold water? ",
                "There are 118 elements in the periodic table? ",
                "Marie Curie was the first woman to be awarded a Nobel peace prize? ",
                "Weight is the quantity of matter than a material has? ",
                "Mercury is the closest planet to the Sun? ",
                "Charles Darwin is remembered for his evolution theory? ",
                "The white blood cells are part of immune system? ",
                "The DNA is only founded on animal cells? ",
                "The movement of the Earth around the Sun is called rotation? ",
                "Acoustic studies the sound? ",
                "Femur is the largest bone of the human body? ",
                "Viviparous animals are those that put eggs? ",
                "Taxonomy classifies the minerals? ",
                "An algorithm is a set of numbers? ",
                "The moon influences in Earth tides? ",
                "Pythagoras was the first to propose that the Earth was round? "
        };
        return science;
    }

    /**
     * science answers
     * @return science answers
     */

    public static String[] scienceAnswers() {
        String[] scienceAnswers = {"Y",
                "N",
                "N",
                "N",
                "N",
                "Y",
                "Y",
                "N",
                "N",
                "Y",
                "Y",
                "Y",
                "N",
                "N",
                "Y",
                "Y",
                "N",
                "Y",
                "N",
                "Y",
                "Y"
        };
        return scienceAnswers;
    }

    /**
     * geography history category
     * @return geography history category
     */
    public static String[] geographyHistoryCategory() {
        String[] geographyHistory = {"The Spanish Civil war broke out in 1936? ",
                "The statue of Liberty was crafted by the americans? ",
                "Istanbul is the capital of Turkey? ",
                "There are 61 active volcanoes in Hawaii? ",
                "Great Britain is the largest island in the world? ",
                "The larger island in the Mediterranean Sea is Sicily? ",
                "The Hundred Years War lasted 99 years? ",
                "Marie Curie was the first woman to be awarded a Nobel peace prize? ",
                "The decapitation was a popular method of execution used during the french revolution? ",
                "The crusades were religious wars fueled by christianity",
                "Leonardo da Vinci was a Medium age figure",
                "The industrial revolution has his biggest peak in Italy? ",
                "The Lighthouse of Alexandria was one of the seven beauties of the Ancient world? ",
                "The pyramids of giza were the work of greek culture? ",
                "Territorially speaking, the russian empire has been the most extensive in the history? ",
                "Martin Luther initiate the protestant reform? ",
                "The landing of normandy is also known as the D day? ",
                "The first American settlers arrived from de Bering narrow? ",
                "John F. Kennedy was murdered in Washington? ",
                "Did the Titanic sink in his first travel from England to the United Estates? ",
                "The great depression is referred to a economic crisis? "
        };
        return geographyHistory;
    }

    /**
     * geography history answers
     * @return geography history answers
     */
    public static String[] geographyHistoryAnswers() {
        String[] geographyHistoryAnswers = {"Y",
                "N",
                "N",
                "N",
                "N",
                "Y",
                "N",
                "N",
                "Y",
                "Y",
                "N",
                "N",
                "Y",
                "N",
                "N",
                "Y",
                "Y",
                "Y",
                "N",
                "Y",
                "Y"
        };
        return geographyHistoryAnswers;
    }

    /**
     * music category
     * @return music category
     */

    public static String[] musicCategory() {
        String[] music = {"A painted thunder is one of the symbols of David Bowie? ",
                "The Backstreet Boys where a boy band of the 80s? ",
                "Adele is one of the greatest winners of the Grammy? ",
                "Donna Summer is considered 'The queen of disco music'? ",
                "Beyoncé was part of the band 'Destiny's Child'? ",
                "'The Eraser' is one of the most important albums of Radiohead? ",
                "Ed Sheeran have a song with Snoop Dogg? ",
                "Shakira interpreted one of the official songs of the Olympic Games? ",
                "The song from 'Titanic' is interpreted by Céline Dion? ",
                "Miley Cyrus was Hannah Montana? ",
                "'Stayin Alive' is a song of Bee Gees? ",
                "A baby is the protagonist of the cover of 'Nevermind' of Nirvana? ",
                "The cover of 'Dark Side of the Moon', of Pink Floyd, is a huge white wall? ",
                "'Toxic', of Britney Spears come up before 'Baby One More Time? ",
                "Eminem is known also as Slim Shady? ",
                "The yellow is a color associated with Prince? ",
                "Harry Styles was part of One Direction? ",
                "Daft Punk is famous for be a band of a cartoon? ",
                "Chester Bennington was the vocalist of Linkin Park? ",
                "A mouth with a tongue out is the logo of the Rolling Stones? ",
                "Tina Turner was a singer of the 80s that turned another time popular for 'Stranger Things'? ",
        };
        return music;
    }

    /**
     *music answer
     * @return music answers
     */
    public static String[] musicAnswers() {
        String[] musicAnswers = {"Y",
                "N",
                "Y",
                "Y",
                "Y",
                "Y",
                "N",
                "N",
                "Y",
                "Y",
                "Y",
                "Y",
                "N",
                "N",
                "Y",
                "N",
                "Y",
                "N",
                "Y",
                "Y",
                "N"
        };
        return musicAnswers;
    }

    /**
     *
     * @param correctAnsw
     * @param firstElection
     */
    public static void correctPercentage(int correctAnsw, int firstElection, String username, int categorySelection) {
        float percentage;
        float cambioVarAnsw = correctAnsw;
        float cambioVarElect = firstElection;
        percentage = cambioVarAnsw / cambioVarElect;
        percentage = percentage * 100;
        if (percentage <= 33) {
            System.out.println(" ");
            System.out.println(ANSI_RED + "You answered from 0% to 33% of the questions correctly" + ANSI_RESET);

        } else if (percentage <= 66) {
            System.out.println(" ");
            System.out.println(ANSI_RED + "You answered from 34% to 66% of the questions correctly" + ANSI_RESET);
        } else if (percentage <= 99) {
            System.out.println(" ");
            System.out.println(ANSI_GREEN + "You answered from 67% to 99% of the questions correctly" + ANSI_RESET);
        } else if (percentage == 100) {
            System.out.println(" ");
            System.out.println(ANSI_GREEN + "You answered 100% of the questions correctly" + ANSI_RESET);
        }
        writeResultToFile(username, correctAnsw, firstElection, categorySelection);
        readResultsFromFile();
    }

    private static void writeResultToFile(String username, int correctAnsw, int firstElection, int categorySelection) {
        String filename = "quiz/src/resources/ranking.txt";
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(filename, true));
            myWriter.write("\n" + "/////////////////////////////////////////////////////////////////" + "\n");
            myWriter.write("Username: " + username + "\n");
            myWriter.write("Correct Answers: " + correctAnsw + "/" + firstElection + "\n");
            myWriter.write("Category: " + categorySelection + "\n");
            myWriter.write("/////////////////////////////////////////////////////////////////" + "\n");
            myWriter.close();
            System.out.println("Results written to ranking.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the results to the file.");
            e.printStackTrace();
        }
    }

    private static void readResultsFromFile() {
        String filename = "quiz/src/resources/ranking.txt";
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            System.out.println("Quiz Results:");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the quiz results from the file.");
            e.printStackTrace();
        }
    }


    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
}
