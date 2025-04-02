package mx.edu.cetys.avargas.modelos.mockito;

import mx.edu.cetys.avargas.modelos.modulo2.practica.EmailValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

// Vamos a usar la libreria de mockito
// Para decirle a JUNIT que ejecute las pruebas con el
// plugin de Mockito, usamos la siguiente anotacion:

@ExtendWith(MockitoExtension.class)
public class MockitoExampleTest {

    // List
    @Mock
    private List<String> mockList;

    @Mock
    private EmailValidator emailValidatorMock;

    @Test
    @DisplayName("Prueba para usar mocks con la interfaz de List<> de Java")
    public void test_usingMockToModifyListBehavior(){

        mockList.add("One");
        mockList.add("Two");

        //Modify behavior
        when(mockList.size())
                .thenReturn(1000)
                .thenReturn(1)
                .thenThrow(NullPointerException.class);

        assertEquals(1000, mockList.size());
        assertEquals(1, mockList.size());
        assertThrows(NullPointerException.class, () -> mockList.size());
        //assertEquals(2, mockList.size());
    }

    @Test
    @DisplayName("Modificar el comportamiento del emailValidator")
    public void setEmailValidatorMockTest(){
        // Modify Behavior // No longer has precedence
        //when(emailValidatorMock.isValid("a@b.c"))
                //.thenReturn(true);

        // ARGUMENT MATCHING
        when(emailValidatorMock.isValid(anyString()))
                .thenReturn(false);

        assertFalse(emailValidatorMock.isValid("a#b.c"));
        assertFalse(emailValidatorMock.isValid("asdfasdf"));
        assertFalse(emailValidatorMock.isValid("a@b.c"));
    }
}
