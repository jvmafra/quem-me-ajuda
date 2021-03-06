package qma.ajuda;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AjudaRepository extends JpaRepository<Ajuda, Long>{
	
}
