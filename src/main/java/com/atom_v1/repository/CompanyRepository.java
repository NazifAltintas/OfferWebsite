package com.atom_v1.repository;

import com.atom_v1.data.MasterCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<MasterCompany,Long> {
}
