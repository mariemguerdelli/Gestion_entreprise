package Metier;

public class Entreprise {
	String matricule_fiscale;
	String raison_sociale;
	String type;
	String description_activit�;
	String compte_bancaires;
	String adresse;
	int num_tlf_fixe;
	int num_tlf_mobile;
	int fax;
	String email;
	String site_web;
	String donn�e_etat_fiscale;
	
	
	public Entreprise(String matricule_fiscale, String raison_sociale, String type, String description_activit�,
			String compte_bancaires, String adresse, int num_tlf_fixe, int num_tlf_mobile, int fax, String email,
			String site_web, String donn�e_etat_fiscale) {
		
		super();
		
		this.matricule_fiscale = matricule_fiscale;
		this.raison_sociale = raison_sociale;
		this.type = type;
		this.description_activit� = description_activit�;
		this.compte_bancaires = compte_bancaires;
		this.adresse = adresse;
		this.num_tlf_fixe = num_tlf_fixe;
		this.num_tlf_mobile = num_tlf_mobile;
		this.fax = fax;
		this.email = email;
		this.site_web = site_web;
		this.donn�e_etat_fiscale = donn�e_etat_fiscale;
	}
	public String getMatricule_fiscale() {
		return matricule_fiscale;
	}
	public void setMatricule_fiscale(String matricule_fiscale) {
		this.matricule_fiscale = matricule_fiscale;
	}
	public String getRaison_sociale() {
		return raison_sociale;
	}
	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription_activit�() {
		return description_activit�;
	}
	public void setDescription_activit�(String description_activit�) {
		this.description_activit� = description_activit�;
	}
	public String getCompte_bancaire() {
		return compte_bancaires;
	}
	public void setCompte_bancaire(String compte_bancaires) {
		this.compte_bancaires = compte_bancaires;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNum_tlf_fixe() {
		return num_tlf_fixe;
	}
	public void setNum_tlf_fixe(int num_tlf_fixe) {
		this.num_tlf_fixe = num_tlf_fixe;
	}
	public int getNum_tlf_mobile() {
		return num_tlf_mobile;
	}
	public void setNum_tlf_mobile(int num_tlf_mobile) {
		this.num_tlf_mobile = num_tlf_mobile;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite_web() {
		return site_web;
	}
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}
	public String getDonn�e_etat_fiscale() {
		return donn�e_etat_fiscale;
	}
	public void setDonn�e_etat_fiscale(String donn�e_etat_fiscale) {
		this.donn�e_etat_fiscale = donn�e_etat_fiscale;
	}
	@Override
	public String toString() {
		return "Entreprise [matricule_fiscale=" + matricule_fiscale + ", raison_sociale=" + raison_sociale + ", type="
				+ type + ", description_activit�=" + description_activit� + ", compte_bancaire=" + compte_bancaires
				+ ", adresse=" + adresse + ", num_tlf_fixe=" + num_tlf_fixe + ", num_tlf_mobile=" + num_tlf_mobile
				+ ", fax=" + fax + ", email=" + email + ", site_web=" + site_web + ", donn�e_etat_fiscale="
				+ donn�e_etat_fiscale + "]";
	}
	
	

}
