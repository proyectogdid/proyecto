package com.company.comun;

/**
 * Clase que se va a utilizar para asignar constantes a las diferentes clases del paquete LN
 */
public class clsConstantes {

    public static final String AFICIONADO_FAVORITO = "favorito";

    public static final String PARTICIPANTES_PARTIDOS_GANADOS = "partidosGanados";
    public static final String PARTICIPANTES_PARTIDOS_PERDIDOS = "partidosPerdidos";
    public static final String PARTICIPANTES_PARTIDOS_JUGADOS = "partidosJugados";
    public static final String PARTICIPANTES_PUNTOS_A_FAVOR = "puntosAFavor";
    public static final String PARTICIPANTES_PUNTOS_EN_CONTRA = "puntosEnContra";


    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CIUDAD = "ciudad";
    public static final String CAMPO_CALLE = "calle";
    public static final String CAMPO_NUMERO = "numero";
    public static final String CAMPO_CP = "cp";
    public static final String CAMPO_AFORO = "aforo";

    public static final String BD_CAMPO_ID = "cmp.id";
    public static final String BD_CAMPO_NOMBRE = "cmp.nombre";
    public static final String BD_CAMPO_CIUDAD = "cmp.ciudad";
    public static final String BD_CAMPO_CALLE = "cmp.calle";
    public static final String BD_CAMPO_NUMERO = "cmp.numero";
    public static final String BD_CAMPO_CP = "cmp.cp";
    public static final String BD_CAMPO_AFORO = "cmp.cantidad";


    public static final String EQUIPO_ID = "id";
    public static final String EQUIPO_NOMBRE = "nombre";
    public static final String EQUIPO_PATROCINADOR = "patrocinador";
    public static final String EQUIPO_JUGADORES = "jugadores";
    public static final String EQUIPO_CAMPO="campo";


    public static final String BD_EQUIPO_ID="eqp.id";
    public static final String BD_EQUIPO_NOMBRE = "eqp.nombre";
    public static final String BD_EQUIPO_PATROCINADOR = "eqp.patrocinador";
    public static final String BD_EQUIPO_CAMPO="eqp.campo";


    public static final String ESTADO_ID = "id";
    public static final String ESTADO_NOMBRE = "nombre";


    public static final String BD_ESTADO_ID = "estd.id";
    public static final String BD_ESTADO_NOMBRE = "estd.nombre";

    public static final String EVENTO_ID = "id";
    public static final String EVENTO_ESTADO_PREVIO = "estadoPrevio";
    public static final String EVENTO_ESTADO_POSTERIOR = "estadoPosterior";
    public static final String EVENTO_JUGADOR = "jugador";

    public static final String BD_EVENTO_ID = "eve.id";
    public static final String BD_EVENTO_ESTADO_PREVIO = "eve.estadoPrevio";
    public static final String BD_EVENTO_ESTADO_POSTERIOR = "eve.estadoPosterior";
    public static final String BD_EVENTO_JUGADOR = "eve.jugador";


    public static final String JUGADOR_ID = "id";
    public static final String JUGADOR_NOMBRE = "nombre";
    public static final String JUGADOR_APELLIDO1 = "apellido1";
    public static final String JUGADOR_APELLIDO2 = "apellido2";
    public static final String JUGADOR_FECHA_NACIMIENTO = "fechaNac";
    public static final String JUGADOR_DORSAL = "dorsal";
    public static final String JUGADOR_TEXTO_CAMISETA = "textoCamiseta";
    public static final String JUGADOR_EQUIPO = "equipo";
    public static final String JUGADOR_POSICION = "posicion";
    public static final String JUGADOR_ESTADO = "estado";

    public static final String BD_JUGADOR_ID = "jug.id";
    public static final String BD_JUGADOR_NOMBRE = "jug.nombre";
    public static final String BD_JUGADOR_APELLIDO1 = "jug.apellido1";
    public static final String BD_JUGADOR_APELLIDO2 = "jug.apellido2";
    public static final String BD_JUGADOR_FECHA_NACIMIENTO = "jug.fechaNac";
    public static final String BD_JUGADOR_DORSAL = "jug.dorsal";
    public static final String BD_JUGADOR_TEXTO_CAMISETA = "jug.textoCamiseta";

    public static final String PARTIDO_ID = "id";
    public static final String PARTIDO_FECHA = "fecha";
    public static final String PARTIDO_PTOS_LOCAL = "ptosLocal";
    public static final String PARTIDO_PTOS_VISITANTE = "ptosVisitante";
    public static final String PARTIDO_LOCAL = "local";
    public static final String PARTIDO_VISITANTE = "visitante";
    public static final String PARTIDO_TEMPORADA = "temporada";
    public static final String PARTIDO_CAMPO = "campo";
    public static final String PARTIDO_JORNADA="jornada";

    public static final String BD_PARTIDO_ID = "par.id";
    public static final String BD_PARTIDO_FECHA = "par.fecha";
    public static final String BD_PARTIDO_PTOS_LOCAL = "par.ptosLocal";
    public static final String BD_PARTIDO_PTOS_VISITANTE = "par.ptosVisitante";
    public static final String BD_PARTIDO_JORNADA = "par.jornada";
    public static final String BD_PARTIDO_LOCAL = "par.local";
    public static final String BD_PARTIDO_VISITANTE = "par.visitante";

    public static final String POSICION_ID = "id";
    public static final String POSICION_NOMBRE = "nombre";

    public static final String BD_POSICION_ID = "pscn.id";
    public static final String BD_POSICION_NOMBRE = "pscn.nombre";

    public static final String TEMPORADA_ID = "id";
    public static final String TEMPORADA_ANO = "ano";
    public static final String TEMPORADA_PARTIDOS = "partidos";

    public static final String BD_TEMPORADA_ID = "tem.id";
    public static final String BD_TEMPORADA_ANO = "tem.ano";

    public static final String TRASPASO_ID = "id";
    public static final String TRASPASO_PRECIO = "precio";
    public static final String TRASPASO_JUGADOR = "jugador";
    public static final String TRASPASO_EQUIPO_PREVIO = "equipoPrevio";
    public static final String TRASPASO_EQUIPO_POSTERIOR = "equipoPosterior";

    public static final String BD_TRASPASO_ID = "tra.id";
    public static final String BD_TRASPASO_PRECIO = "tra.precio";
    public static final String BD_TRASPASO_JUGADOR = "tra.jugador";
    public static final String BD_TRASPASO_EQUIPO_PREVIO = "tra.equipoPrevio";
    public static final String BD_TRASPASO_EQUIPO_POSTERIOR = "tra.equipoPosterior";

    public static final String USUARIO_ID = "id";
    public static final String USUARIO_USERNAME = "username";
    public static final String USUARIO_CONTRASENA = "contrasena";
    public static final String USUARIO_CORREO="correo";
    public static final String USUARIO_TIPO = "tipo";
    public static final String USUARIO_TIPO_ADMIN = "ADMIN";
    public static final String USUARIO_TIPO_AFICIONADO = "AFICIONADO";

    public static final String BD_USUARIO_ID = "usr.id";
    public static final String BD_USUARIO_USERNAME = "usr.usuario";
    public static final String BD_USUARIO_CONTRASENA = "usr.contrasena";
    public static final String BD_USUARIO_CORREO="usr.correo";
    public static final String BD_USUARIO_TIPO = "usr.tipo";

}