package co.nidmight.blighttweaks.common.network.packet;

import java.nio.charset.Charset;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class ToggleArmorBoost implements IMessage {

    private boolean toggle;
    private int usernameLength;
    private String username;

    public ToggleArmorBoost() {}

    public ToggleArmorBoost(boolean toggle, int usernameLength, String username) {
        this.toggle = toggle;
        this.usernameLength = usernameLength;
        this.username = username;
    }

    @Override
    public void fromBytes(ByteBuf buf) {

        toggle = buf.readBoolean();
        usernameLength = buf.readInt();
        username = buf.readBytes(usernameLength)
            .toString(0, usernameLength, Charset.defaultCharset());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(toggle);
        buf.writeInt(usernameLength);
        buf.writeBytes(username.getBytes());
    }

    public boolean getToggle() {
        return toggle;
    }

    public String getUsername() {
        return username;
    }
}
