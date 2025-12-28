package td.framework;

import td.framework.compression.Compressor;
import td.framework.filter.Filter;

public class ImageFramework {
    private Filter filter;
    private Compressor compressor;

    public void setFilter(Filter f) {
        this.filter = f;
    }

    public void setCompressor(Compressor c) {
        this.compressor = c;
    }

    public int[] process(int[] data) {
        if (filter != null)
            data = filter.filter(data);
        if (compressor != null)
            data = compressor.compress(data);
        return data;
    }
}
