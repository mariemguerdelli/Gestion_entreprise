package Metier;

import java.util.Vector;

public class Bon_livraison {
	int code;
	int Codeclient;
	String date_bon;
	String date_livraison;
	String adresse_livraison;
	int num_cmd_vente;
	Vector<Ligne_BL>ligne_bl;
	float m_total_TVA;
	float m_total_hors_TVA;
	float m_total_Payer;
  
	public Bon_livraison() {
	super();
	// TODO Auto-generated constructor stub
    }

	public Bon_livraison(int code, int codeclient, String date_bon, String date_livraison, String adresse_livraison,
		int num_cmd_vente, Vector<Ligne_BL> ligne_bl, float m_total_TVA, float m_total_hors_TVA, float m_total_Payer) {
	super();
	this.code = code;
	Codeclient = codeclient;
	this.date_bon = date_bon;
	this.date_livraison = date_livraison;
	this.adresse_livraison = adresse_livraison;
	this.num_cmd_vente = num_cmd_vente;
	this.ligne_bl = ligne_bl;
	this.m_total_TVA = m_total_TVA;
	this.m_total_hors_TVA = m_total_hors_TVA;
	this.m_total_Payer = m_total_Payer;
    }
	
	public Bon_livraison(int codeclient, String date_bon, String date_livraison, String adresse_livraison,
			int num_cmd_vente, Vector<Ligne_BL> ligne_bl, float m_total_TVA, float m_total_hors_TVA, float m_total_Payer) {
		super();
		
		Codeclient = codeclient;
		this.date_bon = date_bon;
		this.date_livraison = date_livraison;
		this.adresse_livraison = adresse_livraison;
		this.num_cmd_vente = num_cmd_vente;
		this.ligne_bl = ligne_bl;
		this.m_total_TVA = m_total_TVA;
		this.m_total_hors_TVA = m_total_hors_TVA;
		this.m_total_Payer = m_total_Payer;
	    }
	public Bon_livraison(int code, int codeclient, String date_bon, String date_livraison,
			String adresse_livraison, int num_cmd_vente,float m_total_TVA,
			float m_total_hors_TVA, float m_total_Payer) {
		super();
		this.code = code;
		Codeclient = codeclient;
		this.date_bon = date_bon;
		this.date_livraison = date_livraison;
		this.adresse_livraison = adresse_livraison;
		this.num_cmd_vente = num_cmd_vente;
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

	public int getCodeclient() {
		return Codeclient;
	}

	public void setCodeclient(int codeclient) {
		Codeclient = codeclient;
	}

	public String getDate_bon() {
		return date_bon;
	}

	public void setDate_bon(String date_bon) {
		this.date_bon = date_bon;
	}

	public String getDate_livraison() {
		return date_livraison;
	}

	public void setDate_livraison(String date_livraison) {
		this.date_livraison = date_livraison;
	}

	public String getAdresse_livraison() {
		return adresse_livraison;
	}

	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}

	public int getNum_cmd_vente() {
		return num_cmd_vente;
	}

	public void setNum_cmd_vente(int num_cmd_vente) {
		this.num_cmd_vente = num_cmd_vente;
	}

	public Vector<Ligne_BL> getLigne_bl() {
		return ligne_bl;
	}

	public void setLigne_bl(Vector<Ligne_BL> ligne_bl) {
		this.ligne_bl = ligne_bl;
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
		return "Bon_livraison [code=" + code + ", Codeclient=" + Codeclient + ", date_bon=" + date_bon
				+ ", date_livraison=" + date_livraison + ", adresse_livraison=" + adresse_livraison + ", num_cmd_vente="
				+ num_cmd_vente + ", ligne_bl=" + ligne_bl + ", m_total_TVA=" + m_total_TVA + ", m_total_hors_TVA="
				+ m_total_hors_TVA + ", m_total_Payer=" + m_total_Payer + "]";
	}
	
	



}
