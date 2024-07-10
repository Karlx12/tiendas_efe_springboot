package santa.sistemas.tiendas_efe_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santa.sistemas.tiendas_efe_springboot.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
