package Logic_Handle;

import Entity.Jounalist;

import static MainRun.Main.jounalists;

public class JournalistLogic {
    public static Jounalist findJounalistById(int JounalistID) {
        Jounalist jounalist=null;
        for (int j = 0; j < jounalists.length; j++) {
            if (jounalists[j] != null && jounalists[j].getId() == JounalistID) {
                jounalist = jounalists[j];
                break;
            }
        }
        return jounalist;
    }
}
