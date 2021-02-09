package Metier;

public class Facture_avoir {
	int code;
	int code_client;
	String date_facture;
	String mode_payement;
	int code_facture_client;
	int qteRetour;
	String desigProd;
	float MTPayer;
	float MRetour;
	float MAR;
	public Facture_avoir() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture_avoir(int code, int code_client, String date_facture, String mode_payement, int code_facture_client,
			int qteRetour, String desigProd, float mTPayer, float mRetour, float mAR) {
		super();
		this.code = code;
		this.code_client = code_client;
		this.date_facture = date_facture;
		this.mode_payement = mode_payement;
		this.code_facture_client = code_facture_client;
		this.qteRetour = qteRetour;
		this.desigProd = desigProd;
		MTPayer = mTPayer;
		MRetour = mRetour;
		MAR = mAR;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCode_client() {
		return code_client;
	}
	public void setCode_client(int code_client) {
		this.code_client = code_client;
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
	public int getCode_facture_client() {
		return code_facture_client;
	}
	public void setCode_facture_client(int code_facture_client) {
		this.code_facture_client = code_facture_client;
	}
	public int getQteRetour() {
		return qteRetour;
	}
	public void setQteRetour(int qteRetour) {
		this.qteRetour = qteRetour;
	}
	public String getDesigProd() {
		return desigProd;
	}
	public void setDesigProd(String desigProd) {
		this.desigProd = desigProd;
	}
	public float getMTPayer() {
		return MTPayer;
	}
	public void setMTPayer(float mTPayer) {
		MTPayer = mTPayer;
	}
	public float getMRetour() {
		return MRetour;
	}
	public void setMRetour(float mRetour) {
		MRetour = mRetour;
	}
	public float getMAR() {
		return MAR;
	}
	public void setMAR(float mAR) {
		MAR = mAR;
	}
	
	
	 
	
}
