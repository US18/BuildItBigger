package just.android.uplabdhisingh.javajokeslib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jokes
{
    private static ArrayList<String> jokes = new ArrayList<>(Arrays.asList(
            "A family of mice were surprised by a big cat. Father Mouse jumped and and said, \"Bow-wow!\" The cat ran away. \"What was that, Father?\" asked Baby Mouse. " +
                    "\"Well, son, that's why it's important to learn a second language.\" ",
            "My friend said he knew a man with a wooden leg named Smith. \n" +
                    "So I asked him \"What was the name of his other leg?\"",
            "The doctor to the patient: 'You are very sick' \n" +
                    "The patient to the doctor: 'Can I get a second opinion?' \n" +
                    "The doctor again: 'Yes, you are very ugly too...'",
            "Mother: \"Did you enjoy your first day at school?\" \n" +
                    "Girl: \"First day? Do you mean I have to go back tomorrow? ",
            "Son: Dad, what is an idiot? \n" +
                    "Dad: An idiot is a person who tries to explain his ideas in such a strange and long way that another person who is listening to him can't understand him. Do you understand me? \n" +
                    "Son: No.",
            "Father: What did you do today to help your mother? \n" +
                    "Son: I dried the dishes \n" +
                    "Daughter: And I helped pick up the pieces. "
    ));

    public static String fetchJokes()
    {
        Collections.shuffle(jokes);
        return jokes.get(0);
    }
}
