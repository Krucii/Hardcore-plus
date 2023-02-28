package me.ziomki.hardcoreplus.Helpers.BookHelper;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.util.ArrayList;

public class Page {

    ArrayList<BaseComponent[]> components = new ArrayList<>();
    ComponentBuilder cb = new ComponentBuilder();

    public void addText(String text) {
        cb.append(text + "\n");
    }

    public BaseComponent[] getPage() {
        return cb.create();
    }

}
