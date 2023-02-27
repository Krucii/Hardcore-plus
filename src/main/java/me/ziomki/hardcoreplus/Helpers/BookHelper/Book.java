package me.ziomki.hardcoreplus.Helpers.BookHelper;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Book {

    private ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
    BookMeta bookMeta = (BookMeta) book.getItemMeta();

    public Book(String author, String title) {
        assert bookMeta != null;
        bookMeta.setAuthor(author);
        bookMeta.setTitle(title);
    }

    public void addPage(String text) {
        BaseComponent[] components = ComponentSerializer.parse(ComponentSerializer.toString(
                new TextComponent(text)));
        bookMeta.spigot().addPage(components);
    }

    public ItemStack getItemStack() {
        book.setItemMeta(bookMeta);
        return book;
    }

}
