package de.liquiddev.command.autocomplete;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Autocomplete {
	private Autocomplete() {
	}

	public static <T> Autocompleter<T> completeText(String... text) {
		return new TextAutocompleter<T>(text);
	}

	public static <T> Autocompleter<T> completeText(List<String> text) {
		return new TextAutocompleter<T>(text);
	}

	public static <T> Autocompleter<T> complete(Collection<T> array) {
		return new StatelessAutocompleter<>(() -> array);
	}

	public static <T, R> Autocompleter<T> complete(Collection<R> array, Function<R, String> mapFunction) {
		return new StatelessAutocompleter<>(() -> array, mapFunction);
	}

	public static <T, R> Autocompleter<T> complete(Supplier<Collection<R>> supplier) {
		return new StatelessAutocompleter<>(supplier);
	}

	public static <T, R> Autocompleter<T> complete(Supplier<Collection<R>> supplier, Function<R, String> mapFunction) {
		return new StatelessAutocompleter<>(supplier, mapFunction);
	}

	@SuppressWarnings("rawtypes")
	public static <T> Autocompleter<T> completePlayers() {
		return new PlayerAutocompleter();
	}

	@SuppressWarnings("rawtypes")
	public static <T> Autocompleter<T> completeProxyPlayers() {
		return new ProxyPlayerAutocompleter();
	}

	public static <T> Autocompleter<T> none() {
		return (t, s) -> Collections.emptyList();
	}
}