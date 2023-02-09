package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class FooRepositoryTest {
	@Autowired
	private FooRepository repository;

	@Test
	@Sql(statements = { "insert into example.foo (id, name) values (123, 'test')" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	void findById() {
		Optional<Foo> res = repository.findById(123L);
		Foo foo = res.orElse(null);
		assertNotNull(foo);
		assertEquals(123L, foo.id());
		assertEquals("test", foo.name());
	}
}