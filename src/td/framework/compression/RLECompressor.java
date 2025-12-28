package td.framework.compression;

import java.util.ArrayList;
import java.util.List;

public class RLECompressor implements Compressor {
    @Override
    public int[] compress(int[] data) {
        if (data == null || data.length == 0)
            return data;

        List<Integer> c = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
            int v = data[i], n = 1;
            while (i + n < data.length && data[i + n] == v && n < 255)
                n++;
            c.add(v);
            c.add(n);
            i += n;
        }
        return c.stream().mapToInt(Integer::intValue).toArray();
    }
}
