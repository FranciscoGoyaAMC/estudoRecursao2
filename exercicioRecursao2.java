
import java.util.Arrays;

class MatrixNotPossibleException extends RuntimeException
    {
        public MatrixNotPossibleException(String message)
        {
            super(message);
        }
    }


public class exercicioRecursao2
{
    /*
    Exercício 1. Crie um método recursivo que imprime um array recebido por parâmetro de trás
    para frente
    */
    public static void exercicio1(int[] array)
    {
        exercicio1Recursivo(array, array.length-1);
    }
    private static void exercicio1Recursivo(int[] array, int index)
    {
        if (index < 0)
        {
            return;
        }
        System.out.print(array[index] + " ");
        exercicio1Recursivo(array, index-1);
    }


    /*
    Exercício 2. Crie um método recursivo que recebe um array bidimensional de double e
    retorna a soma dos elementos deste array
    */
    public static double exercicio2(double[][] array)
    {
        if (array == null)
        {
            throw new IllegalArgumentException("O array não pode ser nulo");
        }
        return exercicio2Recursivo(array, 0, 0);
    }
    private static double exercicio2Recursivo(double[][] array, int linha, int coluna)
    {
        if (linha >= array.length)
        {
            return 0;
        }
        if (coluna >= array[linha].length)
        {
            return exercicio2Recursivo(array, linha + 1, 0);
        }
        return array[linha][coluna] + exercicio2Recursivo(array, linha, coluna + 1);
    }
    

    /*
    Exercício 3. Crie um método chamado encontraPosicaoMenorValor. Este método deve
    encontrar a posição do menor valor de um array de inteiros V (recebido por
    parâmetro). Por exemplo, digamos que o array abaixo seja passado por
    parâmetro:
    {23, 35, 16, 8, 13, 11, 10, 20, 9, 12}
    O método, neste caso, retornaria o valor 3
    */
    public static int encontraPosicaoMenorValor(int[] array)
    {
        if (array == null || array.length == 0) 
        {
            throw new IllegalArgumentException("O array não pode ser nulo ou vazio");
        }
        return exercicio3Recursivo(array, array.length-1);
    }
    private static int exercicio3Recursivo(int[] array, int index)
    {
        if (index == 0)
        {
            return 0;
        }
        int menorIndice = exercicio3Recursivo(array, index - 1);
        return (array[index] < array[menorIndice]) ? index : menorIndice;
    }


    /*
    Exercício 4. • Crie um método recursivo chamado printPrimaryDiagonal, que imprime a
    diagonal primária de uma matriz qualquer. No método público, apenas a matriz
    deve ser passada por parâmetro.
    Não esqueça de que uma matriz só possui diagonal secundária caso ela seja uma
    matriz quadrada.
    Caso contrário, seu método deve lançar uma exceção do tipo
    MatrixNotPossibleException, que deve ser criada por você.
    */
    public static void printPrimaryDiagonal(int[][] matriz)
    {
        if (matriz == null || matriz.length == 0 || matriz.length != matriz[0].length)
        {
            throw new MatrixNotPossibleException("A matriz não é quadrada, portanto não há diagonal primária");
        }
        exercicio4(matriz, 0);
    }
    private static void exercicio4(int[][] matriz, int index)
    {
        if (index >= matriz.length)
        {
            return;
        }
        System.out.println(matriz[index][index]);
        exercicio4(matriz, index + 1);
    }


    /*
    Exercício 5. Crie um método recursivo chamado binaryToDecimal, que recebe uma String
    que contém um número em base 2 e retorna um número em base 10. Para isto,
    você deve utilizar o método de conversão abaixo:
    1    |  1   |  0   |  1  |   0  |    0    |  0    |  1   |
    -----------------------------------------------------------
    2**7 |2**6  |2**5  |2**4 |  2**3| 2**2    |   2**1| 2**0 |

    O valor de entrada deve ter exatamente 8 dígitos, caso contrário a conversão
    não poderá ser realizada. Para converter o número de binário para decimal,
    basta somar as potências de 2 das posições que estão em 1. No exemplo acima,
    teríamos: 2**7 + 2**6 + 2**4 + 2**0 = 209. 
    */
    public static int binaryToDecimal(String binary)
    {
        if (binary == null || binary.length() != 8 || !binary.matches("[01]+"))
        {
            throw new IllegalArgumentException("A entrada deve ter exatamente 8 dígitos binários (0s e 1s).");
        }
        return exercicio5(binary, 0);
    }
    private static int exercicio5(String binary, int index)
    {
        if (index == binary.length())
        {
            return 0;
        }
        int bit = binary.charAt(index) - '0';
        int power = binary.length() - 1 - index;
        return (bit * (int) Math.pow(2, power)) + exercicio5(binary, index + 1);
    }

    /*
    Exercício 6. Crie um método recursivo que recebe um array de inteiros e um
    inteiro N e retorna verdadeiro caso o inteiro N esteja presente no array, ou
    falso caso contrário.
    */
    public static boolean exercicio6(int[] array, int n)
    {
        if (array == null || array.length == 0)
        {
            throw new IllegalArgumentException("O array não pode ser nulo nem vazio");
        }
        return exercicio6Recursivo(array, n, 0);
    }
    private static boolean exercicio6Recursivo(int[] array, int n, int c)
    {
        if (c >= array.length)
        {
            return false;
        }
        if (array[c] == n)
        {
            return true;
        }
        return exercicio6Recursivo(array, n, c + 1);
    }


    /*
    Exercício 7. Crie um método recursivo que recebe um inteiro N por
    parâmetro e retorna verdadeiro caso ele seja um número primo e falso caso
    contrário.
    */
    public static boolean exercicio7(int n)
    {
        if (n <= 1)
        {
        return false;
        }
        return exercicio7Recursivo(n, n - 1);
    }
    private static boolean exercicio7Recursivo(int n, int div)
    {
        if (div == 1)
        {
            return true;
        }
        if (n % div== 0)
        {
            return false;
        }
        return exercicio7Recursivo(n, div-1);
    }


    /*
    Exercício 8. Crie um método recursivo que recebe uma String e retorna uma
    nova String, que é a String de entrada invertida.
    */
    public static String exercicio8(String str)
    {
        if (str == null)
        {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }
        if (str.isEmpty())
        {
            return str;
        }
        return exercicio8(str.substring(1)) + str.charAt(0);
    }


    /*
    Exercício 9. Crie um método recursivo que recebe um inteiro positivo (e
    maior que 0) N e calcula o seguinte: 1 + 1/2 + 1/3 + 1/4 + 1/5 + ... + 1/N. 
    */
    public static double exercicio9(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("O número deve ser positivo e maior que 0");
        }
        return exercicio9Recursivo(n,1);
    }
    private static double exercicio9Recursivo(int n, int div)
    {
        if (div == n)
        {
            return 1.0/n;
        }
        return 1.0/div + exercicio9Recursivo(n, div+1);
    }


    /*
    Exercício 10. Crie um método recursivo que retorna verdadeiro caso uma
    String recebida por parâmetro seja um palíndromo e falso caso contrário.
    Um palíndromo é um texto que, desconsiderando espaços, pontuação e
    acentuação, pode ser lido da mesma forma tanto de frente pra trás quanto
    de trás para frente.
    No seu método público, antes de chamar o método privado, você deve
    remover pontuações (exclamações, pontos de interrogação, pontos finais e
    vírgulas) e espaços, para então chamar o método privado. Você pode assumir
    que o texto de entrada não possuirá acentos.
    */
    public static boolean exercicio10(String word)
    {
        if(word == null)
        {
        throw new IllegalArgumentException("A palavra não pode ser nula");
        }
        String textoLimpo = word.replaceAll("[\\s!?,.]", "").toLowerCase();

        return exercicio10Recursivo(textoLimpo.toCharArray(), 0, textoLimpo.length() - 1);
    }    
    private static boolean exercicio10Recursivo(char[] word, int i, int j)
    {
        if (i >= j)
        {
            return true;
        }     
        if (word[i] != word[j])
        {
            return false;
        } 
        return exercicio10Recursivo(word, i + 1, j - 1);
    }


    /*
    Exercício 11. Crie um método recursivo que recebe um array de String e
    retorna a quantidade de posições que contém palíndromos neste array.
    Utilize o método desenvolvido no último exercício para auxiliar.
    */
    public static int exercicio11(String[] array)
    {
        if (array == null || array.length == 0)
        {
            throw new IllegalArgumentException("O array não pode ser nulo ou vazio");
        }
        return exercicio11Recursivo(array, 0);
    }
    private static int exercicio11Recursivo(String[] array, int index)
    {
        if (index == array.length)
        {
            return 0;
        }
        int count = exercicio10(array[index]) ? 1 : 0;

        return count + exercicio11Recursivo(array, index + 1);
    }
    


    /*
    Exercício 12.Crie um método recursivo que conta quantas vezes um
    determinado dígito positivo D aparece em um inteiro positivo N. Por
    exemplo, se N = 161451811 e D = 1, o retorno do método deve ser 5, pois o
    dígito 1 aparece 5 vezes em N. Você deve utilizar apenas operações
    matemáticas para isto, sem utilização de Strings.
    */
    public static int exercicio12(int N, int D)
    {
        if (N < 0 || D < 0 || D > 9)
        {
            throw new IllegalArgumentException("N e D devem ser positivos, e D deve estar entre 0 e 9.");
        }
        return exercicio12Recursivo(N, D);
    }
    private static int exercicio12Recursivo(int N, int D)
    {
        if (N == 0)
        {
            return 0; 
        }
        int count = (N % 10 == D) ? 1 : 0;

        return count + exercicio12Recursivo(N / 10, D);
    }


    /*
    Exercício 13.Crie um método recursivo que recebe um inteiro positivo (maior
    do que 0) e retorna a média dos seus dígitos. Por exemplo, para a entrada
    6845, o resultado do método deve ser 5.75. Você deve utilizar apenas
    operações matemáticas para isto, sem utilização de Strings.
    */
    public static double exercicio13(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("O número deve ser positivo e maior que 0.");
        }
        return exercicio13Recursivo(n, 0, 0);
    }
    private static double exercicio13Recursivo(int n, int soma, int cont)
    {
        if (n == 0)
        {
            if (cont == 0)
            {
                return 0;
            }
            return (double) soma / cont;
        }
        int ultimoDigito = n % 10;
        return exercicio13Recursivo(n / 10, soma + ultimoDigito, cont + 1);
    }


    /*
    Exercício 14. Crie um método recursivo que recebe um número inteiro (maior
    do que 0) e retorna verdadeiro caso o número seja um número perfeito e
    falso caso contrário. Um número perfeito é um número que a soma de todos
    os seus divisores naturais próprios (excluindo ele mesmo) é igual ao próprio
    número. Por exemplo, 6 é um número perfeito, pois 6 = 1+2+3. Outro
    número perfeito é o 28, pois 28 = 1+2+4+7+14. Atualmente, são poucos os
    números perfeitos conhecidos (cerca de 49). Para testar seu método, os
    números abaixo são os 10 menores números perfeitos:
    • 6
    • 28
    • 496
    • 8.128
    • 33.550.336
    • 8.589.869.056
    • 137.438.691.328
    • 2.305.843.008.139.952.128
    • 2.658.455.991.569.831.744.645.692.615.953.842.176
    • 191.561.942.608.236.107.294.793.378.084.303.638.130.997.321.54
    8.169.216
    Os 54 dígitos do último número listado não são nada perto do número
    perfeito encontrado em 2016, que possui mais de 44 milhões de dígitos.
    Naturalmente, você poderá testar apenas os 4 primeiros números perfeitos
    no seu método, devido ao alto poder de processamento necessário para a
    verificação dos demais.
    Você deve utilizar apenas operações matemáticas para isto, sem utilização
    de Strings.
    */
    public static boolean exercicio14(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("O número deve ser positivo e maior que 0.");
        }
        return exercicio14Recursivo(n, 1, 0);
    }
    private static boolean exercicio14Recursivo(int n, int div, int somaDiv)
    {
        if (div == n)
        {
            return somaDiv == n;
        }
        if (n % div == 0)
        {
            somaDiv += div;
        }
        return exercicio14Recursivo(n, div + 1, somaDiv);
    }


    public static void main(String[] args)
    {
        //Exercício 1:
        int[] array1 = {1,2,3,4,5};
        exercicio1(array1);
        System.out.println();
        System.out.println();


        //Exercício 2:
        double[][] array2 =
        {
            {1.1,2.2,3.3,4.4},
            {5.5,6.6,7.7,8.8},
        };
        double resp1 = exercicio2(array2);
        System.out.println("A soma dos valores do array é: " + resp1);
        System.out.println();


        //Exercício 3:
        int[] array3 = {4,5,6,1,2,3};
        int resp2 = encontraPosicaoMenorValor(array3);
        System.out.println("A menor posição do array é: " + resp2);
        System.out.println();


        //Exercício 4:
        int[][] matriz =
        {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        try
        {
            System.out.println("Diagonal Primária:");
            printPrimaryDiagonal(matriz);
        }
        catch (MatrixNotPossibleException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();


        //Exercício 5:
        System.out.println("Converter binário para decimal");
        try
        {
            System.out.println("Binário: 11010001");
            System.out.println("Decimal: " + binaryToDecimal("11010001")); //Saída esperada: 209
            System.out.println("Binário: 00000001");
            System.out.println("Decimal: " + binaryToDecimal("00000001")); //Saída esperada: 1
            System.out.println("Binário: 11111111");
            System.out.println("Decimal: " + binaryToDecimal("11111111")); //Saída esperada: 255
            System.out.println("Binário 00000000");
            System.out.println("Decimal: " + binaryToDecimal("00000000")); //Saída esperada: 0
        } 
        catch (IllegalArgumentException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();


        //Exercício 6:
        int[] array4 = {0,1,2,3,4,5};
        int n1 = 3;
        System.out.println("Array: " + Arrays.toString(array4) + " N: " + n1 + " " + exercicio6(array4, n1));
        int[] array5 = {6,7,8,9};
        int n2 = 5;
        System.out.println("Array: " + Arrays.toString(array5) + " N: " + n2 + " " + exercicio6(array5, n2));
        System.out.println();

        
        //Exercício 7:
        int n3 = 7;
        System.out.println(n3 + " É primo? " + exercicio7(n3));
        int n4 = 8;
        System.out.println(n4 + " É primo? " + exercicio7(n4));
        System.out.println(); 


        //Exercício 8:
        System.out.println("abcd > " + exercicio8("abcd"));
        System.out.println("hello > " + exercicio8("hello"));
        System.out.println("12345 > " + exercicio8("12345"));
        System.out.println();


        //Exercício 9:
        System.out.println(exercicio9(1));
        System.out.println(exercicio9(2));
        System.out.println(exercicio9(3));
        System.out.println(exercicio9(5));
        System.out.println(exercicio9(10));
        System.out.println();


        //Exercício 10:
        System.out.println("'Ana' é palíndromo? " +  exercicio10("Ana")); 
        System.out.println("'Renner' é palíndromo? " + exercicio10("Renner"));
        System.out.println("'O teu dueto' é palíndromo? " + exercicio10("O teu dueto")); 
        System.out.println("'Eva, asse essa ave' é palíndromo? " + exercicio10("Eva, asse essa ave"));
        System.out.println("'Seco de raiva, coloco no colo caviar e doces' é palíndromo? " + exercicio10("Seco de raiva, coloco no colo caviar e doces"));
        System.out.println("'Java' é palíndromo? " + exercicio10("Java"));
        System.out.println();


        //Exercício 11:
        String[] array6 = {"Ana", "Java", "Renner", "Ovo", "Casa", "O seu dueto", "Teste"};
        System.out.println(exercicio11(array6));
        System.out.println();


        //Exercício 12:
        int n5 = 161451811;
        int n6 = 1;
        System.out.println(exercicio12(n5, n6));
        System.out.println();


        //Exercício 13:
        int n7 = 6845;
        System.out.println(exercicio13(n7));
        System.out.println();


        //Exercício 14:
        System.out.println("6 é perfeito? " + exercicio14(6));
        System.out.println("28 é perfeito? " + exercicio14(28));
        System.out.println("496 é perfeito? " + exercicio14(496));
        System.out.println("8 é perfeito? " + exercicio14(8));
    }
}