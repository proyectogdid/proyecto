
package com.company.LN;
import java.util.Comparator;

public class Clasificacion  implements Comparator<Participantes>{


    @Override
    public int compare(Participantes p1, Participantes p2) {
        return p1.getPartidosGanados() - (p2.getPartidosGanados());
    }
}
