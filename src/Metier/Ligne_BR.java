package Metier;

public class Ligne_BR {
	int ref;
	int codeFournisseur;
	String designation;
	String unite_mesure;
	int qte_receptionnee;
	float PU_hors_TVA;
	float TVA;
	float P_total_horsTVA;
	public Ligne_BR() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne_BR(int ref, int codeFournisseur, String designation, String unite_mesure, int qte_receptionnee,
			float pU_hors_TVA, float tVA, float p_total_horsTVA) {
		super();
		this.ref = ref;
		this.codeFournisseur = codeFournisseur;
		this.designation = designation;
		this.unite_mesure = unite_mesure;
		this.qte_receptionnee = qte_receptionnee;
		PU_hors_TVA = pU_hors_TVA;
		TVA = tVA;
		P_total_horsTVA = p_total_horsTVA;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(int codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUnite_mesure() {
		return unite_mesure;
	}
	public void setUnite_mesure(String unite_mesure) {
		this.unite_mesure = unite_mesure;
	}
	public int getQte_receptionnee() {
		return qte_receptionnee;
	}
	public void setQte_receptionnee(int qte_receptionnee) {
		this.qte_receptionnee = qte_receptionnee;
	}
	public float getPU_hors_TVA() {
		return PU_hors_TVA;
	}
	public void setPU_hors_TVA(float pU_hors_TVA) {
		PU_hors_TVA = pU_hors_TVA;
	}
	public float getTVA() {
		return TVA;
	}
	public void setTVA(float tVA) {
		TVA = tVA;
	}
	public float getP_total_horsTVA() {
		return P_total_horsTVA;
	}
	public void setP_total_horsTVA(float p_total_horsTVA) {
		P_total_horsTVA = p_total_horsTVA;
	}
	@Override
	public String toString() {
		return "Ligne_BR [ref=" + ref + ", codeFournisseur=" + codeFournisseur + ", designation=" + designation
				+ ", unite_mesure=" + unite_mesure + ", qte_receptionnee=" + qte_receptionnee + ", PU_hors_TVA="
				+ PU_hors_TVA + ", TVA=" + TVA + ", P_total_horsTVA=" + P_total_horsTVA + "]";
	}
	
	
	
}
