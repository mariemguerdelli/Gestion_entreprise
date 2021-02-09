package Metier;


public class Facture_fournisseur {
int code;
int fournisseur;
String date_facture;
String mode_payement;
String type_facture;
public Facture_fournisseur() {
	super();
	// TODO Auto-generated constructor stub
}
public Facture_fournisseur(int code, int fournisseur, String date_facture, String mode_payement, String type_facture) {
	super();
	this.code = code;
	this.fournisseur = fournisseur;
	this.date_facture = date_facture;
	this.mode_payement = mode_payement;
	this.type_facture = type_facture;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public int getFournisseur() {
	return fournisseur;
}
public void setFournisseur(int fournisseur) {
	this.fournisseur = fournisseur;
}
public String getDate_facture() {
	return date_facture;
}
public void setDate_facture(String date_facture) {
	this.date_facture = date_facture;
}
public String getMode_payement() {
	return mode_payement;
}
public void setMode_payement(String mode_payement) {
	this.mode_payement = mode_payement;
}
public String getType_facture() {
	return type_facture;
}
public void setType_facture(String type_facture) {
	this.type_facture = type_facture;
}
@Override
public String toString() {
	return "Facture_fournisseur [code=" + code + ", fournisseur=" + fournisseur + ", date_facture=" + date_facture
			+ ", mode_payement=" + mode_payement + ", type_facture=" + type_facture + "]";
}


}
