package org.example.tp2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreationUtilisateur_Echec() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Ali", "Yahia", "ali@email.com");

        doThrow(new ServiceException("Échec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        assertEquals("Échec de la création de l'utilisateur", exception.getMessage());
    }

    @Test
    public void testCreationUtilisateur_ErreurValidation() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Ali", "Yahia", ""); // Email vide

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }

    @Test
    public void testCreationUtilisateur_AssigneID() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Nora", "Salah", "nora@email.com");
        int idUtilisateur = 123;

        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(idUtilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        assertEquals(idUtilisateur, utilisateur.getId());
    }

    @Test
    public void testArgumentCaptor_Utilisateur() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Salim", "Kaci", "salim@email.com");

        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(456);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("Salim", utilisateurCapture.getNom());     // ⚠️ ordre respecté
        assertEquals("Kaci", utilisateurCapture.getPrenom());
        assertEquals("salim@email.com", utilisateurCapture.getEmail());
    }
}

