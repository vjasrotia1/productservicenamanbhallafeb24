package com.scaler.productservicenamanbhallafeb24.repositories;

import com.scaler.productservicenamanbhallafeb24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//findByTitle is a custom query
    /*
    find means select
    By means where
    Title means field in the 'Category' entity
    query wil be like Select * from Category where = ?
    ? is replaced by method param (title) at Runtime
     */
Category findByTitle(String title);

}
