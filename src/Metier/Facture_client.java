package Metier;



public class Facture_client {
int code;
int client;
String date_facture;
String mode_payement;
String type_facture;
public Facture_client() {
	super();
	// TODO Auto-generated constructor stub
}
public Facture_client(int code, int client, String date_facture, String mode_payement, String type_facture) {
	super();
	this.code = code;
	this.client = client;
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
public int getClient() {
	return client;
}
public void setClient(int client) {
	this.client = client;
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


}
