package lambda_practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class C3_Array_StreamOrnekleri {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
        // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
        // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1 [] ={1,5,-5,6,12,-8,9,3,4};
        elemanlariListeYAzdir(arr1);
        System.out.println();
        elemenlarToplami(arr1);
        System.out.println();
        ortalama(arr1);
    }
    //S1: arrayin elemanlarini bir liste yazdiralim
    public static void elemanlariListeYAzdir(Integer[] arr1) {
        System.out.println(Arrays.stream(arr1)
                .collect(Collectors.toList()));
    }
    //S2: Arrayin elemanlarini toplamini bulalim
    public static void elemenlarToplami(Integer[] arr1){
        System.out.println(Arrays.stream(arr1)
                .reduce(0,(t,u)->t+u));
    }
    // S3: Array in elemanlarinin ortalamasini bulalim yazdir
    public static void ortalama(Integer[] arr1){
        // Arrays.stream(arr1).average().ifPresent(t-> System.out.print(t+" ")));
        System.out.println(Arrays.
                stream(arr1).
                mapToInt(t -> t).
                average().
                orElseThrow());
    }
}