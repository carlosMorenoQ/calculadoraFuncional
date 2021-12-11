package calculadora;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> sumar= Integer::sum;

        BiFunction<Integer,Integer,Integer> restar=(a, b)->a-b;

        BiFunction<Integer, Integer, Integer> multiplicar = (a,b) ->
                IntStream.range(0,b+1)
                        .reduce((acomulador,numero)-> sumar.apply(acomulador,a))
                        .getAsInt();

        BiFunction<Integer,Integer,Integer> dividir = (numerador,denominador) ->{
            return IntStream.range(0, numerador+1)
                    .reduce((acumulador, numero) -> {
                        if (multiplicar.apply(numero,denominador)<=numerador) {
                            return acumulador = acumulador+1;
                        }
                        return acumulador;
                    }).getAsInt();
        };

        System.out.println(sumar.apply(10,20));
        System.out.println(restar.apply(30,50));
        System.out.println(multiplicar.apply(8,9));//20
        System.out.println(dividir.apply(30,10));//2

    }
}
