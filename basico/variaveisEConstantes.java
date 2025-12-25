package cursoJava.basico;

public class variaveisEConstantes {

	public static void main(String[] args) {
		
		final double ACELERACAO_GRAVIDADE_TERRA=9.80665;
		
		String nome="Marcelo";
		
		int idade=20;
		
		double peso=90,altura=1.80;
		
		char sexo='M',cnh='N';
		
		boolean doadorOrgaos=false;
		
		System.out.println("Nome: "+nome);
		System.out.println("Idade: "+idade);
		System.out.println("Peso: "+peso);
		System.out.println("Altura: "+altura);
		System.out.println("Sexo: "+sexo);
		System.out.println("Habilitação: "+cnh);
		System.out.println("Doador de orgãos: "+doadorOrgaos);
		System.out.println("Gravidade da terra: "+ACELERACAO_GRAVIDADE_TERRA+" m/s2");

	}

}
