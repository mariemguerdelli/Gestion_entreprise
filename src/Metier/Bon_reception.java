package Metier;

import java.util.Vector;

public class Bon_reception {
	int code;
	int Codefournisseur;
	String date_bon;
	String date_reception;
	String adresse_reception;
	int num_cmd_achat;
	Vector<Ligne_BR>ligne_br;
	float m_total_TVA;
	float m_total_hors_TVA;
	float m_total_Payer;
	
	public Bon_reception(int code, int codefournisseur, String date_bon, String date_reception,
			String adresse_reception, int num_cmd_achat, Vector<Ligne_BR> ligne_br, float m_total_TVA,
			float m_total_hors_TVA, float m_total_Payer) {
		super();
		this.code = code;
		Codefournisseur = codefournisseur;
		this.date_bon = date_bon;
		this.date_reception = date_reception;
		this.adresse_reception = adresse_reception;
		this.num_cmd_achat = num_cmd_achat;
		this.ligne_br = ligne_br;
		this.m_total_TVA = m_total_TVA;
		this.m_total_hors_TVA = m_total_hors_TVA;
		this.m_total_Payer = m_total_Payer;
	}
	public Bon_reception(int code, int codefournisseur, String date_bon, String date_reception,
			String adresse_reception, int num_cmd_achat,float m_total_TVA,
			float m_total_hors_TVA, float m_total_Payer) {
		super();
		this.code = code;
		Codefournisseur = codefournisseur;
		this.date_bon = date_bon;
		this.date_reception = date_reception;
		this.adresse_reception = adresse_reception;
		this.num_cmd_achat = num_cmd_achat;
		this.m_total_TVA = m_total_TVA;
		this.m_total_hors_TVA = m_total_hors_TVA;
		this.m_total_Payer = m_total_Payer;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCodefournisseur() {
		return Codefournisseur;
	}
	public void setCodefournisseur(int codefournisseur) {
		Codefournisseur = codefournisseur;
	}
	public String getDate_bon() {
		return date_bon;
	}
	public void setDate_bon(String date_bon) {
		this.date_bon = date_bon;
	}
	public String getDate_reception() {
		return date_reception;
	}
	public void setDate_reception(String date_reception) {
		this.date_reception = date_reception;
	}
	public String getAdresse_reception() {
		return adresse_reception;
	}
	public void setAdresse_reception(String adresse_reception) {
		this.adresse_reception = adresse_reception;
	}
	public int getNum_cmd_achat() {
		return num_cmd_achat;
	}
	public void setNum_cmd_achat(int num_cmd_achat) {
		this.num_cmd_achat = num_cmd_achat;
	}
	public Vector<Ligne_BR> getLigne_br() {
		return ligne_br;
	}
	public void setLigne_br(Vector<Ligne_BR> ligne_br) {
		this.ligne_br = ligne_br;
	}
	public float getM_total_TVA() {
		return m_total_TVA;
	}
	public void setM_total_TVA(float m_total_TVA) {
		this.m_total_TVA = m_total_TVA;
	}
	public float getM_total_hors_TVA() {
		return m_total_hors_TVA;
	}
	public void setM_total_hors_TVA(float m_total_hors_TVA) {
		this.m_total_hors_TVA = m_total_hors_TVA;
	}
	public float getM_total_Payer() {
		return m_total_Payer;
	}
	public void setM_total_Payer(float m_total_Payer) {
		this.m_total_Payer = m_total_Payer;
	}
	@Override
	public String toString() {
		return "Bon_reception [code=" + code + ", Codefournisseur=" + Codefournisseur + ", date_bon=" + date_bon
				+ ", date_reception=" + date_reception + ", adresse_reception=" + adresse_reception + ", num_cmd_achat="
				+ num_cmd_achat + ", ligne_br=" + ligne_br + ", m_total_TVA=" + m_total_TVA + ", m_total_hors_TVA="
				+ m_total_hors_TVA + ", m_total_Payer=" + m_total_Payer + "]";
	}
	
}
