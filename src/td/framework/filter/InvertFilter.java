package td.framework.filter;

public class InvertFilter implements Filter {
    @Override
    public int[] filter(int[] data) {
        if (data == null)
            return null;
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int p = data[i];
            result[i] = (p & 0xFF000000) | ((255 - ((p >> 16) & 0xFF)) << 16) |
                    ((255 - ((p >> 8) & 0xFF)) << 8) | (255 - (p & 0xFF));
        }
        return result;
    }
}
