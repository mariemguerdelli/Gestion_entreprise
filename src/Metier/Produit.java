package Metier;

public class Produit {
	int code;
	int ref;
	String designation;
	String unite_mesure;
	String fournisseur;
	String famille_produit;
	int stock;
	int stock_min;
	int PU_hors_taxe;
	int TVA;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(int code, int ref, String designation, String unite_mesure, String fournisseur, String famille_produit,
			int stock, int stock_min, int pU_hors_taxe, int tVA) {
		super();
		this.code = code;
		this.ref = ref;
		this.designation = designation;
		this.unite_mesure = unite_mesure;
		this.fournisseur = fournisseur;
		this.famille_produit = famille_produit;
		this.stock = stock;
		this.stock_min = stock_min;
		PU_hors_taxe = pU_hors_taxe;
		TVA = tVA;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
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
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getFamille_produit() {
		return famille_produit;
	}
	public void setFamille_produit(String famille_produit) {
		this.famille_produit = famille_produit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStock_min() {
		return stock_min;
	}
	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}
	public int getPU_hors_taxe() {
		return PU_hors_taxe;
	}
	public void setPU_hors_taxe(int pU_hors_taxe) {
		PU_hors_taxe = pU_hors_taxe;
	}
	public int getTVA() {
		return TVA;
	}
	public void setTVA(int tVA) {
		TVA = tVA;
	}
	@Override
	public String toString() {
		return "Produit [code=" + code + ", ref=" + ref + ", designation=" + designation + ", unite_mesure=" + unite_mesure
				+ ", fournisseur=" + fournisseur + ", famille_produit=" + famille_produit + ", stock=" + stock
				+ ", stock_min=" + stock_min + ", PU_hors_taxe=" + PU_hors_taxe + ", TVA=" + TVA + "]";
	}
	
	

}
