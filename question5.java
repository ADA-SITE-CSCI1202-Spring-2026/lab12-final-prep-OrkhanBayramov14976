import java.util.HashMap;

@FunctionalInterface
interface GradeRule {
    boolean test(int grade);
}

public class GradeFilter {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("Ali", 85);
        grades.put("Leyla", 92);
        grades.put("Murad", 55);
        grades.put("Nigar", 70);
        grades.put("Kamran", 40);

        // TODO 1
        GradeRule passedRule = grade -> grade >= 50;

        // TODO 2
        GradeRule excellentRule = grade -> grade >= 85;

        System.out.println("Passed students:");
        // TODO 3
        grades.forEach((name, grade) -> {
            if (passedRule.test(grade)) System.out.println(name + " -> " + grade);
        });

        System.out.println("\nExcellent students:");
        // TODO 4
        grades.forEach((name, grade) -> {
            if (excellentRule.test(grade)) System.out.println(name + " -> " + grade);
        });
    }
}
