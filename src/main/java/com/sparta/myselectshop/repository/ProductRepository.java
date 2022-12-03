package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface  ProductRepository  extends JpaRepository<Product, Long> {
     List<Product> findAllByUserId(Long userId);
     Optional<Product> findByIdAndUserId(Long id, Long userId);
}