package td.framework.compression;

import java.util.ArrayList;
import java.util.List;

public class SimpleCompressor implements Compressor {
    @Override
    public int[] compress(int[] data) {
        if (data == null || data.length == 0)
            return data;

        List<Integer> c = new ArrayList<>();
        for (int v : data)
            if (v != 0)
                c.add(v);
        return c.stream().mapToInt(Integer::intValue).toArray();
    }
}
