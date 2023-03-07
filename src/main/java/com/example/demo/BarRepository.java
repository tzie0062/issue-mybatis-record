package com.example.demo;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BarRepository {
	Optional<Bar> findById(Long id);
}
