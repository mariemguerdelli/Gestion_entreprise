package Metier;

import java.util.Vector;

public class Devis {
int code;
String date;
int client;
Vector<Ligne_devis>liste_produits_demandees;
float m_total_TVA;
float m_total_hors_TVA;
float m_total_Payer;


public Devis() {
	super();
	// TODO Auto-generated constructor stub
}


public Devis(int code, String date, int client, Vector<Ligne_devis> liste_produits_demandees, float m_total_TVA,
		float m_total_hors_TVA, float m_total_Payer) {
	super();
	this.code = code;
	this.date = date;
	this.client = client;
	this.liste_produits_demandees = liste_produits_demandees;
	this.m_total_TVA = m_total_TVA;
	this.m_total_hors_TVA = m_total_hors_TVA;
	this.m_total_Payer = m_total_Payer;
}

public Devis(int code, String date, int client, float m_total_TVA,float m_total_hors_TVA, float m_total_Payer) {
	super();
	this.code = code;
	this.date = date;
	this.client = client;
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


public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}


public int getClient() {
	return client;
}


public void setClient(int client) {
	this.client = client;
}


public Vector<Ligne_devis> getListe_produits_demandees() {
	return liste_produits_demandees;
}


public void setListe_produits_demandees(Vector<Ligne_devis> liste_produits_demandees) {
	this.liste_produits_demandees = liste_produits_demandees;
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






}
