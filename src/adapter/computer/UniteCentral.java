package adapter.computer;

public class UniteCentral {

    private VGA vga;

    public void print(String message) {
        System.out.println("************** UniteCentral *****************");
        vga.print(message);
        System.out.println("************** UniteCentral *****************");
    }

    public void setVGA(VGA vga) {
        this.vga = vga;
    }
}
