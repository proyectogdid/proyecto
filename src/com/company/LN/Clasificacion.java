
package com.company.LN;

import java.util.Comparator;

/**
 * Clase para clasificar los participantes de la liga, que no dejan de ser equipos.
 */

public class Clasificacion implements Comparator<Participantes> {


    @Override
    public int compare(Participantes p1, Participantes p2) {
        return p1.getPartidosGanados() - (p2.getPartidosGanados());
    }
}
