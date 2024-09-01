import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gestorDeEventosTest {

    String [][] listaPersonas = new String[10][5];

    @BeforeEach
    void setup(){
        gestorDeEventos.anadirPersona(listaPersonas, "Juan","19","VIP","2","False");
        gestorDeEventos.anadirPersona(listaPersonas,"Ana","18","General","0","False");
        gestorDeEventos.anadirPersona(listaPersonas,"Diego","21","VIP","3","False");
        gestorDeEventos.anadirPersona(listaPersonas,"Jorge","20","False","0","False");
        gestorDeEventos.anadirPersona(listaPersonas,"Juana","24","General","0","True");
        gestorDeEventos.anadirPersona(listaPersonas,"Maria","23","VIP","2","True");
        gestorDeEventos.anadirPersona(listaPersonas,"Bastian","20","General","0","True");
        gestorDeEventos.anadirPersona(listaPersonas,"Jose","16","General","0","False");
        gestorDeEventos.anadirPersona(listaPersonas,"Sebastian","21","General","0","False");
        gestorDeEventos.anadirPersona(listaPersonas,"Martin","20","General","0","True");

    }

    @Test
    void verificarEdad() {
        assertFalse(gestorDeEventos.verificarEdad(listaPersonas,"Jose"));
        assertTrue(gestorDeEventos.verificarEdad(listaPersonas,"Sebastian"));
        assertTrue(gestorDeEventos.verificarEdad(listaPersonas,"Martin"));
        assertTrue(gestorDeEventos.verificarEdad(listaPersonas,"Juana"));
    }

    @Test
    void verificarBoleto() {
        assertEquals("False",gestorDeEventos.verificarBoleto(listaPersonas,"Jorge"));
        assertEquals("VIP",gestorDeEventos.verificarBoleto(listaPersonas,"Maria"));
    }

    @Test
    void validarInvitados() {
        assertTrue(gestorDeEventos.validarInvitados(listaPersonas,"Maria"));
        assertFalse(gestorDeEventos.validarInvitados(listaPersonas,"Diego"));
    }

    @Test
    void aforoDisponible() {
        int aforoSalaVip = 1;
        int aforoSalaGeneral = 4;
        assertEquals(0,gestorDeEventos.aforoDisponible(listaPersonas,"VIP",aforoSalaVip));
        assertEquals(1,gestorDeEventos.aforoDisponible(listaPersonas,"General",aforoSalaGeneral));
    }

    @Test
    void ingresarPersona() {
        gestorDeEventos.ingresarPersona(listaPersonas,"Sebastian");
        assertEquals("True",listaPersonas[8][4]);
    }

    @Test
    void permitirEntrada() {
        assertTrue(gestorDeEventos.permitirEntrada(listaPersonas,"Juan","VIP",2));
        assertFalse(gestorDeEventos.permitirEntrada(listaPersonas,"Jose","General",5));
        assertFalse(gestorDeEventos.permitirEntrada(listaPersonas,"Bastian","General",1));

    }

    @Test
    void removerPersona() {
        String nombre = "Martin";
        gestorDeEventos.removerPersona(listaPersonas,nombre);
        assertEquals("False",listaPersonas[9][4]);
    }
}