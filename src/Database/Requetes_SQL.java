package Database;

import Metier.*;

public class Requetes_SQL {
	
	
	public static String ajouter_entreprise(Entreprise entrep1) {
		return "INSERT INTO entreprise VALUES ('"
				+ entrep1.getMatricule_fiscale()
				+ "','"
				+ entrep1.getRaison_sociale()
				+ "','"
				+ entrep1.getType()
				+ "','"
				+ entrep1.getDescription_activité()
				+ "','"
				+ entrep1.getCompte_bancaire()
				+ "','"
				+ entrep1.getAdresse()
				+ "','"
				+ entrep1.getNum_tlf_fixe()
				+ "','"
				+ entrep1.getNum_tlf_mobile()
				+ "','"
				+ entrep1.getFax()
				+ "','"
				+ entrep1.getEmail()
				+ "','"
				+ entrep1.getSite_web()
				+ "','"
				+ entrep1.getDonnée_etat_fiscale()+"');";
	}
	
	public static String modifier_entreprise(Entreprise entrepUp) {
		return "UPDATE entreprise SET raison_sociale='" + entrepUp.getRaison_sociale() + "', type='"
				+ entrepUp.getType() + "', description_activite='" + entrepUp.getDescription_activité()
				+ "', compte_bancaire='" + entrepUp.getCompte_bancaire() 
			    + "', adresse='" + entrepUp.getAdresse()
				+ "', num_tel_fixe='" + entrepUp.getNum_tlf_fixe()
				+ "', num_tel_mobile='" + entrepUp.getNum_tlf_mobile()
				+ "', fax='" + entrepUp.getFax()
				+ "', email='" + entrepUp.getEmail()
				+ "', site_web='" + entrepUp.getSite_web()
				+ "', etat_fiscale='" + entrepUp.getDonnée_etat_fiscale()
				+ "' WHERE matricule_fiscale='" + entrepUp.getMatricule_fiscale()
				+ "';";
	}
	

	
	public static String ajouter_devis(Devis devisAdd) {
		return "INSERT INTO devis (date,client,ligne_devis,m_total_TVA,m_total_hors_TVA,m_total_Payer) VALUES ('"
				
				+ devisAdd.getDate()
				+ "','"
				+ devisAdd.getClient()
				+ "','"
				+ devisAdd.getListe_produits_demandees()
				+ "','"
				+ devisAdd.getM_total_TVA()
				+ "','"
				+ devisAdd.getM_total_hors_TVA()
				+ "','"
				+ devisAdd.getM_total_Payer()
				+"');";
	}
	
	public static String modifier_devis(Devis devisUp) {
		return "UPDATE devis SET date='" + devisUp.getDate() + "', client='"
				+ devisUp.getClient() + "',"
			    + "ligne_devis='"+devisUp.getListe_produits_demandees()+"',"
			    + "m_total_TVA='"+devisUp.getM_total_TVA()+"',"
			    + "m_total_hors_TVA='"+devisUp.getM_total_hors_TVA()+"',"
			    + "m_total_Payer='"+devisUp.getM_total_Payer()
				+ "' WHERE code='" + devisUp.getCode()
				+ "';";
	}
	
	
	
	
	public static String ajouter_client(Client client1) {
		return "INSERT INTO client VALUES ('"
				+ client1.getCode()
				+ "','"
				+ client1.getMatricule_fiscale()
				+ "','"
				+ client1.getRaison_sociale()
				+ "','"
				+ client1.getType()
				+ "','"
				+ client1.getDescription_activité()
				+ "','"
				+ client1.getCompte_bancaire()
				+ "','"
				+ client1.getAdresse()
				+ "','"
				+ client1.getNum_tlf_fixe()
				+ "','"
				+ client1.getNum_tlf_mobile()
				+ "','"
				+ client1.getFax()
				+ "','"
				+ client1.getEmail()
				+ "','"
				+ client1.getSite_web()
				+ "','"
				+ client1.getDonnée_etat_fiscale()+"');";
	}
	
	public static String modifier_client(Client clientUp) {
		return "UPDATE client SET matricule_fiscale='" + clientUp.getMatricule_fiscale() + "',"
				+ "raison_sociale='" + clientUp.getRaison_sociale() + "', type='"
				+ clientUp.getType() + "', description='" + clientUp.getDescription_activité()
				+ "', compte_bancaire='" + clientUp.getCompte_bancaire() 
			    + "', adresse='" + clientUp.getAdresse()
				+ "', num_tlf_fixe='" + clientUp.getNum_tlf_fixe()
				+ "', num_tlf_mobile='" + clientUp.getNum_tlf_mobile()
				+ "', fax='" + clientUp.getFax()
				+ "', email='" + clientUp.getEmail()
				+ "', site_web='" + clientUp.getSite_web()
				+ "', etat_fiscale='" + clientUp.getDonnée_etat_fiscale()
				+ "' WHERE code='" + clientUp.getCode()
				+ "';";
	}
	
	public static String ajouter_fournisseur(Fournisseur fournisseur1) {
		return "INSERT INTO fournisseur VALUES ('"
				+ fournisseur1.getCode()
				+ "','"
				+ fournisseur1.getMatricule_fiscale()
				+ "','"
				+ fournisseur1.getRaison_sociale()
				+ "','"
				+ fournisseur1.getType()
				+ "','"
				+ fournisseur1.getDescription_activité()
				+ "','"
				+ fournisseur1.getCompte_bancaire()
				+ "','"
				+ fournisseur1.getAdresse()
				+ "','"
				+ fournisseur1.getNum_tlf_fixe()
				+ "','"
				+ fournisseur1.getNum_tlf_mobile()
				+ "','"
				+ fournisseur1.getFax()
				+ "','"
				+ fournisseur1.getEmail()
				+ "','"
				+ fournisseur1.getSite_web()
				+ "','"
				+ fournisseur1.getDonnée_etat_fiscale()+"');";
	}
	
	public static String modifier_fournisseur(Fournisseur fournisseurUp) {
		return "UPDATE fournisseur SET matricule_fiscale='" + fournisseurUp.getMatricule_fiscale() + "',"
				+ "raison_sociale='" + fournisseurUp.getRaison_sociale() + "', type='"
				+ fournisseurUp.getType() + "', description='" + fournisseurUp.getDescription_activité()
				+ "', compte_bancaire='" + fournisseurUp.getCompte_bancaire() 
			    + "', adresse='" + fournisseurUp.getAdresse()
				+ "', num_tlf_fixe='" + fournisseurUp.getNum_tlf_fixe()
				+ "', num_tlf_mobile='" + fournisseurUp.getNum_tlf_mobile()
				+ "', fax='" + fournisseurUp.getFax()
				+ "', email='" + fournisseurUp.getEmail()
				+ "', site_web='" + fournisseurUp.getSite_web()
				+ "', etat_fiscale='" + fournisseurUp.getDonnée_etat_fiscale()
				+ "' WHERE code='" + fournisseurUp.getCode()
				+ "';";
	}
	
	
	
	public static String ajouter_produit(Produit produit1) {
		return "INSERT INTO produit VALUES ('"
				+ produit1.getCode()
				+ "','"
				+ produit1.getRef()
				+ "','"
				+ produit1.getDesignation()
				+ "','"
				+ produit1.getUnite_mesure()
				+ "','"
				+ produit1.getFournisseur()
				+ "','"
				+ produit1.getFamille_produit()
				+ "','"
				+ produit1.getStock()
				+ "','"
				+ produit1.getStock_min()
				+ "','"
				+ produit1.getPU_hors_taxe()
				+ "','"
				+ produit1.getTVA()+"');";
	}
	
	public static String modifier_produit(Produit produitUp) {
		return "UPDATE produit SET ref='" + produitUp.getRef() + "', designation='"
				+ produitUp.getDesignation() + "', unite_mesure='" + produitUp.getUnite_mesure() + "',"
				+ "fournisseur='" + produitUp.getFournisseur()+"', famille_produit='"
				+produitUp.getFamille_produit() + "',"
			    + "stock='"+produitUp.getStock()+ "',"
			    + "stock_min='"+produitUp.getStock_min()+ "',"
			    + "PU_hors_taxe='"+produitUp.getPU_hors_taxe()+"',"
			    + "TVA='"+produitUp.getTVA()
				+ "' WHERE code='" + produitUp.getCode()
				+ "';";
	}
	
	public static String ajouter_bon_reception(Bon_reception bonreception1) {
		return "INSERT INTO bon_reception(code_fournisseur,date_bon,date_reception,adresse_reception,num_cmd_achat,ligne_br,m_total_TVA,m_total_hors_TVA,m_total_Payer) VALUES ('"
				/*+ bonreception1.getCode()
				+ "','"*/
				+ bonreception1.getCodefournisseur()
				+ "','"
				+ bonreception1.getDate_bon()
				+ "','"
				+ bonreception1.getDate_reception()
				+ "','"
				+ bonreception1.getAdresse_reception()
				+ "','"
				+ bonreception1.getNum_cmd_achat()
				+ "','"
				+ bonreception1.getLigne_br()
				+ "','"
				+ bonreception1.getM_total_TVA()
				+ "','"
				+ bonreception1.getM_total_hors_TVA()
				+ "','"
				+ bonreception1.getM_total_Payer()+"');";
	}
	
	public static String modifier_bon_reception(Bon_reception bonreceptionUp) {
		return "UPDATE bon_reception SET code_fournisseur='" + bonreceptionUp.getCodefournisseur() + "', date_bon='"
				+ bonreceptionUp.getDate_bon() + "', date_reception='" + bonreceptionUp.getDate_reception() + "',"
				+ "adresse_reception='" + bonreceptionUp.getAdresse_reception()+"', num_cmd_achat='"
				+bonreceptionUp.getNum_cmd_achat() + "',"
			    + "ligne_br='"+bonreceptionUp.getLigne_br()+"',"
			    + "m_total_TVA='"+bonreceptionUp.getM_total_TVA()+"',"
			    + "m_total_hors_TVA='"+bonreceptionUp.getM_total_hors_TVA()+"',"
			    + "m_total_Payer='"+bonreceptionUp.getM_total_Payer()
				+ "' WHERE code='" + bonreceptionUp.getCode()
				+ "';";
	}

	public static String ajouter_bon_livraison(Bon_livraison bonlivraison1) {
		return "INSERT INTO bon_livraison(code_client,date_bon,date_livraison,adresse_livraison,num_cmd_vente,ligne_bl,"
				+ "m_total_hors_TVA,m_total_TVA,m_total_Payer) VALUES ('"
				/*+ bonlivraison1.getCode()
				+ "','"*/
				+ bonlivraison1.getCodeclient()
				+ "','"
				+ bonlivraison1.getDate_bon()
				+ "','"
				+ bonlivraison1.getDate_livraison()
				+ "','"
				+ bonlivraison1.getAdresse_livraison()
				+ "','"
				+ bonlivraison1.getNum_cmd_vente()
				+ "','"
				+ bonlivraison1.getLigne_bl()
				+ "','"
				+ bonlivraison1.getM_total_TVA()
				+ "','"
				+ bonlivraison1.getM_total_hors_TVA()
				+ "','"
				+ bonlivraison1.getM_total_Payer()+"');";
	}
	
	public static String modifier_bon_livraison(Bon_livraison bonlivraisonUp) {
		return "UPDATE bon_livraison SET code_client='" + bonlivraisonUp.getCodeclient() + "', date_bon='"
				+ bonlivraisonUp.getDate_bon() + "', date_livraison='" + bonlivraisonUp.getDate_livraison() + "',"
				+ "adresse_livraison='" + bonlivraisonUp.getAdresse_livraison()+"', num_cmd_vente='"
				+bonlivraisonUp.getNum_cmd_vente() + "',"
			    + "ligne_bl='"+bonlivraisonUp.getLigne_bl()+"',"
			    + "m_total_TVA='"+bonlivraisonUp.getM_total_TVA()+"',"
			    + "m_total_hors_TVA='"+bonlivraisonUp.getM_total_hors_TVA()+"',"
			    + "m_total_Payer='"+bonlivraisonUp.getM_total_Payer()
				+ "' WHERE code='" + bonlivraisonUp.getCode()
				+ "';";
	}
	
	/*public static String ajouter_facture_client(Facture_client facture_client1) {
		return "INSERT INTO facture_client VALUES ('"
				+ facture_client1.getCode()
				+ "','"
				+ facture_client1.getClient()
				+ "','"
				+ facture_client1.getDate_facture()
				+ "','"
				+ facture_client1.getMode_payement()
				+ "','"
				+ facture_client1.gettype()+"');";
	}
	
	public static String modifier_facture_client(Facture_client facture_clientUp) {
		return "UPDATE facture_client SET client='" + facture_clientUp.getClient() + "', date_facture='"
				+ facture_clientUp.getDate_facture() + "', mode_payement='" + facture_clientUp.getMode_payement() + "',"
				+ "type='" + facture_clientUp.gettype()+"', num_cmd_achat='"
				+ "' WHERE code='" + facture_clientUp.getCode()
				+ "';";
	}*/
	
	public static String ajouter_ligne_BR(Ligne_BR ligneBR1) {
		return "INSERT INTO ligne_br VALUES ('"
				+ ligneBR1.getRef()
				+ "','"
				+ ligneBR1.getCodeFournisseur()
				+ "','"
				+ ligneBR1.getDesignation()
				+ "','"
				+ ligneBR1.getUnite_mesure()
				+ "','"
				+ ligneBR1.getQte_receptionnee()
				+ "','"
				+ ligneBR1.getPU_hors_TVA()
				+ "','"
				+ ligneBR1.getTVA()
				+ "','"
				+ ligneBR1.getP_total_horsTVA()+"');";
	}
	
	public static String modifier_ligneBR(Ligne_BR ligneBRUp) {
		return "UPDATE ligne_br SET code_fournisseur='" + ligneBRUp.getCodeFournisseur() + "', designation='"
				+ ligneBRUp.getDesignation() + "', unite_mesure='" + ligneBRUp.getUnite_mesure() + "',"
				+ "qte_receptionnee='" + ligneBRUp.getQte_receptionnee()+"', PU_hors_TVA='"
				+ligneBRUp.getPU_hors_TVA() + "',"
			    + "TVA='"+ligneBRUp.getTVA()+ "',"
			    + "P_total_horsTVA='"+ligneBRUp.getP_total_horsTVA()
				+ "' WHERE ref='" + ligneBRUp.getRef()
				+ "';";
	}
	
	public static String ajouter_ligne_BL(Ligne_BL ligneBL1) {
		return "INSERT INTO ligne_bl VALUES ('"
				+ ligneBL1.getRef()
				+ "','"
				+ ligneBL1.getCodeClient()
				+ "','"
				+ ligneBL1.getDesignation()
				+ "','"
				+ ligneBL1.getUnite_mesure()
				+ "','"
				+ ligneBL1.getQte_livree()
				+ "','"
				+ ligneBL1.getPU_hors_TVA()
				+ "','"
				+ ligneBL1.getTVA()
				+ "','"
				+ ligneBL1.getP_total_horsTVA()+"');";
	}
	
	public static String modifier_ligneBL(Ligne_BL ligneBLUp) {
		return "UPDATE ligne_bl SET code_client='" + ligneBLUp.getCodeClient() + "', designation='"
				+ ligneBLUp.getDesignation() + "', unite_mesure='" + ligneBLUp.getUnite_mesure() + "',"
				+ "qte_livree='" + ligneBLUp.getQte_livree()+"', PU_hors_TVA='"
				+ligneBLUp.getPU_hors_TVA() + "',"
			    + "TVA='"+ligneBLUp.getTVA()+ "',"
			    + "P_total_horsTVA='"+ligneBLUp.getP_total_horsTVA()
				+ "' WHERE ref='" + ligneBLUp.getRef()
				+ "';";
	}
	
	
	public static String ajouter_ligne_devis(Ligne_devis lignedevisAdd) {
		return "INSERT INTO ligne_devis VALUES ('"
				+ lignedevisAdd.getRef()
				+ "','"
				+ lignedevisAdd.getCode_client()
				+ "','"
				+ lignedevisAdd.getDesignation()
				+ "','"
				+ lignedevisAdd.getUnite_mesure()
				+ "','"
				+ lignedevisAdd.getQte_receptionnee()
				+ "','"
				+ lignedevisAdd.getPU_hors_TVA()
				+ "','"
				+ lignedevisAdd.getTVA_appliquee()
				+ "','"
				+ lignedevisAdd.getP_total_horsTVA()+"');";
	}
	
	public static String modifier_ligne_devis(Ligne_devis lignedevisUp) {
		return "UPDATE ligne_br SET code_client='" + lignedevisUp.getCode_client() + "', designation='"
				+ lignedevisUp.getDesignation() + "', unite_mesure='" + lignedevisUp.getUnite_mesure() + "',"
				+ "qte_receptionnee='" + lignedevisUp.getQte_receptionnee()+"', PU_hors_TVA='"
				+lignedevisUp.getPU_hors_TVA() + "',"
			    + "TVA_appliquee='"+lignedevisUp.getTVA_appliquee()+ "',"
			    + "P_total_horsTVA='"+lignedevisUp.getP_total_horsTVA()
				+ "' WHERE ref='" + lignedevisUp.getRef()
				+ "';";
	}
	
	public static String stock_select() {
		return "SELECT * FROM produit  where stock < stock_min " ;
	}
	
	public static String ajouter_facture_fournisseur_BL(Facture_fournisseur_BL factureBLAdd) {
		return "INSERT INTO facture_fournisseur_bl VALUES ('"
				+ factureBLAdd.getCode()
				+ "','"
				+ factureBLAdd.getFournisseur()
				+ "','"
				+ factureBLAdd.getDate_facture()
				+ "','"
				+ factureBLAdd.getMode_payement()
				+ "','"
				+ factureBLAdd.getType_facture()
				+ "','"
				+ factureBLAdd.getCode_bonrecep()
				+ "','"
				+factureBLAdd.getM_total_Payer()
				+ "','"
				+factureBLAdd.getM_Payer()
				+ "','"
				+factureBLAdd.getM_Reste()
				+"');";
	}
	
	public static String modifier_facture_fournisseur_BL(Facture_fournisseur_BL factureBLModif) {
		return "UPDATE facture_fournisseur_bl SET code_fournisseur='" + factureBLModif.getFournisseur() + "', date_facture='"
				+ factureBLModif.getDate_facture()+ "', mode_payement='" + factureBLModif.getMode_payement() + "',"
				+ "type_facture='" + factureBLModif.getType_facture()+"', code_bon_recep='"
				+factureBLModif.getCode_bonrecep() + "',"
			    + "m_total_Payer='"+factureBLModif.getM_total_Payer()+ "',"
			    + "m_Payer='"+factureBLModif.getM_Payer()+ "',"
			    + "m_Reste='"+factureBLModif.getM_Reste()
				+ "' WHERE code='" + factureBLModif.getCode()
				+ "';";
	}
	
	
	public static String ajouter_facture_client_BL(Facture_client_BL factureBLAdd) {
		return "INSERT INTO facture_client_bl VALUES ('"
				+ factureBLAdd.getCode()
				+ "','"
				+ factureBLAdd.getClient()
				+ "','"
				+ factureBLAdd.getDate_facture()
				+ "','"
				+ factureBLAdd.getMode_payement()
				+ "','"
				+ factureBLAdd.getType_facture()
				+ "','"
				+ factureBLAdd.getCode_bonlivr()
				+ "','"
				+factureBLAdd.getM_total_Payer()
				+"');";
	}
	
	public static String modifier_facture_client_BL(Facture_client_BL factureBLModif) {
		return "UPDATE facture_client_bl SET code_client='" + factureBLModif.getClient() + "', date_facture='"
				+ factureBLModif.getDate_facture()+ "', mode_payement='" + factureBLModif.getMode_payement() + "',"
				+ "type_facture='" + factureBLModif.getType_facture()+"', code_bon_livr='"
				+factureBLModif.getCode_bonlivr() + "',"
			    + "m_total_Payer='"+factureBLModif.getM_total_Payer()
			    + "' WHERE code='" + factureBLModif.getCode()
				+ "';";
	}
	
	public static String ajouter_facture_avoir(Facture_avoir factureavoirAdd) {
		return "INSERT INTO facture_avoir VALUES ('"
				+ factureavoirAdd.getCode()
				+ "','"
				+ factureavoirAdd.getCode_client()
				+ "','"
				+ factureavoirAdd.getDate_facture()
				+ "','"
				+ factureavoirAdd.getMode_payement()
				+ "','"
				+ factureavoirAdd.getCode_facture_client()
				+ "','"
				+ factureavoirAdd.getQteRetour()
				+ "','"
				+ factureavoirAdd.getDesigProd()
				+ "','"
				+ factureavoirAdd.getMTPayer()
				+ "','"
				+ factureavoirAdd.getMRetour()
				+ "','"
				+factureavoirAdd.getMAR()
				+"');";
	}
	
	public static String modifier_facture_avoir(Facture_avoir factureavoirModif) {
		return "UPDATE facture_avoir SET code_client='" + factureavoirModif.getCode_client() + "', date_facture='"
				+ factureavoirModif.getDate_facture()+ "', mode_payement='" + factureavoirModif.getMode_payement() + "',"
				+ "code_facture_client='" + factureavoirModif.getCode_facture_client()+"', qte_retour='"
				+factureavoirModif.getQteRetour() + "',desig_prod='" 
				+factureavoirModif.getDesigProd() + "',MTPayer='"
				+factureavoirModif.getMTPayer() + "',MRetour='"
				+factureavoirModif.getMRetour() + "',"
			    + "MAR='"+factureavoirModif.getMAR()
			    + "' WHERE code='" + factureavoirModif.getCode()
				+ "';";
	}
	
}
