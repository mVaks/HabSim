package net.luxser.habsim;


public class ApplicationState {
    public static boolean get() {
        return b;
    }

    public static void set(boolean a) {
        b = a;
    }

    private static boolean b;
}