package lambda_practice;

import java.util.Arrays;
import java.util.List;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz
public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL = Arrays.asList(-2, -8, -5, 2, 5, 6, 7, 15, 6, 8);
        teklerinArasinaBosluklu(intL);
        System.out.println();
        ciftlerinCarpimi(intL);
        System.out.println();
        negatiflerinKareToplami(intL);
        System.out.println();
        pozKupleri(intL);
    }
    public static void yazdir(int a) {
        System.out.print(a + " ");
    }
    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void teklerinArasinaBosluklu(List<Integer> intL) {
        intL.stream()
                .filter(t -> t % 2 != 0)
                .forEach(C4_Method_Refarance_Int::yazdir);
    }
    // S2: ciftlein carpimini bulalim
    public static void ciftlerinCarpimi(List<Integer> intL) {
        System.out.println(intL.stream()
                .filter(t -> t % 2 == 0).
                reduce(Math::multiplyExact).
                orElseThrow());
    }
    // S3: negatiflerin kare toplamlarini  bulalim
    public static void negatiflerinKareToplami(List<Integer> intL) {
        System.out.println(intL.
                stream().
                filter(t -> t < 0).
                map(t -> t * t).
                reduce(Math::addExact).
                orElseThrow());
    }
    // S4: poziflerin kuplerinden max yazdiralim
    public static void pozKupleri(List<Integer> intL) {
        System.out.println(intL.
                stream().
                filter(t -> t > 0).
                map(t -> t * t * t).
                reduce(Math::max).
                orElseThrow());
    }
}