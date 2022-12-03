package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface  ProductRepository  extends JpaRepository<Product, Long> {
     Page<Product> findAllByUserId(Long userId, Pageable pageable);
     Optional<Product> findByIdAndUserId(Long id, Long userId);
     Page<Product> findAll(Pageable pageable);
}