package lambda_practice;

import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {

        siralama( 30);
        System.out.println();
        siralama1( 30);
        System.out.println();
        toplama1(3,5);
        System.out.println();
        ortalamasini(30,40);
        System.out.println();
        bolunen(325,468);
        System.out.println();
        yazdiralim(325,468);
        System.out.println();
        System.out.println(toplamini(325,468));
        System.out.println();
        System.out.println(carpim(8,15));
        System.out.println();
        elemanin(0,20);
        System.out.println();
        tekyazdir(21);
        System.out.println();
        System.out.println(toplayalim(21));





    }
    public static void yazdir(int x){
        System.out.print(x+" ");
    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void siralama(int x){
          IntStream.
                  range(1,x).
                  sorted().
                  forEach(C6_Lambdada_ForLoop_Aralik_Kontrolu::yazdir);
    }
    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void siralama1(int x){
        IntStream.rangeClosed(1,x).sorted().forEach(C6_Lambdada_ForLoop_Aralik_Kontrolu::yazdir);
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static void toplama1(int x,int y){
        System.out.println(IntStream.rangeClosed(x, y).reduce(0, (a, b) -> a + b));

    }
    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static void ortalamasini(int x,int y){
        System.out.println(IntStream.rangeClosed(30, 40).average().orElseThrow());
    }
    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static void bolunen(int x,int y){
        System.out.println(IntStream.range(325, 468).filter(t -> t % 8 == 0).count());
    }
    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void yazdiralim(int x,int y){
         IntStream.range(325, 468).filter(t ->t%8==0).forEach(C6_Lambdada_ForLoop_Aralik_Kontrolu::yazdir);
    }

    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static int toplamini(int x,int y){
        return IntStream.range(325, 468).filter(t -> t % 8 == 0).sum();
    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static int carpim(int x,int y){
        return IntStream.
                range(8,15).
                filter(t -> t%2!=0).
                reduce(Math::multiplyExact).
                orElseThrow();
    }

    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void elemanin(int x,int y){
         IntStream.range(x,y).filter(t -> t%2!=0).limit(20).forEach(C6_Lambdada_ForLoop_Aralik_Kontrolu::yazdir);
    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void tekyazdir(int x){
        IntStream.iterate(21,t->t+7).filter(t -> t%7==0 && t%2!=0 ).limit(10).forEach(C6_Lambdada_ForLoop_Aralik_Kontrolu::yazdir);
    }


    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static int toplayalim(int x){
        return IntStream.iterate(21,t->t+7).filter(t -> t%7==0).limit(20).sum();
    }

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz