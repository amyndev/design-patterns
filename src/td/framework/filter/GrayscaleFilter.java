package td.framework.filter;

public class GrayscaleFilter implements Filter {
    @Override
    public int[] filter(int[] data) {
        if (data == null)
            return null;
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int p = data[i];
            int gray = (int) (0.299 * ((p >> 16) & 0xFF) + 0.587 * ((p >> 8) & 0xFF) + 0.114 * (p & 0xFF));
            result[i] = (p & 0xFF000000) | (gray << 16) | (gray << 8) | gray;
        }
        return result;
    }
}
