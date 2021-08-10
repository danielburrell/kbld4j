package uk.co.solong.kbld4j;

public class Kbld {
    public static KbldBuilder kbld(String kbldLocation) {
        return new KbldBuilder(kbldLocation);
    }

    public static KbldBuilder kbld() {
        return new KbldBuilder();
    }
}
