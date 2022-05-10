package lambda_practice;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");
        dveClistele(list);
        System.out.println();
        basSonYildizli(list);
        System.out.println();
        alfabetikSirala(list);
        System.out.println();
        lSil(list);
        System.out.println();
        eIcerenleriListele(list);
        System.out.println();
        ilkHarfi3tekrar(list);
        System.out.println();
        ilkHarfBuyuk(list);
        System.out.println();
        uzunlugu4ve6Haric(list);
    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static void dveClistele(List<String> list) {
        list.stream()
                .filter(t -> t.startsWith("d") || t.startsWith("c"))
                .collect(Collectors.toList())
                .forEach(C2_StringList_StreamOrnekleri::yazdir);
    }
    public static void yazdir(String a) {
        System.out.print(a + " ");
    }
    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basSonYildizli(List<String> list) {
        list.stream()
                .map(t -> "*" + t + "*")
                .forEach(C2_StringList_StreamOrnekleri::yazdir);
    }
    //S3: alfabedik  olarak siralayalim list olarak
    public static void alfabetikSirala(List<String> list){
        System.out.println(list.
                stream().
                sorted().
                collect(Collectors.toList()));
    }
    //S4: tum 'l' leri silelim yazdiralim
    public static void lSil(List<String> list){
        System.out.println(list.
                stream().
                map(t -> t.replaceAll("l", "")).
                collect(Collectors.toList()));
    }
    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static void eIcerenleriListele(List<String> list){
        System.out.println(list.stream()
                .filter(t -> t.contains("e"))
                .collect(Collectors.toList()));
    }
    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
    public static void ilkHarfi3tekrar(List<String> list){
        list.
                stream()
                .map(t -> t.substring(0, 1).toUpperCase()
                        +t.substring(0, 1).toLowerCase()
                        + t.toLowerCase())
                .forEach(t-> System.out.print(t+" "));
    }
    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
    public static void ilkHarfBuyuk(List<String> list){
        list.
                stream().
                map(t->t.substring(0,1).toUpperCase()
                        +t.substring(1).toLowerCase()).
                forEach(C2_StringList_StreamOrnekleri::yazdir);
    }
    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
    public static void uzunlugu4ve6Haric(List<String> list){
        System.out.println(list.
                stream().
                filter(t -> t.length() != 4 && t.length() != 6).
                collect(Collectors.toList()));
    }
}