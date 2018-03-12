package net.fakstory.template.client;

import net.fakstory.template.TemplateMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.fakstory.template.item.ModItems;

public class TemplateTab extends CreativeTabs {

	public TemplateTab() {
		super(TemplateMod.modId);
		setBackgroundImageName("templatemod.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.ingotCopper);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
