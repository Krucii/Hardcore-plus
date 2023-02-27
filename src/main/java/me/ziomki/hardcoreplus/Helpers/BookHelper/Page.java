package me.ziomki.hardcoreplus.Helpers.BookHelper;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.util.ArrayList;

public class Page {

    ArrayList<BaseComponent[]> components;

    public void addText(String text) {
        components.add(ComponentSerializer.parse(ComponentSerializer.toString(
                new TextComponent(text))));
    }

    public BaseComponent[] getPage() {
        BaseComponent[] ret = new BaseComponent[components.size()];
        ret = components.toArray(ret);
        return ret;
    }

}
