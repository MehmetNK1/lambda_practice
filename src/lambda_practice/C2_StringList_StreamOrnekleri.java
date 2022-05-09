package lambda_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

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

        dclistele(list);

    }
    public static void  yazdir(String a){
        System.out.println(a+" ");
    }

    public static void dclistele(List<String> list) {
        list.stream()
                .filter(t->t.startsWith("d")||t.startsWith("c"))
                .collect(Collectors.toList())
                .forEach(C2_StringList_StreamOrnekleri::yazdir);
    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim



    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim



    //S3: alfabedik  gore siralayalim list olarak


    //S4: tum 'l' leri silelim yazdiralim


    //S5 : icinde e olanlardan yeni bir list olusturunuz


    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi


    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz


    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz



}
