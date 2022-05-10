package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc", "Erik"}
        };
        elemanlariListYap(arr);
        System.out.println();
        eileBAslayanlarim(arr);
        System.out.println();
        eIleBasYasdir(arr);
        System.out.println();
        kIleBitenlerin(arr);
    }
    // S1 : tum elemanlari list yapayim
    public static void elemanlariListYap(String arr[][]) {
        System.out.println(Arrays.
                stream(arr).
                //flatMap(t -> Arrays.stream(t)).
                        flatMap(Arrays::stream).
                collect(Collectors.toList()));
    }
    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void eileBAslayanlarim(String arr[][]) {
        System.out.println(Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .filter(t -> t.toLowerCase()
                        .startsWith("e"))
                .map(t -> t + t)
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .filter(t -> t.startsWith("E"))
                .map(t -> t + t)
                .collect(Collectors.toList()));
    }
    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static void eIleBasYasdir(String arr[][]) {
        System.out.println(Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .filter(t -> t.toLowerCase().startsWith("e"))
                .collect(Collectors.toList()));
    }
    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void kIleBitenlerin(String arr[][]){
        System.out.println(Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .filter(t -> t.endsWith("k"))
                .map(t -> t + "*")
                .collect(Collectors.toList()));
    }
}