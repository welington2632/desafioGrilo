/*
T = F * 2. Se, por exemplo, for aplicada uma força igual a 5, o prato girará por 10 segundos antes de parar. 

Quando ele gira um prato que ainda não parou de girar, o tempo durante o qual o prato 
irá continuar girando é igual ao tempo que ainda restava de giro somado ao tempo calculado pela fórmula já citada.

Para aplicar uma força F em um prato qualquer, ele gasta um tempo (TG) em segundos igual a TG = F * 2.
 */

 /*
Primeira linha
V(1<=V<=50) : Número de varetas
TM(1<=TM<=10) : Tempo de demora para alterar de uma vareta a outra

Segunda linha
I(1<=I<=V): Vareta inicial

Terceira linha
N(1<=N<=100) quantidade de movimentos que ele pretende fazer

Próximas N linhas
VV(1<=VV<=V) : A vareta para qual ele vai se mover
F(1<=F<=10) : Força que aplicará na vareta ao chegar nela
 */
package desafio;

import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite quantas varetas serão utilizadas");
        int v = scan.nextInt();
        System.out.println("Digite qual é o tempo para alterar de uma vareta a outra");
        int tm = scan.nextInt();
        System.out.println("Qual vareta você irá rodar? [1-" + v + "]");
        int i = scan.nextInt();
        System.out.println("Digite qual será a força aplicada");
            int f = scan.nextInt();
        System.out.println("Quantidade de movimentos");
        int n = scan.nextInt();
        int pratoQuebrado = -1;
        int segundos = 0;
        int[] varetaTempo = new int[v+1];
        for (int round = 0; round < n; round++) {
            
            // Inicio
            if (round == 0) {
                segundos += f * 2;
                varetaTempo[i] = f * 2;
                System.out.println("Você rodou o prato " + i + " ele rodará por " + varetaTempo[i] + " segundos até cair!");
                // Processo em andamento
            } else {
                System.out.println("Qual vareta você irá rodar? [1-" + v + "]");
                int vv = scan.nextInt();
                System.out.println("Digite qual será a força aplicada");
                f = scan.nextInt();
                int TG = f * 2;
                //Tempo de tm
                segundos += tm;
                for (int j = 1; j < varetaTempo.length; j++) {
                    if (varetaTempo[j] > 0) {
                        varetaTempo[j] -= tm;
                        System.out.println("O prato " + j + " está rodando e cairá em " + varetaTempo[j] + " segundos [TM]");
                        if (varetaTempo[j] <= 0) {
                            pratoQuebrado = j;
                            break;
                        }
                    }
                }
                if (pratoQuebrado == -1) {
                    //Tempo de TG
                    segundos += TG;
                    for (int k = 1; k < varetaTempo.length; k++) {
                        if (varetaTempo[k] > 0) {
                            varetaTempo[k] -= TG;
                            System.out.println("O prato " + k + " está rodando e cairá em " + varetaTempo[k] + " segundos [TG]");
                            if (varetaTempo[k] <= 0) {
                                pratoQuebrado = k;
                            }
                            if (pratoQuebrado != -1) {
                                break;
                            }
                        }
                    }
                }
                if (pratoQuebrado != -1) {
                    System.out.println("" + segundos + " " + pratoQuebrado);
                    break;
                } else {
                    varetaTempo[vv] += f * 2;
                    System.out.println("OK");
                }
            }
            if (round == n - 1) {
                System.out.println("Você fez todos os movimentos, fim.");
            }
        }

    }

}
