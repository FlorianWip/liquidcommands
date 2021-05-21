package de.liquiddev.command.autocomplete;

import java.util.Collection;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

class PlayerAutocompleter<T extends CommandSender> implements Autocompleter<T> {

	@Override
	public Collection<String> autocomplete(CommandSender sender, String startsWith) {
		String lowercase = startsWith.toLowerCase();
		return Bukkit.getOnlinePlayers().stream().map(p -> p.getName()).filter(n -> n.toLowerCase().startsWith(lowercase)).collect(Collectors.toList());
	}
}