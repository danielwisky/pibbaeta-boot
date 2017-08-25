package br.com.danielwisky.pibbaeta.firebase;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mensagem {

	private final Map<String, Object> data = new HashMap<>();
	private String to;

	public Mensagem() {
		super();
	}

	public Mensagem(String to) {
		super();
		this.to = to;
	}

	public Map<String, Object> getData() {
		return Collections.unmodifiableMap(data);
	}

	public void put(String key, Object value) {
		data.put(key, value);
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}