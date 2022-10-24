/* Given an N numbers of temperatures that will be converted, in each case, asks for the unit it will convert from and then the unit it will convert to */
/* In each case, returns the original temperature, the converted temperature, an average between the inputs and an average between the outputs */

import java.util.Scanner;

public class ctprojeto {
    public static void main(String[] args) {
        int i = 0;
        double temp2 = 0;
        double ent = 0;
        double sai = 0;
        int soma = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantas temperaturas você irá converter?");
        int n = scanner.nextInt();

        while(n < 0){
            System.out.println("Digite uma quantidade válida!");
            System.out.println("Quantas temperaturas você irá converter?");
            n = scanner.nextInt();
        }

        if(n == 0){
            System.out.println("Programa finalizado!");
        }

       else{
            while(i < n){
                System.out.printf("Digite a %d temperatura: \n", i+1);
                double temp1 = scanner.nextDouble();
                ent += temp1;
                soma += 1;
                System.out.println("Esta temperatura está em Celsius, Kelvin ou Fahrenheit? [Digite C, K ou F]");
                String und1 = scanner.next();
                boolean confirmador1 = und1.equals("C") || und1.equals("K") || und1.equals("F");
                while (!confirmador1){
                    System.out.println("Digite C para Celsius, K para Kelvin ou F para Fahrenheit!");
                    System.out.println("Esta temperatura está em Celsius, Kelvin ou Fahrenheit?");
                    und1 = scanner.next();
                    confirmador1 = und1.equals("C") || und1.equals("K") || und1.equals("F");
                }

                System.out.println("Para que unidade a temperatura deve ser convertida? [Digite C, K ou F]");
                String und2 = scanner.next();
                boolean confirmador2 = und2.equals("C") || und2.equals("K") || und2.equals("F");
                while(!confirmador2 || und2.equals(und1)){
                    System.out.println("Digite C para Celsius, K para Kelvin ou F para Fahrenheit!");
                    System.out.println("A temperatura deve ser convertida para Celsius, " +
                            "Kelvin ou Fahrenheit? (Não pode ser igual à primeira)");
                    und2 = scanner.next();
                    confirmador2 = und2.equals("C") || und2.equals("K") || und2.equals("F");
                }

                if (und1.equals("C")) {
                    if(und2.equals("F")){
                        temp2 = (temp1 * 9/5) + 32;
                    }
                    else{
                        temp2 = temp1 + 273.15;
                    }
                    sai += temp2;
                }

                else if (und1.equals("F")){
                    if(und2.equals("C")){
                        temp2 = (temp1 - 32) * 5/9;
                    }
                    else{
                        temp2 = ((temp1 - 32) * 5/9) + 273.15;
                    }
                    sai += temp2;
                }

                else {
                    if(und2.equals("C")){
                        temp2 = temp1 - 273.15;
                    }
                    else{
                        temp2 = ((temp1 - 273.15) * 9/5) + 32;
                    }
                    sai += temp2;
                }

                System.out.printf("%.2f%s é igual a %.2f%s.\n", temp1, und1, temp2, und2);

                i++;
            }
            double mediaent = ent/soma;
            double mediasai = sai/soma;

            System.out.printf("A média entre os %d valores de entrada é %.2f\n", soma, mediaent);
            System.out.printf("A média entre os valores de saída é %.2f", mediasai);
        }

    }
}
