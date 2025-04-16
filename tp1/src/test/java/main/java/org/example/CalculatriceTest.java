package main.java.org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionnerAvecMock() {
        // Arrange
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // Act
        int resultat = calculatrice.additionner(2, 3);

        // Assert
        assertEquals(5, resultat);
        verify(calculatrice).additionner(2, 3);
        verifyNoMoreInteractions(calculatrice);
    }

    @Test
    public void testAdditionnerSansMock() {
        // Arrange
        Calculatrice vraieCalculatrice = new Calculatrice();

        // Act
        int resultat = vraieCalculatrice.additionner(2, 3);

        // Assert
        assertEquals(5, resultat);
        assertEquals(5, vraieCalculatrice.getResult()); // Test de l'état
    }
}
