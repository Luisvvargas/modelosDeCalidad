package mx.edu.cetys.avargas.modelos.modulo2.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CicloDeVidaTest {

    //1 Valida lenguaje
    //2 Compila el codigo
    //3 Ejecuta los bloques estaticos
    //3.5 Ejecutan los before
    //4 Ejecutar las pruebas/codigo ...

    // Before
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All: se ejecuta antes de todas las pruebas");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each: se ejecuta antes de cada prueba");
    }

    // Sin Test Junit no sabe que es para prueba
    @Test
    void test1(){
        System.out.println("Test - 1");
    }
    @Test
    void test2(){
        System.out.println("Test - 2");
    }

    // After
    @AfterEach
    void afterEach(){
        System.out.println("After Each: se ejecuta despues de cada prueba");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All: se ejecuta despues de todas las pruebas");
    }



}
