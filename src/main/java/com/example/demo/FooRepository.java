package com.example.demo;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FooRepository {
	Optional<Foo> findById(Long id);
}
