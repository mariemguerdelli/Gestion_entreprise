package Metier;

public class Ligne_BL {
	int ref;
	int codeClient;
	String designation;
	String unite_mesure;
	int qte_livree;
	float PU_hors_TVA;
	float TVA;
	float P_total_horsTVA;
		public Ligne_BL() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Ligne_BL(int ref, int codeClient, String designation, String unite_mesure, int qte_livree,
				float pU_hors_TVA, float tVA, float p_total_horsTVA) {
			super();
			this.ref = ref;
			this.codeClient = codeClient;
			this.designation = designation;
			this.unite_mesure = unite_mesure;
			this.qte_livree = qte_livree;
			PU_hors_TVA = pU_hors_TVA;
			TVA = tVA;
			P_total_horsTVA = p_total_horsTVA;
		}
		public int getRef() {
			return ref;
		}
		public void setRef(int ref) {
			this.ref = ref;
		}
		public int getCodeClient() {
			return codeClient;
		}
		public void setCodeClient(int codeClient) {
			this.codeClient = codeClient;
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
		public int getQte_livree() {
			return qte_livree;
		}
		public void setQte_livree(int qte_livree) {
			this.qte_livree = qte_livree;
		}
		public float getPU_hors_TVA() {
			return PU_hors_TVA;
		}
		public void setPU_hors_TVA(float pU_hors_TVA) {
			PU_hors_TVA = pU_hors_TVA;
		}
		public float getTVA() {
			return TVA;
		}
		public void setTVA(float tVA) {
			TVA = tVA;
		}
		public float getP_total_horsTVA() {
			return P_total_horsTVA;
		}
		public void setP_total_horsTVA(float p_total_horsTVA) {
			P_total_horsTVA = p_total_horsTVA;
		}
		@Override
		public String toString() {
			return "Ligne_BL [ref=" + ref + ", codeClient=" + codeClient + ", designation=" + designation
					+ ", unite_mesure=" + unite_mesure + ", qte_livree=" + qte_livree + ", PU_hors_TVA=" + PU_hors_TVA
					+ ", TVA=" + TVA + ", P_total_horsTVA=" + P_total_horsTVA + "]";
		}
		
		
		
	}


