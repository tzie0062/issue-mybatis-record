package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class BarRepositoryTest {
	@Autowired
	private BarRepository repository;

	@Test
	@Sql(statements = { "insert into example.bar (id, name) values (444, 'Bart')" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	void findById() {
		Optional<Bar> res = repository.findById(123L);
		Bar bar = res.orElse(null);
		assertNotNull(bar);
		assertEquals(444L, bar.getId());
		assertEquals("Bart", bar.getName());
	}
}