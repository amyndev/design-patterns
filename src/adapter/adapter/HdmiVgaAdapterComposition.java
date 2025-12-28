package adapter.adapter;

import adapter.computer.HDMI;
import adapter.computer.VGA;

public class HdmiVgaAdapterComposition implements VGA {
    private HDMI hdmi;

    @Override
    public void print(String message) {
        System.out.println("----------- Adapter ------------");
        byte[] data = message.getBytes();
        hdmi.view(data);
        System.out.println("----------- Adapter ------------");
    }

    public void setHdmi(HDMI hdmi) {
        this.hdmi = hdmi;
    }
}
