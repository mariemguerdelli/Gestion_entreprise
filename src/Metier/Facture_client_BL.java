package Metier;

public class Facture_client_BL extends Facture_client{
	int code_bonlivr;
	float m_total_Payer;
	
	

	public Facture_client_BL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture_client_BL(int code,int fournisseur,String date_facture,String mode_payement,
	String type_facture,int code_bonlivr,float m_total_Payer) {
		super(code,fournisseur,date_facture,mode_payement,type_facture);
		this.code_bonlivr = code_bonlivr;
		this.m_total_Payer = m_total_Payer;
		
	}

	public int getCode_bonlivr() {
		return code_bonlivr;
	}

	public void setCode_bonlivr(int code_bonlivr) {
		this.code_bonlivr = code_bonlivr;
	}

	public float getM_total_Payer() {
		return m_total_Payer;
	}

	public void setM_total_Payer(float m_total_Payer) {
		this.m_total_Payer = m_total_Payer;
	}


	
	

}
