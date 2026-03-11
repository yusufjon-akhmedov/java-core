package lambda;

import java.util.Arrays;
import java.util.function.Function;

public class ChainingLambdas {

    public static void main(String[] args) {

        String name = "Yusufjon";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Akhmedov");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Akhmedov"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));
    }
}
