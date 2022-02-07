package TestAplicaciones;

public class Prueba_Tester {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("TestOrt");
        Tester tester = new Tester();

        empresa.realizarTest(tester);

        empresa.mostrarLog(tester);
    }
}
