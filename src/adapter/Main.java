package adapter;

import adapter.adapter.HdmiVgaAdapterComposition;
import adapter.adapter.HdmiVgaAdapterHeritage;
import adapter.computer.*;

public class Main {
    public static void main(String[] args) {
        UniteCentral uniteCentral = new UniteCentral();
        System.out.println("=== VGA devices ===");
        setAndPrint(uniteCentral, new Ecran(), "Bonjour");
        setAndPrint(uniteCentral, new VideoProjecteur(), "Bonjour");

        System.out.println("=== HDMI via Adapter (composition) ===");
        HdmiVgaAdapterComposition hdmiVgaAdapter = new HdmiVgaAdapterComposition();
        hdmiVgaAdapter.setHdmi(new TV());
        setAndPrint(uniteCentral, hdmiVgaAdapter, "Adapter Design Pattern");

        System.out.println("=== HDMI via Adapter (héritage) ===");
        HdmiVgaAdapterHeritage hdmiVgaAdapterHeritage = new HdmiVgaAdapterHeritage();
        setAndPrint(uniteCentral, hdmiVgaAdapterHeritage, "Test heritage adapter");

        System.out.println("=== SuperVP direct (implémente VGA & HDMI) ===");
        setAndPrint(uniteCentral, new SuperVP(), "Hello");

        System.out.println("=== SuperVP via composition adapter ===");
        HdmiVgaAdapterComposition hdmiVgaAdapter2 = new HdmiVgaAdapterComposition();
        hdmiVgaAdapter2.setHdmi(new SuperVP());
        setAndPrint(uniteCentral, hdmiVgaAdapter2, "Bonsoir");
    }

    private static void setAndPrint(UniteCentral uc, VGA device, String message) {
        uc.setVGA(device);
        uc.print(message);
    }
}
