package com.example.demo.repository;

import com.example.demo.entity.TestYang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by lichenxing on 2017/2/15.
 */
public interface TestYangRepository extends JpaRepository<TestYang, Long> {

    TestYang findById(int id);

    @Query(nativeQuery = true, value = "select rownum rn,a.* from test_yang a where name =?1")
    TestYang findByaID(String name);
}
