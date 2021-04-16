package mk.ukim.finki.lab2emt.repository;

import mk.ukim.finki.lab2emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
