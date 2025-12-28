package td.framework.legacy;

public class ImplNonStandard {
    public int[] appliquerFiltre(String filterName, int[] data) {
        if (data == null)
            return null;
        int[] res = new int[data.length];
        int offset = filterName.equalsIgnoreCase("brighten") ? 50 : filterName.equalsIgnoreCase("darken") ? -50 : 0;

        for (int i = 0; i < data.length; i++) {
            int p = data[i];
            int r = Math.min(255, Math.max(0, ((p >> 16) & 0xFF) + offset));
            int g = Math.min(255, Math.max(0, ((p >> 8) & 0xFF) + offset));
            int b = Math.min(255, Math.max(0, (p & 0xFF) + offset));
            res[i] = (p & 0xFF000000) | (r << 16) | (g << 8) | b;
        }
        return res;
    }
}
