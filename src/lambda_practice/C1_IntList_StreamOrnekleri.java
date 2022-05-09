package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));

        System.out.println(list);
        System.out.println();
        bosluk(list);
        System.out.println();
        negatif(list);
        System.out.println();
        pozitif(list);
        System.out.println();
        kareleri(list);
        System.out.println();
        tekrarsiz(list);
        System.out.println();
        kucukbuyuk(list);
        System.out.println();
        buyukkucuk(list);
        System.out.println();
        kupler(list);
        System.out.println();
        kareleri1( list);
        System.out.println();
        eletoplam(list);
        System.out.println();
        peeknegatif(list);
        System.out.println();
        varmi(list);
        System.out.println();
        kucukmu( list);
        System.out.println();
        esitmu(list);
        System.out.println();
        sifiraesit(list);
        System.out.println();
        topla( list);
        System.out.println();
        son(list);
        System.out.println();
        System.out.println(list);


    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void bosluk(List<Integer> list){
        list.stream().forEach(t-> System.out.print(t+" "));
    }
    public static void yazdir(int t){ System.out.print(t+" "); }

    //S2: sadece negatif olanlari yazdir

    public static void negatif(List<Integer> list){
        list.stream().filter(t->t<0).forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S3: pozitif olanlardan yeni bir liste olustur

    public static void pozitif(List<Integer> list){
        list.stream().
                filter(t->t>0).
                collect(Collectors.toList()).
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }
    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static void kareleri(List<Integer> list){
        list.stream().map(t->t*t).forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static void tekrarsiz(List<Integer> list){
        list.stream().map(t->t*t).distinct().forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void kucukbuyuk(List<Integer> list){
        list.stream().sorted().forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void buyukkucuk(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static void kupler(List<Integer> list){
        list.stream().map(t->t*t*t).
                filter(t->t%10==5).
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static void kareleri1(List<Integer> list){
        list.stream().
                filter(t->t>0).
                map(t->t*t).
                filter(t->t%10!=5).
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    // S10 :list elemanlarini toplamini bulalim
    public static void eletoplam(List<Integer> list){
        System.out.print(list.stream().reduce(0, (t, u) -> t + u));
    }
/*
    peek () 'in Javadoc sayfası şöyle diyor: " Bu yöntem, temelde, öğeleri bir
    ardışık düzen içinde belirli bir noktadan geçerken görmek istediğiniz
    yerde hata ayıklamayı desteklemek için vardır .

 */

    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static void peeknegatif(List<Integer> list){
        list.stream()
                .filter(t->t<0)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(t->t*t)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
    // S12 : listeden 5 den buyuk  sayi var mi?
    public static void varmi(List<Integer> list){
        System.out.println(list.stream().anyMatch(t -> t > 5));
    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static void kucukmu(List<Integer> list){
        System.out.println(list.stream().allMatch(t -> t < 0));
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static void esitmu(List<Integer> list){
        System.out.println(list.stream().noneMatch(t -> t == 100));
    }

    // S15: listenin sifira esit elemani yok mu?
    public static void sifiraesit(List<Integer> list){
        System.out.println(list.stream().noneMatch(t -> t == 0));
    }

    // S16:  listenin ilk 5 elemanini topla?
    public static void topla(List<Integer> list){
        System.out.println(list.stream().limit(5).reduce(Integer::sum).orElseThrow());
    }
    //S17: listenin son bes elemaninin  listele
    public static void son(List<Integer> list){
        list.stream().skip(list.size() - 5).forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

}