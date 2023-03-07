package com.example.demo;

public class Bar {
	private final Long id;
	private final String name;

	public Bar(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
