package com.entreprise.app;

import com.entreprise.compta.Facture;
import com.entreprise.compta.Payable;
import com.entreprise.exceptions.EquipeCompleteException;
import com.entreprise.exceptions.MontantInvalideException;
import com.entreprise.rh.Augmentable;
import com.entreprise.rh.ChefProjet;
import com.entreprise.rh.Commercial;
import com.entreprise.rh.Employe;
import com.entreprise.rh.Permanent;

public class Program {
    public static void main(String[] args) throws MontantInvalideException {
        Service service = new Service(4);

        try {
            service.ajouter(new Commercial("Karim", 3000, 40000, "Rabat"));
            service.ajouter(new ChefProjet("Salma", 6000, "Casablanca"));
        } catch (MontantInvalideException | EquipeCompleteException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        String[] noms = {"Nadia", "Omar", "Yassine", "Leila", "Hamza"};
        String[] salaires = {"4500", "abc", "-800", "3800", "5200"};
        int tentatives = 0;

        for (int i = 0; i < noms.length; i++) {
            try {
                double salaire = Double.parseDouble(salaires[i]);
                Permanent p = new Permanent(noms[i], salaire);
                service.ajouter(p);
                System.out.println("Embauche de " + noms[i] + " : " + salaire);
            } catch (NumberFormatException e) {
                System.out.println("Saisie ignorée : \"" + salaires[i] + "\" n'est pas un montant");
            } catch (EquipeCompleteException e) {
                System.out.println("Erreur : " + e.getMessage());
            } finally {
                tentatives++;
            }
        }
        System.out.println("Tentatives : " + tentatives+ ", employés dans le service : " + service.getNb());
        service.trier();
        service.afficher();
        System.out.println("Masse salariale : " + service.getMasseSalariale());

        Employe moinsPaye = service.getEmploye(0);
        try {
            Augmentable a = (Augmentable) moinsPaye; 
            a.augmenterStandard();
            System.out.println("Après augmentation : " + moinsPaye);
            a.augmenter(0.5);
            System.out.println("Cette ligne ne s'affiche jamais");
        } catch (MontantInvalideException e) {
            System.out.println("Erreur : " + e.getMessage()
                    + " [valeur reçue : " + e.getValaur() + "]");
        }

        try {
            service.getEmploye(7);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            Payable[] paiements = {
                new Facture("F-102", "Bureau Plus", 450),
                service.getEmploye(1)
            };
            double total = 0;
            for (Payable p : paiements) {
                System.out.println("À payer : " + p);
                total += p.getMontantAPayer();
            }
            System.out.println("Total à payer : " + total);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Nombre d'employés créés : " + Employe.getNbEmploye());
    }
}