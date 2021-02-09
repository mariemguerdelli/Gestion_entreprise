package Metier;

public class Ligne_devis {
	int ref;
	int code_client;
	String designation;
	String unite_mesure;
	int qte_receptionnee;
	float PU_hors_TVA;
	float TVA_appliquee;
	float P_total_horsTVA;
	public Ligne_devis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne_devis(int ref, int code_client, String designation, String unite_mesure, int qte_receptionnee,
			float pU_hors_TVA, float tVA_appliquee, float p_total_horsTVA) {
		super();
		this.ref = ref;
		this.code_client = code_client;
		this.designation = designation;
		this.unite_mesure = unite_mesure;
		this.qte_receptionnee = qte_receptionnee;
		PU_hors_TVA = pU_hors_TVA;
		TVA_appliquee = tVA_appliquee;
		P_total_horsTVA = p_total_horsTVA;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getCode_client() {
		return code_client;
	}
	public void setCode_client(int code_client) {
		this.code_client = code_client;
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
	public float getTVA_appliquee() {
		return TVA_appliquee;
	}
	public void setTVA_appliquee(float tVA_appliquee) {
		TVA_appliquee = tVA_appliquee;
	}
	public float getP_total_horsTVA() {
		return P_total_horsTVA;
	}
	public void setP_total_horsTVA(float p_total_horsTVA) {
		P_total_horsTVA = p_total_horsTVA;
	}
	
	
	
	

}
