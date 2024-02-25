public class main {

    public static String ANSI_RED = "\033[0;31m";
    public static String ANSI_GREEN = "\033[0;32m";
    public static String ANSI_RESET = "\033[0m";

    public static int SUITES_RUN = 0;
    public static int SUITES_PAST = 0;

    public static int TESTS_RUN = 0;
    public static int TESTS_PASSED = 0;

    public static void start_suite(String name) {
        SUITES_RUN++; // Suites Run += 1
        System.out.println("=====================\nStarting: " + name + "\n=====================");
    }

    public static void end_suite() {
        if (TESTS_RUN == TESTS_PASSED) {
           SUITES_PAST++;
           System.out.println(ANSI_GREEN + "All tests passed" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "Some tests failed: " + (TESTS_RUN - TESTS_PASSED) + ANSI_RESET);
        }
        TESTS_RUN = 0;
        TESTS_PASSED = 0;
    }

    public static void assertEquals(int actual, int expect) {
        TESTS_RUN++;
        if (actual == expect) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Tests " + TESTS_RUN + " Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Tests " + TESTS_RUN + " Failed: Expected " + expect + " but got " + actual + ANSI_RESET);
        }
    }

    public static void assertEquals(boolean actual, boolean expect) {
        TESTS_RUN++;
        if (actual == expect) {
            TESTS_PASSED++;
            System.out.println(ANSI_GREEN + "Tests " + TESTS_RUN + " Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Tests " + TESTS_RUN + " Failed: Expected " + expect + " but got " + actual + ANSI_RESET);
        }
    }

    public static void end_all() {
        if (SUITES_RUN == SUITES_PAST) {
            System.out.println(ANSI_GREEN + "***" + SUITES_PAST + "/" + SUITES_RUN +  "***" + "\n=====================" + ANSI_RESET);
         }
         else {
             System.out.println(ANSI_RED + "Some suites failed: " + (TESTS_RUN - TESTS_PASSED) + "\n=====================" + ANSI_RESET);
         }
    }

    public static void main(String[] args){
        Task1And2 tester = new Task1And2();

        start_suite("Contains suite");
        assertEquals(tester.containsGenZSlang("no cap"), true);
        assertEquals(tester.containsGenZSlang("this is no cap"), true);
        assertEquals(tester.containsGenZSlang("No Cap"), false);
        assertEquals(tester.containsGenZSlang("I am cool"), false);
        assertEquals(tester.containsGenZSlang("this is no cap I promise"), true);
        assertEquals(tester.containsGenZSlang("no cap dude for real"), true);
        end_suite();

        start_suite("Length suite");
        assertEquals(tester.isSpecialLength("iajdhanbghtoeislfkennnsmwidoawertorisueiqw"), true);
        assertEquals(tester.isSpecialLength("iajdhanbghtoeislfkennnsmwidoawertorisiqw"), false);
        assertEquals(tester.isSpecialLength(""), false);
        end_suite();

        start_suite("2 or more disticnt chars");
        assertEquals(tester.hasMoreThanOneDistinctCharacter("aaaaaaaaaaa"), false);
        assertEquals(tester.hasMoreThanOneDistinctCharacter("bob"), true);
        assertEquals(tester.hasMoreThanOneDistinctCharacter("f"), false);
        end_suite();

        start_suite("Palindrome suite");
        assertEquals(tester.isPalindrome("bob"), true);
        assertEquals(tester.isPalindrome("race car"), true);
        assertEquals(tester.isPalindrome("bobar "), false);
        assertEquals(tester.isPalindrome(" b   o   b  "), true);
        assertEquals(tester.isPalindrome("Bob"), true);
        assertEquals(tester.isPalindrome("   do  g  ee s  e  s  ee     g od"), true);
        assertEquals(tester.isPalindrome("bobro"), false);
        end_suite();

        start_suite("includes Palindrome suite");
        assertEquals(tester.containsPalindrome("bobber kurva bob jou mal naai"), true);
        assertEquals(tester.containsPalindrome("I drive a race car for a living"), true);
        assertEquals(tester.containsPalindrome("monkey "), false);
        assertEquals(tester.containsPalindrome(" b  adfa o   b  "), false);
        assertEquals(tester.containsPalindrome("Bob"), true);
        assertEquals(tester.containsPalindrome("   do  g  ee s  e  s  ee     g od"), true);
        assertEquals(tester.containsPalindrome("boyro"), false);
        end_suite();

        end_all();
    }
}