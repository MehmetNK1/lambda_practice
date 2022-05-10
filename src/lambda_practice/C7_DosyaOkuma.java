package lambda_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/*
dosya eklemek icin 2 yol var
1) Files.lines(Path.of("path")  buradan stream e eklemek icin
Stream <String> satir=Files.lines(Path.of(".........."));
bu bize tekrardan stream tanimlamadan kullanmayi saglar
2) //Files.lines(Paths.get("..........")).  kullanilir
==========================================================
intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
sonrasinda copy path seciyoruz bundan sonra iki secenek var
1) absolute path seciyoruz yada
2) path from content root seciyoruz
her ikisinde de path kopyalamis oluyoruz

cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
*/
public class C7_DosyaOkuma {
    public static void main(String[] args) throws IOException {
        Stream<String> satir= Files.lines(Path.of("src/lambda_practice/C7_TextFile"));
        //NOT PATH cift tirnak icine alinmali
        //artik stream e donustu methodlari kullanabiliriz

    // S1: Yazdiralim
        System.out.println("\nS1 sadece yazdirma--");
        satir.forEach(System.out::println);
    //S2: tum harflari buyuk harf ile yazdiralim
        System.out.println("\ns2 tum harfler buyuk--");
        Files.lines(Paths.get("src/lambda_practice/C7_TextFile"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    // S3: son satiri buyuk harfle yazdiralim
        System.out.println("\ns3 son satir buyuk harf--");
        Files.lines(Paths.get("src/lambda_practice/C7_TextFile"))
                .map(String::toUpperCase)
                .skip(4)
                .forEach(System.out::println);
    //S4: 2.ve 3. satirlari yazdiralim
        System.out.println("\ns4 2.ve 3. yardir---");
        Files.lines(Paths.get("src/lambda_practice/C7_TextFile"))
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
    //S5: kac tane "icin" kelimesi vardir
        System.out.println("\ns5 kac tane icin---");
        System.out.println(Files.lines(Paths.get("src/lambda_practice/C7_TextFile"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .filter(t -> t.contains("icin"))
                .count());
    //S6: tum kelimelerin tum kelimeleri natural order  yazdiriniz.
        System.out.println("\ns6 natiral yaz---");
        Files.lines(Paths.get("src/lambda_practice/C7_TextFile"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .sorted()
                .forEach(System.out::println);
    // S7:  metinde kac tane "a"  vardir
        System.out.println("\ns7 kac tane---");
        System.out.println(Files.lines(Paths.get("src/lambda_practice/C7_TextFile"))
                .map(t -> t.split(""))// bosluk olursa kelime sayisi hiclik olursa harf sayisi
                .flatMap(Arrays::stream)
                .filter(t -> t.contains("a"))
                .count());
    }
}
