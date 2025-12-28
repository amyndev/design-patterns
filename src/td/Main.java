package td;

import td.framework.ImageFramework;
import td.framework.filter.*;
import td.framework.compression.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ImageFramework fw = new ImageFramework();

        System.out.println("Select Filter:\n1. GrayscaleFilter\n2. InvertFilter\n3. Adapter (Legacy)");
        String f = s.nextLine().trim();
        Filter selectedFilter = null;
        switch (f) {
            case "1":
                selectedFilter = new GrayscaleFilter();
                break;
            case "2":
                selectedFilter = new InvertFilter();
                break;
            case "3":
                System.out.print("Legacy op (brighten/darken): ");
                selectedFilter = new FilterAdapter(s.nextLine().trim());
                break;
        }
        if (selectedFilter != null)
            fw.setFilter(selectedFilter);

        System.out.println("Select Compressor:\n1. RLECompressor\n2. SimpleCompressor");
        String c = s.nextLine().trim();
        Compressor selectedComp = null;
        switch (c) {
            case "1":
                selectedComp = new RLECompressor();
                break;
            case "2":
                selectedComp = new SimpleCompressor();
                break;
        }
        if (selectedComp != null)
            fw.setCompressor(selectedComp);

        int[] img = new int[100];
        Arrays.fill(img, 0xFFFFFFFF);
        int[] res = fw.process(img);
        System.out.println("Result size: " + res.length);
        s.close();
    }
}
