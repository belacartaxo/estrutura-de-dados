class Aluno {
    // Atributos da classe (variáveis para conter informação)
    public static int contador = 0; 
    /*
        static 
        variável comum a todas as instâncias de um Aluno

        Do mesmo modo que uma variável pode ser estática, também um 
        método o pode ser, e nesse caso só poderá chamar variáveis 
        estáticas, pois as outras variáveis estão associados a uma única 
        instância de um objecto.
     */
    String nome;
    int numero;

    //Construtor "padrão"
    Aluno() {
        nome   = "indefinido";
        numero = -1;
        contador++;
    }

    Aluno(String n, int mec) {
        nome = n;
        numero = mec;
        contador++;
    }

    /*
        No Java podem existir várias funções com o mesmo nome mas com 
        argumentos diferentes. Quando o código é executado é chamada a 
        função que corresponde aos argumentos utilizados
    */

    public String toString() { // substituição do método toString
        return "(" + nome + "," + numero + ")";
    }

    int ano() {
        return numero / 100000;
    }
}

    // Classe principal contendo o main para testar a classe Aluno
public class TestAluno {
    public static void main(String[] args) {
        System.out.println("contador = " + Aluno.contador);
        /*
            pode chamar a variável mesmo antes de criar um qualquer objecto 
            desse tipo (usando para isso NomeDaClasse.VariavelEstatica).
        */
        
        Aluno a = new Aluno();
        System.out.println("a.nome = " + a.nome);
        System.out.println("a.numero = " + a.numero);
        System.out.println("a = " + a);  //referencia do objeto
        Aluno b = new Aluno();
        Aluno c = b;
        /*
            não estamos a copiar todos os atributos da classe, 
            mas sim a colocar a referência a apontar para a mesma 
            instância do objecto.
        */
        b.nome = "modificado";
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        Aluno d = new Aluno();
        Aluno e = new Aluno("Manuel", 201506234);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        // Aluno f = new Aluno("Maria"); // -> Erro não é aplicavel

        Aluno g = new Aluno("Ana", 201408762);
        Aluno h = new Aluno("Bruno", 201508145);
        System.out.println(g.ano() + " " + h.ano());

        int n = 3;
        Aluno[] v = new Aluno[n];
        for (int i=0; i<n; i++)
        System.out.println("v[" + i + "] = " + v[i]);
        //v[0].nome = "Pedro"; // NullPointesException

        for (int i=0; i<n; i++) v[i] = new Aluno();
        v[0].nome = "Pedro";

        System.out.println("contador = " + Aluno.contador);
    }
}
    

