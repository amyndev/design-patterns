package adapter;

import adapter.adapter.HdmiVgaAdapterComposition;
import adapter.adapter.HdmiVgaAdapterHeritage;
import adapter.computer.*;

public class Main {
    public static void main(String[] args) {
        UniteCentral uniteCentral = new UniteCentral();
        uniteCentral.setVGA(new Ecran());
        uniteCentral.print("Bonjour");
        uniteCentral.setVGA(new VideoProjecteur());
        uniteCentral.print("Bonjour");


        HdmiVgaAdapterComposition hdmiVgaAdapter = new HdmiVgaAdapterComposition();
        hdmiVgaAdapter.setHdmi(new TV());
        uniteCentral.setVGA(hdmiVgaAdapter);
        hdmiVgaAdapter.print("Adapter Design Pattern");

        HdmiVgaAdapterHeritage hdmiVgaAdapterHeritage = new HdmiVgaAdapterHeritage();
        uniteCentral.setVGA(hdmiVgaAdapterHeritage);
        hdmiVgaAdapter.print("TEST");


        uniteCentral.setVGA(new SuperVP());
        uniteCentral.print("Hello");

        HdmiVgaAdapterComposition hdmiVgaAdapter2 = new HdmiVgaAdapterComposition();
        hdmiVgaAdapter2.setHdmi(new SuperVP());
        uniteCentral.setVGA(hdmiVgaAdapter2);
        uniteCentral.print("Bonsoir");
    }
}
