package td.framework.filter;

import td.framework.legacy.ImplNonStandard;

public class FilterAdapter implements Filter {
    private ImplNonStandard legacy = new ImplNonStandard();
    private String name;

    public FilterAdapter(String name) {
        this.name = name;
    }

    @Override
    public int[] filter(int[] data) {
        return legacy.appliquerFiltre(name, data);
    }
}
