package Metier;


public class Facture_fournisseur_BL extends Facture_fournisseur{
	
	int code_bonrecep;
	float m_total_Payer;
	float m_Payer;
	float m_Reste;
	

	public Facture_fournisseur_BL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture_fournisseur_BL(int code,int fournisseur,String date_facture,String mode_payement,
	String type_facture,int code_bonrecep,float m_total_Payer,float m_Payer,float m_Reste) {
		super(code,fournisseur,date_facture,mode_payement,type_facture);
		this.code_bonrecep = code_bonrecep;
		this.m_total_Payer = m_total_Payer;
		this.m_Payer = m_Payer;
		this.m_Reste = m_Reste;
	}

	public int getCode_bonrecep() {
		return code_bonrecep;
	}

	public void setCode_bonrecep(int code_bonrecep) {
		this.code_bonrecep = code_bonrecep;
	}

	public float getM_total_Payer() {
		return m_total_Payer;
	}

	public void setM_total_Payer(float m_total_Payer) {
		this.m_total_Payer = m_total_Payer;
	}

	public float getM_Payer() {
		return m_Payer;
	}

	public void setM_Payer(float m_Payer) {
		this.m_Payer = m_Payer;
	}

	public float getM_Reste() {
		return m_Reste;
	}

	public void setM_Reste(float m_Reste) {
		this.m_Reste = m_Reste;
	}
	
	

	
	
	
	

	

}
