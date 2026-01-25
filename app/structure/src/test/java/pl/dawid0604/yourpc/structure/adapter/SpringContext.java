/* Copyright 2026 YourPc */
package pl.dawid0604.yourpc.structure.adapter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "pl.dawid0604.yourpc.structure.adapter.out.persistence")
@EnableJpaRepositories(basePackages = "pl.dawid0604.yourpc.structure.adapter.out.persistence")
class SpringContext {}
