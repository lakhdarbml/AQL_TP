package org.example.tp2;

public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
            System.out.println("Email invalide, utilisateur non créé.");
            return; // Ne pas appeler l'API
        }

        int id = utilisateurApi.creerUtilisateur(utilisateur);
        utilisateur.setId(id); // simuler un retour d'ID
    }
}
