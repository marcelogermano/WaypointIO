package cursoJava.basico;

public class operadoresLogicos {

	public static void main(String[] args) {
		System.out.println("Falso e Falso e: "+(false&&false));
		System.out.println("Falso e Verdadeiro e: "+(false&&true));
		System.out.println("Verdadeiro e Falso e: "+(true&&false));
		System.out.println("Verdadeiro e Verdadeiro e: "+(true&&true));
		
		System.out.println("Falso OU Falso e: "+(false||false));
		System.out.println("Falso OU Verdadeiro e: "+(false||true));
		System.out.println("Verdadeiro OU Falso e: "+(true||false));
		System.out.println("Verdadeiro OU Verdadeiro e: "+(true||true));


	}

}
